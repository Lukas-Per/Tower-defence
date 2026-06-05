import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)



public class LevelButton extends Button
{
    private final int levelNumber;
    
    private boolean isLocked=true;
    
    public LevelButton (int levelNumber)
    {
        this.levelNumber = levelNumber;
        if(levelNumber<=LevelManager.getReachedLevel())
        {
            isLocked = false;
        
        }
        
        setImage("level"+levelNumber+"_button.png");
        setImages("level"+levelNumber+"_button_glow.png", "level"+levelNumber+"_button.png");
        //setSound("hover.mp3");
        
    }
    public void act()
    {
       super.act();
       updateAppearance();
       
    }
    
    private void updateAppearance() 
    {
        
        GreenfootImage btnImg = new GreenfootImage("level"+levelNumber+"_button.png"); 
        
        if (isLocked) {
            
            GreenfootImage lockImg = new GreenfootImage("lock.png");
            
            lockImg.scale(50,50);
           
            int x = (btnImg.getWidth() - lockImg.getWidth()) / 2;
            int y = (btnImg.getHeight() - lockImg.getHeight()) / 2;
            
            
            btnImg.drawImage(lockImg, x, y);
            setImage(btnImg);
        } 
           
            
        

        
    }
    
    @Override
    protected void onClicked()
    {
        if(isLocked)return;
        Greenfoot.setWorld(new Level(LevelManager.levels.get(levelNumber)));
    
    
    }
    
    @Override
    protected void onHoverStart()
    {
        if(isLocked)return;
        super.onHoverStart();
    }
}
