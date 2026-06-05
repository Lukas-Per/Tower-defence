import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class TowerPlace extends Actor
{
    
    private Level world;
    
    private boolean ocupied = false;
    
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
    }
    
    
    
    
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            
    
            if(!ocupied)
            {
                world.addObject(new ShopWindow(this), 300, 560);
            }
                   
        }
        
    }
    
    public void removeTower()
    {
        removeTouching(Tower.class);
    }
    
    public void setOcupied(boolean b)
    {
        this.ocupied = b;
    }
    
    
    public boolean isOcupied()
    {
        return this.ocupied;
    }
}
