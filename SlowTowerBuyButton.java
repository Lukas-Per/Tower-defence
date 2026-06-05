import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class SlowTowerBuyButton extends TransparentButton
{
    
    private Level world;
    
    
    
    private final TowerPlace place;
    
    public SlowTowerBuyButton (TowerPlace place) 
    {
        this.place = place;
    }
    
    public void act ()
    {
        super.act();
        this.isLocked = this.world.getGold()<SlowTower.price;
    }
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        this.isLocked = this.world.getGold()<SlowTower.price;
    
    }
    
    
    
    @Override
    public void onClicked()
    {
        if(!isLocked && world.getGold()>=SlowTower.price)
        {
            world.addObject(new SlowTower(place), place.getX(), place.getY());
            world.addGold(-SlowTower.price);
            place.setOcupied(true);      
        }
    
    }
}
