public class _9_14_24_Longest_Subarray_With_Max_Bitwise_AND 
{
    public static int longestSubarray(int[] nums) 
    {
        int n = nums.length;
        int max = 0;
        int streak = 0,count = 0;
        for(int i=0;i<n;i++)
        {
            if(max < nums[i])
                max = nums[i];
        }
        for(int i=0;i<n;i++)
        {
            if(max == nums[i])
            {
                count++;
                streak=Math.max(streak,count);
            }
                else
                count=0;
            
        }
        return streak;
        
    }

    public static void main(String[] args) 
    {
        int[] nums = {3,3,3,3,3,3,3,3,2,3};
        System.out.println(longestSubarray(nums));
    }
    
}
