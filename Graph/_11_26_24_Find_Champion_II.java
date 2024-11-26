import java.util.Arrays;

public class _11_26_24_Find_Champion_II 
{
    public static int findChampion(int n, int[][] edges) 
    {
        boolean[] flag = new boolean[n];
        Arrays.fill(flag,true);

        for(int i=0;i<edges.length;i++)
        {
            int dest = edges[i][1];
            if(flag[dest])
                flag[dest] = false;
        }

        int countT = 0;
        for(int i=0;i<flag.length;i++)
        {
            if(flag[i])
                countT++;
        }
        if(countT == 0 || countT > 1)
        {
            return -1;
        }
        int ans = -1;
        for(int i=0;i<flag.length;i++)
        {
            if(flag[i])
                ans = i;
        }
        return ans;

    }
    public static void main(String[] args) 
    {
        int n = 3;
        int[][] edges = {{0,1},{1,2}};
        System.out.println(findChampion(n, edges));
        
    }
}
