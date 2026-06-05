import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Tower here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Tower extends Actor
{
    
    protected final TowerPlace place;
    
    private int counter = 1;
    
    private int timer = 0;
    
    public Tower (TowerPlace place) 
    {
        this.place = place;
    }
    
    
    public void act ()
    {
        
        if(counter%timer==0)
        {
            attack();
            counter = 0;
        }
        counter++;
    }
    
    public void setTimer(int i)
    {
        this.timer = i;    
    }
    
    public void attack(){}
    
}
