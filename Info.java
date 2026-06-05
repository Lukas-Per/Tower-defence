import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class Info extends Actor
{
    
    private Level world;
    
    private GreenfootImage image;
    
    public void act()
    {
       
        
        drawData();
    
    
       
    }
    
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        drawData();
    }
    
    
    
    private void drawData()
    {
    
        image = new GreenfootImage("info_background.png");
        
        
        GreenfootImage hearth = new GreenfootImage("hearth.png");
        int lifes = world.getLives();
        int heartY = (image.getHeight() - hearth.getHeight()) / 2;
        for(int i = 1; i <= lifes; i++) 
        {
            image.drawImage(hearth, -10 + (i * 20), heartY); 
        }
        
        
        GreenfootImage coin = new GreenfootImage("coin.png");
        coin.scale(40, 40);
        int coinX = 510 - coin.getWidth() / 2;
        int coinY = (image.getHeight() - coin.getHeight()) / 2;
        image.drawImage(coin, coinX, coinY);
        
        
        Font myFont = new Font("Arial", true, false, 24); 
        image.setFont(myFont);
        image.setColor(Color.BLACK);
        
        
        int textY = image.getHeight() / 2+8;
        int textX = 530;
       
        
        image.drawString("" + world.getGold(), textX, textY);
        
        
        int waveX = 370;
        
        image.drawString("Wave:" + world.getCurrentWave()+"/"+world.data.waves.size(), waveX, textY);
        
        
        setImage(image);
    }
    
    
}
