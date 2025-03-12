public class _3_12_25_Maximum_Count_of_Positive_Integer_and_Negative_Integer
{
    public static int maximumCount(int[] nums) 
    {
        int l=0,r=0;
        for(int num : nums)
        {
            if(num < 0)
            {
                l++;
            }
            else if(num > 0)
            {
                r++;
            }
        }        
        return Math.max(l,r);
    }
    public static void main(String [] args)
    {
        int[] nums = {-3,-2,-1,0,0,1,2};
        System.out.println(maximumCount(nums)); 
    }
}