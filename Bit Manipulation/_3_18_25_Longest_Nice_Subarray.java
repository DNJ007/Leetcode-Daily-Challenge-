public class _3_18_25_Longest_Nice_Subarray 
{
    public static int longestNiceSubarray(int[] nums) 
    {
        int maxlen = 1;
        for(int i=0;i<nums.length;i++)
        {
            int and = 0; 
            for (int j = i; j < nums.length; j++) 
            {
                if ((and & nums[j]) != 0) 
                { 
                    break;
                }
                and |= nums[j]; 
                maxlen = Math.max(maxlen, j - i + 1);
            }      
        }        
        return maxlen;
    }

    public static void main(String[] args) 
    {
        int[] nums = {1,3,8,48,10};
        System.out.println(longestNiceSubarray(nums));     
    }
}
