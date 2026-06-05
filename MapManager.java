import greenfoot.*;
import java.util.*;

public class MapManager 
{
   
    public MapManager()
    {
        
        
        
    }
    
    public static Cords convertIntToCords(int i)
    {
        i-=1;
        int row = (i/10);
        
        i = i - row*10;
        row++;

        return new Cords((i+1)*60-30,row*60-30);
    }
    
    public static List<Cords> convertListOfIntsToListOfCords(List<Integer> list)
    {
        List<Cords> cords = new ArrayList<>();  
        for (int i:list)
        {
            cords.add(convertIntToCords(i));
        }
        return cords;
    }
    
    
    public static HashMap<Integer,String> makePathTowards(HashMap<Integer,String> map,int currentTile,int tiles,String direction)
    {    
        map.put(currentTile,"path");
        for (int i=1;i<=tiles;i++)
        {
            switch (direction)
            {
                case"down":
                    map.put(currentTile+i*10,"path");
                    break;
                case"up":
                    map.put(currentTile-i*10,"path");
                    break;
                case "right":
                    map.put(currentTile+i,"path");
                    break;
                case"left":    
                    map.put(currentTile-i,"path");
                    break;
        
            }
        }
        return map;
    }
    

    
    
}
