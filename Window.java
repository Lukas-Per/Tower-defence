import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public abstract class Window extends Actor
{
    
    protected HashMap<Button,Cords> buttons = new HashMap<>();
    
    protected boolean persistant = false;
    
    protected int width = getImage().getWidth();
    
    protected int height = getImage().getHeight();
    
    private boolean delete = false;
    
    public void act()
    {
        if(delete)
        {
            getWorld().removeObjects(buttons.keySet());
            getWorld().removeObject(this);   
        }
        
        if(!Greenfoot.mouseClicked(this)&&Greenfoot.mouseClicked(null)&&!persistant)
        {
            delete = true;
        }
        
    
    
    }
    
    @Override
    public void addedToWorld (World world)
    {
        
        loadButtons();
    
    }
    
    
    protected void loadButtons()
    {
        
        for(Button button:buttons.keySet())
        {
            loadButton(button,buttons.get(button));
        }
        
        
    }
    
    private void loadButton (Button button,Cords cords)
    {
        World world = getWorld();
        GreenfootImage image = getImage();
        
        int wx = getX()-(image.getWidth()/2);
        int wy = getY()-(image.getHeight()/2);
    
        world.addObject(button, wx+cords.getX(), wy+cords.getY());
    }
    
    
}
