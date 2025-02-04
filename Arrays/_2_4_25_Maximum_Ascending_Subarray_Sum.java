public class _2_4_25_Maximum_Ascending_Subarray_Sum 
{
    public static int maxAscendingSum(int[] nums) 
    {
        if(nums.length == 1)
        {
            return nums[0];
        }
        int maxSum = 0;
        int sum = nums[0]; 
        for(int i=1;i<nums.length;i++)
        {
            
            if(nums[i] > nums[i-1])
            {
                sum += nums[i];
                maxSum = Math.max(maxSum,sum);
            }
            else
            {
                maxSum = Math.max(maxSum,sum);
                sum = nums[i];
               
            }
            
        }
        return maxSum; 
        
    }
    public static void main(String[] args) {
        int[] nums = {10,20,30,5,10,50};
        System.out.println(maxAscendingSum(nums));
    }
}
