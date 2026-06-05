import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class ShopWindow extends Window
{
    public ShopWindow (TowerPlace towerPlace)
    {
        buttons.put(new BasicTowerBuyButton(towerPlace),new Cords(width/5,height/2+10));
        buttons.put(new SlowTowerBuyButton(towerPlace),new Cords(width/5*2,height/2+10));
        buttons.put(new BombTowerBuyButton(towerPlace),new Cords(width/5*3,height/2+10));
        buttons.put(new FastTowerBuyButton(towerPlace),new Cords(width/5*4,height/2+10));
  
    
    }
    
    
}
