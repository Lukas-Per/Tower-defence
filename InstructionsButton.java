import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class InstructionsButton extends Button
{
    
    public InstructionsButton ()
    {
        setImages("instruction_button_glow.png", "instruction_button.png");
    
    
    }
    
    
    @Override
    protected void onClicked()
    {
        Greenfoot.setWorld(new Instructions());    
    
    
    }
    
}
