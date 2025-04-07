public class _4_7_25_Partition_Equal_Subset_Sum 
{
    private static boolean solve(int i,int nums[],int currSum,int sum,int n,int Sum,Boolean[][] dp)
    {
        if(currSum == sum)
        {
            return true;
        }
        if(i >= n || currSum > Sum/2)
        {
            return false;
        }
        
        if (dp[i][currSum] != null) 
            return dp[i][currSum];
        
        boolean include= solve(i+1,nums,currSum+nums[i],Sum-(currSum+nums[i]),n,Sum,dp);
        boolean notInclude = solve(i+1,nums,currSum,sum,n,Sum,dp);

        return dp[i][currSum] = include || notInclude;
    }
    public static boolean canPartition(int[] nums) 
    {
        int sum = 0;
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
        }
        int n = nums.length;
        if (sum % 2 != 0) 
            return false;

        Boolean[][] dp = new Boolean[nums.length][sum];

        if(solve(0,nums,0,sum,n,sum,dp))
            return true;
        
        return false;
    }

    public static void main(String[] args) 
    {
        int[] nums = {1,5,11,5};
        System.out.println(canPartition(nums));        
    }
}
