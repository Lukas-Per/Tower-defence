import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BombScrap extends Actor
{
    private Level world;
    
    private int counter = 0;
    
    private final int direction;
    
    
    
    public BombScrap (int i)
    {
        this.direction = i;    
    }
    
    @Override
    protected void addedToWorld(World world) {
        this.world = (Level) getWorld();
        setRotation(direction);
        move(15);
    }

    public void act()
    {
        counter+=15;  
        move(10);
            
        
        
        if (counter >150||isAtEdge()){
            getWorld().removeObject(this);
            return;
        
        }
        
        
    
        
    }
}
