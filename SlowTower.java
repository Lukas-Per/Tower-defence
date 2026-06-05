import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

import java.util.List;
public class SlowTower extends Tower
{
    
    private int counter = 0;
    
    private Level world;
    
    private final TowerPlace place;
    
    public static final int price = 25;
    
    public SlowTower(TowerPlace place)
    {
        super(place);
        this.place = place;
        setTimer(60);
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
            
            if(place.isOcupied())
            {
                world.addObject(new SellWindow(place,price), 300, 560);
            }
                   
        }
        
        
        
    }
    
    @Override
    public void attack ()
    {
        List<Enemy> enemies = getObjectsInRange(150, Enemy.class);
        if (enemies==null||enemies.isEmpty())return;
        
        for(Enemy enemy:enemies)
        {
            
            if(enemy ==null)return;
            enemy.takeDamage(1);
            enemy.slowDown(2, 50);
            
        }
    }
}
