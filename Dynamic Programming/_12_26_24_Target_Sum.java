import java.util.*;
public class _12_26_24_Target_Sum 
{
    static int S;
    private static int solve(int[] nums,int idx,int sum,int target,int[][] dp)
    {
        if(idx == nums.length)
        {
            if(sum == target)
            {
                return 1;
            }
            else
                return 0;
        }
        if(dp[idx][sum+S]!=-1)
        {
            return dp[idx][sum+S];
        }
        int plus = solve(nums,idx+1,sum+nums[idx],target,dp);
        int minus = solve(nums,idx+1,sum-nums[idx],target,dp);

        return dp[idx][sum+S]=plus+minus;
        
    }
    public static int findTargetSumWays(int[] nums, int target) 
    {
       
        for(int i=0;i<nums.length;i++)
        {
            S+=nums[i];
        }
        int[][] dp =new int[nums.length+1][2*S+1];
        for(int[] a : dp)
        {
            Arrays.fill(a,-1);
        }
        return solve(nums,0,0,target,dp);
        
    }

    public static void main(String[] args) {
        int[]nums = {1,1,1,1,1};
        int target = 3;
        System.out.println(findTargetSumWays(nums, target));
    }
    
}
