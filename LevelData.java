import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class LevelData  
{
    
    
    public int startLives;
    
    public int startGold;
    
    public int maxWave;
    
    public final HashMap<Integer,String> map;
    
    public final List<Integer> path;
    
    public final List<Wave> waves;
    
    public LevelData(int lives, int gold, int maxWave, HashMap<Integer,String> map,List<Integer> path,List<Wave> waves )
    {
        this.startLives = lives;
        this.startGold = gold;
        this.maxWave = maxWave;
        this.map = map;
        this.path = path;
        this.waves = waves;
      
    }

    
   
}
