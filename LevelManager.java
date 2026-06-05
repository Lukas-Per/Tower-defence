import java.util.*;

public class LevelManager  
{
    private static int reachedLevel = 1;
    
    public static HashMap<Integer, LevelData> levels = new HashMap<>();
    
    

    public static int getReachedLevel() 
    {
        return reachedLevel;
    }
    
    public static void setReachedLevel(int i) 
    {
        reachedLevel = i;
    }
    
    
    public static void addReachedLevel(int i)
    {
        reachedLevel+=i;
    }
    
    public static void loadLevelsData() 
    {
        levels.put(1, createLevel1());
        levels.put(2, createLevel2());
    }

    private static LevelData createLevel1() 
    {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(31, "base");
        map.put(16, "tower_place");
        map.put(56, "tower_place");
        map.put(4, "tower_place");
        map.put(18, "tower_place");
        map.put(42, "tower_place");
        map.put(82, "tower_place");

        MapManager.makePathTowards(map, 10, 5, "left");
        MapManager.makePathTowards(map, 15, 6, "down");
        MapManager.makePathTowards(map, 74, 3, "left");
        MapManager.makePathTowards(map, 61, 2, "up");

        List<Wave> waves = new ArrayList<>();
        
        
        int[] hpScaling = {3, 6, 12, 18, 25, 32, 40};
        int[] countScaling = {5, 6, 8, 8, 10, 10, 12};

        for (int i = 0; i < 7; i++)
        {
            Wave w = new Wave();
            for (int j = 0; j < countScaling[i]; j++)
            {
                
                w.addEnemy(new Cube(hpScaling[i]), 35); 
            }
            waves.add(w);
        }

        List<Integer> path = List.of(10, 5, 75, 71, 31);
        return new LevelData(3, 10, waves.size(), map, path, waves);
    }

    private static LevelData createLevel2() 
    {
        HashMap<Integer, String> map = new HashMap<>();
        
        
        
        
        
        map.put(12, "tower_place");
        map.put(14, "tower_place");
        map.put(17, "tower_place");
        map.put(40, "tower_place");
        map.put(52, "tower_place");
        map.put(48, "tower_place");
        map.put(56, "tower_place");
        map.put(72, "tower_place");
        map.put(82, "tower_place");

        
        MapManager.makePathTowards(map, 1, 8, "right");
        MapManager.makePathTowards(map, 9, 4, "down");
        MapManager.makePathTowards(map, 49, 8, "left");
        MapManager.makePathTowards(map, 41, 5, "down");
        map.put(91, "base"); 
        List<Wave> waves = new ArrayList<>();
        
        
        for (int i = 0; i < 10; i++)
        {
            Wave w = new Wave();
            int hp = 10 + (i * 6); 
            int count = 6 + (i / 2);             
            for (int j = 0; j < count; j++)
            {
                w.addEnemy(new Cube(hp), 30); 
            }
            waves.add(w);
        }

        
        List<Integer> path = List.of(1,9, 49,41, 91);
        
        return new LevelData(5, 20, waves.size(), map, path, waves);
    }
    
}
