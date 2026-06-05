import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Base extends Actor
{
    private Level world;
    
    @Override
    public void addedToWorld(World world) 
    {
        this.world = (Level)getWorld();
    }
    
    
    public void act()
    {
        if(isTouching(Enemy.class))
        {
            removeTouching(Enemy.class);
            world.addLives(-1);           
        }
        
        
    }
}
