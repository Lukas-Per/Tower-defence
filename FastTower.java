import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
public class FastTower extends Tower
{
    
    private int counter = 0;
    
    private Level world;
    
    private final TowerPlace place;
    
    public static final int price = 50;
    
    public FastTower(TowerPlace place)
    {
        super(place);
        this.place = place;
        setTimer(7);
    }
    
    @Override
    public void addedToWorld(World world) {
        this.world = (Level)getWorld();
    }
    
    
    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this))
        {
            
    
            if(place.isOcupied()){
                world.addObject(new SellWindow(place,price), 300, 560);
            }
                   
        }
        
    
    }
    
    @Override
    public void attack ()
    {
        List<Enemy> enemies = getObjectsInRange(150, Enemy.class);
        if (enemies==null||enemies.isEmpty())return;
        Enemy enemy = enemies.get(0);
            
        if(enemy ==null)return;
            
        turnTowards(enemy.getX(),enemy.getY());
        getWorld().addObject(new Bullet(new Cords(enemy.getX(),enemy.getY())), getX(), getY());    
    
    }
}
