import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


import java.util.ArrayList;
import java.util.List;
public abstract class Enemy extends Actor
{
    
    protected final int startSpeed;
    protected int speed = 0;
    
    private int index = 0;
    
    protected int goldPerKill = 2;
    
    protected int lifes;
    
    protected final int startLifes;
    
    private int counter = 1;
    
    private int time = 0;
    
    protected Level world;
   
    public Enemy (int speed, int lifes)
    {
        this.speed = speed;
        this.startSpeed = speed;
        this.startLifes = lifes;

    }
    
    public void act()
    {
        updateLifes(startLifes);
        
        if(time!=0&&counter%time==0)
        {
            speed = startSpeed;
            counter = 0;
        }
        counter++;
        
    }
    
    @Override
    public void addedToWorld(World world) {
        this.world = (Level)getWorld();
        
    }
    
  
    protected void moveAlongPath(List<Cords> path)
    {
        if (index < path.size()) 
        {
    
            Cords cords = path.get(index);
            int targetX = cords.getX();
            int targetY = cords.getY();
    
            double dx = targetX - getX();
            double dy = targetY - getY();
            double distance = Math.sqrt(dx * dx + dy * dy);
    
            if (distance < speed) 
            {
                setLocation(targetX, targetY);
                index++;
            } 
            else 
            {
                // pohyb směrem k waypointu
                int newX = (int)(getX() + dx / distance * speed);
                int newY = (int)(getY() + dy / distance * speed);
                setLocation(newX, newY);
            }
    
        } 
        else 
        {   
            getWorld().removeObject(this);
        }
    }

    
    protected void updateLifes(int maxLifes) 
    {
        GreenfootImage img = new GreenfootImage(getImage());

        int barWidth = 50;
        int barHeight = 6;
        int x = (img.getWidth() - barWidth) / 2;
        int y = 2;
    
        double ratio = (double) lifes / maxLifes;
        int currentWidth = (int) (barWidth * ratio);
    
        
        img.setColor(Color.GRAY);
        img.fillRect(x, y, barWidth, barHeight);
        
        Color healthColor;
    
        if (maxLifes <= 15) 
        {
            healthColor = Color.GREEN;
        } 
        else if (maxLifes <= 30) 
        {
            healthColor = Color.YELLOW;
        } 
        else if (maxLifes <= 50) 
        {
            healthColor = Color.ORANGE;
        } 
        else 
        {
            healthColor = Color.RED;
        }
        
       
        img.setColor(healthColor);
        img.fillRect(x, y, currentWidth, barHeight);
    
        setImage(img);
    }
    
    public void slowDown(int by, int time)
    {
        speed -= by;
        this.time = time;
        counter = 1;
    }
    
    public void addLifes(int i)
    {
        lifes+=i;
    }
    
    public void takeDamage(int damage) {
        lifes -= damage;
        if (lifes <= 0) {
            world.addGold( goldPerKill);
            getWorld().removeObject(this);
        }
    } 
    
    public int getSpeed()
    {
        return speed;
    }
    

}
