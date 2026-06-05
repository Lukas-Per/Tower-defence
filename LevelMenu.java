import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class LevelMenu extends World
{

    /**
     * Constructor for objects of class Menu.
     * 
     */
    public LevelMenu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600,400, 1);
        LevelManager.loadLevelsData();
        int height = getHeight();
        int width = getWidth();
        
        addObject(new LevelButton(1), width/4, height/2);
        addObject(new LevelButton(2), width/4*3, height/2);
        addObject(new BackButton(new MainMenu()), width/2,height-50 );
    }
}
