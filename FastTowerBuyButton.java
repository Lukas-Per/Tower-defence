import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)


public class FastTowerBuyButton extends TransparentButton
{
    
    private Level world;
    
    
    
    private final TowerPlace place;
    
    public FastTowerBuyButton (TowerPlace place) 
    {
        this.place = place;
    }
    
    public void act ()
    {
        super.act();
        this.isLocked = this.world.getGold()<FastTower.price;
    }
    
    @Override
    public void addedToWorld(World world)
    {
        this.world = (Level) getWorld();
        this.isLocked = this.world.getGold()<FastTower.price;
    
    }
    
    
    
    @Override
    public void onClicked()
    {
        if(!isLocked && world.getGold()>=FastTower.price)
        {
            world.addObject(new FastTower(place), place.getX(), place.getY());
            world.addGold(-FastTower.price);
            place.setOcupied(true);      
        }
    
    }
}
