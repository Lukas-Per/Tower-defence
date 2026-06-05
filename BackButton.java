import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class BackButton extends Button
{
    
    private final World world;
    
    public BackButton(World world)
    {
        this.world = world;
        setImages("back_button_glow.png", "back_button.png");
    }
    
    @Override
    public void onClicked ()
    {
        Greenfoot.setWorld(world);    
    
    
    
    }
    
}
