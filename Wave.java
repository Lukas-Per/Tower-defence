import java.util.List;
import java.util.ArrayList;

public class Wave  
{
   
    public List<EnemySpawnInfo> spawns = new ArrayList<>();

    public void addEnemy(Enemy enemy, int delay) {
        spawns.add(new EnemySpawnInfo(enemy, delay));
    }
    
    
}
