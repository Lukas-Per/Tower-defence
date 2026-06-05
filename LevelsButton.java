import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class LevelsButton extends Button
{
   
    public LevelsButton ()
    {

        setImages("play_button_glow.png", "play_button.png");
    
    }
    
    
    
    @Override
    protected void onClicked()
    {
        Greenfoot.setWorld(new LevelMenu());    
        
        
    }
}
