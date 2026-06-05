import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Bullet extends Actor
{
    private Level world;
    
    private int counter = 0;
    
    private final Cords cords;
    
    
    
    public Bullet (Cords cords)
    {
        this.cords=cords;    
    }
    
    @Override
    protected void addedToWorld(World world) {
        this.world = (Level) getWorld();
        turnTowards(cords.getX(), cords.getY());
        move(15);
    }

    public void act()
    {
        counter+=7;  
        move(10);
  
        if (counter >150||isAtEdge()){
            getWorld().removeObject(this);
            return;
        
        }
        

        
    }
}
