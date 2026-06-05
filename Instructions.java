import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Instructions extends World
{

   
    public Instructions()
    {            
        super(600, 600, 1);
        int height = getHeight();
        int width = getWidth();
        
        
        addObject(new BackButton(new MainMenu()), width/2,height-50 );
    }
}
