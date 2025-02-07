import java.util.*;

public class _2_7_25_Find_the_Number_of_Distinct_Colors_Among_the_Balls 
{
    public static int[] queryResults(int limit, int[][] queries) 
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        int res[] = new int[queries.length];
        

        for(int i=0;i<queries.length;i++)
        {
            int ball = queries[i][0];
            int color = queries[i][1];

            if(hm.containsKey(ball))
            {
                int prevColor = hm.get(ball);
                hm2.put(prevColor, hm2.get(prevColor)-1);
            

                if(hm2.get(prevColor) == 0)
                {
                    hm2.remove(prevColor);
                }      
            }      
            hm.put(ball,color);
            hm2.put(color,hm2.getOrDefault(color,0)+1);
            res[i] = hm2.size();
        }    
        return res;
    }
    public static void main(String[] args) 
    {
        int limit = 4;
        int[][] queries = {{0,1},{1,2},{2,2},{3,4},{4,5}};

        System.out.println(queryResults(limit, queries));
    }
    
}
