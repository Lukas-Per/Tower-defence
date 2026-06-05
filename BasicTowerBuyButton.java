import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class BasicTowerBuyButton extends TransparentButton
{
    
    private Level world;
    
    
    
    private final TowerPlace place;
    
    public BasicTowerBuyButton (TowerPlace place) 
    {
        this.place = place;
    }
    
    public void act ()
    {
        super.act();
        this.isLocked = this.world.getGold()<BasicTower.price;
    }
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        this.isLocked = this.world.getGold()<BasicTower.price;
    
    }
    
    
    
    @Override
    public void onClicked()
    {
        if(!isLocked && world.getGold()>=BasicTower.price)
        {
            world.addObject(new BasicTower(place), place.getX(), place.getY());
            world.addGold(-BasicTower.price);
            place.setOcupied(true);      
        }
    
    }
}
