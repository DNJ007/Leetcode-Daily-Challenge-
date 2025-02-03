public class _2_3_25_Longest_Strictly_Increasing_or_Strictly_Decreasing_Subarray 
{
    public static int longestMonotonicSubarray(int[] nums) 
    {
        int prev = nums[0];
        int max = 1;
        int maxinc = 1;
        int min = 1;
        int maxdec = 1;
        for(int i=1;i<nums.length;i++)
        {
            if(nums[i] > prev)
            {
                max++;
                maxinc = Math.max(max,maxinc);
                min = 1;
                
            }
            else if(nums[i] < prev)
            {
                min++;
                maxdec = Math.max(min,maxdec);
                max = 1;
            }
            else
            {
                max = 1;
                min = 1;
            }
            prev = nums[i];
        }
        //System.out.println(maxinc+" "+maxdec);
        return Math.max(maxinc,maxdec);
    }

    public static void main(String[] args) {
        int[] nums = {1,4,3,3,2};
        System.out.println(longestMonotonicSubarray(nums));
    }
    
}
