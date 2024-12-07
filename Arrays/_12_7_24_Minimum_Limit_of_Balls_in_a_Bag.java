public class _12_7_24_Minimum_Limit_of_Balls_in_a_Bag 
{
    public static int minimumSize(int[] nums, int maxOperations) 
    {
        int max = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            max = Math.max(nums[i],max);
        }
        return binarySearch(nums,maxOperations,1,max);
    }

    private static int binarySearch(int nums[],int maxOps,int left,int right)
    {
        int result = right;
        while(left<=right)
        {
            int mid = left + (right-left)/2;

            if(isPossible(nums,maxOps,mid))
            {
                result = mid;
                right = mid-1;
            }
            else
            {
                left = mid+1;
            }
        }

        return result;
    }

    private static boolean isPossible(int[] nums,int maxOps,int mid)
    {
        int totalOps = 0;
        for(int num : nums)
        {
            int ops = num/mid;

            if(num%mid == 0)
            {
                ops -= 1;
            }

            totalOps+=ops;
        }
        

        return totalOps<=maxOps;
    }

    public static void main(String[] args) 
    {
        int[] nums = {2,4,8,2};
        int maxOperations = 4;
        System.out.println(minimumSize(nums, maxOperations));
    }
    
}
