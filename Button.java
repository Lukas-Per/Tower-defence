import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public abstract class Button extends Actor
{
    
    protected boolean isHovering = false;
    
    protected String image1;
    
    protected String image2;
    
    protected String sound;
    
  
    public void act()
    {
        
        
        
        MouseInfo info = Greenfoot.getMouseInfo();
        if (info!=null){}
        
        if(Greenfoot.mouseClicked(this))
        {
            onClicked();
        }
        
        if(Greenfoot.mouseMoved(this)&&!isHovering)
        {
            isHovering = true;
            onHoverStart();
        }
        
        if(Greenfoot.mouseMoved(this))
        {
            isHovering = true;
            onHover();
        }
        if (Greenfoot.mouseMoved(null) && !Greenfoot.mouseMoved(this)) {
            isHovering = false;
            onHoverEnd();
        }
            
        
        
    }
    
    
    
    protected void setImages(String img1,String img2)
    {
        this.image1 = img1;
        this.image2 = img2;
    }
    
    
    
    protected void setSound(String sound)
    {
        this.sound = sound;
    }
    
    protected abstract void onClicked ();
    
    protected void onHover (){};
    
    protected void onHoverStart ()
    {
        if(image1!=null)
        {
            setImage(image1);
        }
        
        if(sound!=null)
        {
            Greenfoot.playSound(sound);
        }
    }
    
    protected void onHoverEnd ()
    {
        if(image2!=null)
        {
            setImage(image2);
        }
        
        
        
    }
    
}
