import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



import java.util.List;
public class Cube extends Enemy
{
    
    
    public Cube (int lifes)
    {
        super(4,lifes);
        this.lifes = lifes;
        
        
    }
    
    
    public void act()
    {   
        super.act();
        moveAlongPath(MapManager.convertListOfIntsToListOfCords(world.data.path));
        if(isTouching(Bullet.class)){
            takeDamage(1);
            return;
        
        }
        
        if(isTouching(BombScrap.class)){
            takeDamage(3);
            return;
        }
    
        
    }
   
    

}
