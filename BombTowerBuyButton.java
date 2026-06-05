import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class BombTowerBuyButton extends TransparentButton
{
    
    private Level world;
    
    
    
    private final TowerPlace place;
    
    public BombTowerBuyButton (TowerPlace place) 
    {
        this.place = place;
    }
    
    public void act ()
    {
        super.act();
        this.isLocked = this.world.getGold()<BombTower.price;
    }
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        this.isLocked = this.world.getGold()<BombTower.price;
    
    }
    
    
    
    @Override
    public void onClicked()
    {
        if(!isLocked && world.getGold()>=BombTower.price)
        {
            world.addObject(new BombTower(place), place.getX(), place.getY());
            world.addGold(-BombTower.price);
            place.setOcupied(true);      
        }
    
    }
}
