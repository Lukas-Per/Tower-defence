import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SellButton extends Button
{
    
    private final TowerPlace towerPlace;
    private int something = 10;
    private Level world;
    
    private final int price;
    
    public SellButton (TowerPlace towerPlace,int price)
    {
        this.towerPlace = towerPlace;
        this.price = price;
    }
    
    
    
    @Override
    protected void onClicked()
    {
        towerPlace.removeTower();
        towerPlace.setOcupied(false);
        world.addGold(price);
    }
    
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        
    
    }
}
