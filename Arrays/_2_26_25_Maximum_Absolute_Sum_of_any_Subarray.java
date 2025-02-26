public class _2_26_25_Maximum_Absolute_Sum_of_any_Subarray 
{
    public static int maxAbsoluteSum(int[] nums) 
    { 
        int sum = nums[0];
        int sum2 = nums[0];
        int maxSubarr = nums[0];
        int minSubarr = nums[0];
        for(int i=1;i<nums.length;i++)
        {
            sum = Math.max(nums[i],sum+nums[i]);          
            maxSubarr = Math.max(maxSubarr,sum);
        
            sum2 = Math.min(nums[i],sum2+nums[i]);          
            minSubarr = Math.min(minSubarr,sum2);
        }
        
        return Math.max(maxSubarr,Math.abs(minSubarr));
        
    }
    public static void main(String[] args) 
    {
        int[] nums = {2,-5,1,-4,3,-2};
        System.out.println(maxAbsoluteSum(nums));
    }    
}
