import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class MainMenu extends World
{

    
    public MainMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1);
        int height = getHeight();
        int width = getWidth();
        
        addObject(new InstructionsButton(), width/2-100, height/2+30);
        addObject(new LevelsButton(), width/2+100, height/2+30);
        
        
    }
    
    public void act()
    {
        if(LevelManager.getReachedLevel()>=3)
        {
            Greenfoot.setWorld(new WinWorld());
            LevelManager.setReachedLevel(1);
            Greenfoot.stop();
        }
    
    
    }
    
    @Override
    public void started ()
    {
        
        LevelManager.setReachedLevel(1);
    }
    
    
    
}
