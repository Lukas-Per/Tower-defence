import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Level extends World
{
    
    
    
    private int gold;
    private int lives;
    private int currentWave = 0;
    private int maxWave;
    
    
    public final LevelData data; 
    
    
    private int enemyIndex = 0;
    private int spawnTimer = 0;
    public boolean isSpawning = false;

    public Level(LevelData data)
    {    
        super(600, 660, 1);
        this.data = data;
        this.lives = data.startLives;
        this.gold = data.startGold;
        this.maxWave = data.maxWave;

        loadMap();
        
        addObject(new Info(), 300, 630);
        addObject(new NextWaveButton(), 300, 630);
    }

    public void act()
    {
        if (lives < 1)
        {
            Greenfoot.setWorld(new MainMenu());
        }
        if (!isSpawning && currentWave >= data.waves.size() && getObjects(Enemy.class).isEmpty())
        {
            Greenfoot.setWorld(new MainMenu());
            LevelManager.addReachedLevel(1);
        }
        
        handleSpawning();
    }

    public void startNextWave()
    {
        if (!isSpawning && currentWave < data.waves.size())
        {
            enemyIndex = 0;
            spawnTimer = 0;
            isSpawning = true;
            currentWave++;
        }
    }

    private void handleSpawning()
    {
        if (!isSpawning) 
        {
            return;
        }

        Wave wave = data.waves.get(currentWave-1);
        List<EnemySpawnInfo> spawns = wave.spawns;

        spawnTimer++;

        if (spawnTimer >= spawns.get(enemyIndex).delay)
        {
            Cords cords = MapManager.convertIntToCords( data.path.get(0) );   
            addObject(spawns.get(enemyIndex).enemy, cords.getX(), cords.getY()); 
            
            spawnTimer = 0;
            enemyIndex++;

            if (enemyIndex >= spawns.size())
            {
                isSpawning = false;
                
            }
        }
    }

    private void loadMap()
    {
        for(int i : data.map.keySet())
        {
            Cords cords = MapManager.convertIntToCords(i);
            if(cords.getX() >= getWidth() || cords.getY() >= getHeight()) continue;
            addObject(makeClass(data.map.get(i)), cords.getX(), cords.getY());
        }
    }
    
    public Actor makeClass(String string)
    {
        switch (string) 
        {
            case "path": return new Path();
            case "tower_place": return new TowerPlace();
            case "base": return new Base();
        }
        return null;
    }
    
    
    
    public int getGold (){
        return this.gold;
    
    }
    
    public void setGold (int i) {
        this.gold = i;
    }
    public void addGold (int i) {
        this.gold = gold+i;
    }
    
    public int getLives (){
        return this.lives;
    
    }
    
    public void setLives (int i) {
        this.lives = i;
    }
    public void addLives (int i) {
        this.lives = lives+i;
    }
    public int getCurrentWave(){
        return currentWave;
    }
    
}
