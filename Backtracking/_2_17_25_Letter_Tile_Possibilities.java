import java.util.*;

public class _2_17_25_Letter_Tile_Possibilities 
{
    public static int numTilePossibilities(String tiles) 
    {
        Set<String> hs = new HashSet<>();
        int n = tiles.length();
        boolean[] used = new boolean[n];

        solve(tiles,"",used,hs); 

        return hs.size()-1;
    }

    public static void solve(String tiles,String curr,boolean[] used,Set<String> hs)
    {
        hs.add(curr);

        for(int i=0;i<tiles.length();i++)
        {
            if(!used[i])
            {
                used[i] = true;
                solve(tiles,curr+tiles.charAt(i),used,hs);
                used[i] = false;
            }
        }
    }
    public static void main(String[] args) 
    {
        String tiles = "AAABBC";
        System.out.println(numTilePossibilities(tiles));
        
    }
}
