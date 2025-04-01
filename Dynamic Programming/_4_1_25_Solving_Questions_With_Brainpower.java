import java.util.Arrays;

public class _4_1_25_Solving_Questions_With_Brainpower 
{
    public static long solve(int i,int[][] q,int n,long[] dp)
    {
        if(i>=n)
        {
            return 0;
        }
        if(dp[i]!=-1)
        {
            return dp[i];
        }
        //include
        long include = q[i][0]+solve(i+q[i][1]+1,q,n,dp);

        //skip
        long skip = solve(i+1,q,n,dp);

        return dp[i] = Math.max(include,skip);
    }
    public static long mostPoints(int[][] questions) 
    {
        int n = questions.length;
        long[] dp = new long[n];
        Arrays.fill(dp,-1);
        return solve(0,questions,n,dp);
    }
    public static void main(String[] args) 
    {
        int[][]questions = {{3,2},{4,3},{4,4},{2,5}};
        System.out.println(mostPoints(questions));
    }    
}
