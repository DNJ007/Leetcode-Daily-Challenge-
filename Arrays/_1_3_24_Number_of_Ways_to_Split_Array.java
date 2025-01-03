public class _1_3_24_Number_of_Ways_to_Split_Array
{
    public static int waysToSplitArray(int[] nums) 
    {
        int count = 0;
        long total = 0;
        long prefixSum = 0;
        for(int num : nums)
        {
            total += num;
        }
        for(int i=0;i<nums.length-1;i++)
        {
            prefixSum += nums[i];
            long suffixSum = total-prefixSum;
            if(prefixSum >= suffixSum)
            {
                count++;
            }
        }

        return count;
    }
    public static void main(String [] args)
    {
        int[]nums = {10,4,-8,7};
        System.out.println(waysToSplitArray(nums)); 
    }
}