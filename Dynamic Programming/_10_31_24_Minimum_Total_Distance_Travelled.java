import java.util.*;
public class _10_31_24_Minimum_Total_Distance_Travelled 
{
    private static final long LARGE_VALUE = (long) 1e12;
    public static long solve(int ri,int fi,List<Integer> robot,List<Integer> Al,long[][] dp)
    {
        if(ri >= robot.size())
        {
            return 0;
        }

        if(fi >= Al.size())
        {
            return LARGE_VALUE;
        }

        if(dp[ri][fi] != -1)
        {
            return dp[ri][fi];
        }
        //take
        long take_curr_factory = Math.abs(robot.get(ri) - Al.get(fi)) + solve(ri+1,fi+1,robot,Al,dp);

        //skip
        long skip_curr_factory = solve(ri,fi+1,robot,Al,dp);

        return dp[ri][fi] = Math.min(take_curr_factory,skip_curr_factory);

    }
    public static long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        Collections.sort(robot);
        Arrays.sort(factory,(a,b) -> (Integer.compare(a[0],b[0])));

        int m = robot.size();
        ArrayList<Integer> Al = new ArrayList<>();

        for(int i=0;i<factory.length;i++)
        {
            int lim = factory[i][1];
            int pos = factory[i][0];

            for(int j=0;j<lim;j++)
            {
                Al.add(pos);
            }
        }

        int n =Al.size();
        long [][] dp = new long[m+1][n+1];

        for (long[] row : dp) Arrays.fill(row, -1);

        return solve(0,0,robot,Al,dp);
    }

    public static void main(String[] args) 
    {
        ArrayList<Integer> robot = new ArrayList<>();
        robot.add(0);
        robot.add(4);
        robot.add(6);

        int[][] factory = {{2,2},{6,2}};

        System.out.println(minimumTotalDistance(robot, factory));
        
    }
}
    

