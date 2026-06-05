import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SellWindow extends Window
{
    public SellWindow (TowerPlace towerPlace,int price)
    {   
        buttons.put(new SellButton(towerPlace,price),new Cords(width/2,height/2+10));
    
        
    }
}
