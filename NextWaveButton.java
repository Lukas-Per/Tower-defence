import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class NextWaveButton extends TransparentButton
{
    
    private Level world;
    
    private int price;
    
    public void act ()
    {
        super.act();
        this.isLocked = (world.isSpawning&&world.getCurrentWave()<=world.data.waves.size());
    }
    
    public NextWaveButton ()
    {
        
        setImages("next_button_glow.png", "next_button.png");
    }
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        this.isLocked = true;
        
    }
    
    @Override
    public void onClicked()
    {
        if(isLocked)return;
        world.startNextWave();
    }
}
