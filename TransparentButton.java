import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public abstract class TransparentButton extends Button
{
    protected boolean isLocked = true;
    
    
    public void act()
    {
        
        super.act();
        setTransparentIfLocked();
    
    
    }
    
    private void setTransparentIfLocked()
    {
        GreenfootImage image = getImage();
        
        if(isLocked)
        {
            image.setTransparency(125);
            setImage(image);
        
        
        }
        else if(image.getTransparency()<255)
        {
            image.setTransparency(255);
            setImage(image);
        }
        
    
    
    
    }
    
    
    @Override
    protected void onHoverStart()
    {
        if(isLocked)return;
        super.onHoverStart();
    }
    
    
    
    
}
