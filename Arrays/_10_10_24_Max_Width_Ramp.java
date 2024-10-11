public class _10_10_24_Max_Width_Ramp 
{
    public static int maxWidthRamp(int[] nums) 
    {
        int rightMax[] = new int[nums.length];
        rightMax[rightMax.length-1] = nums[nums.length-1];

        for(int i=nums.length-2;i>=0;i--)
        {
            rightMax[i] = Math.max(rightMax[i+1],nums[i]);
        }

        int j = 0;
        int res = 0;
        for(int i=0;i<nums.length;i++)
        {
            while(j<nums.length && nums[i] <= rightMax[j] )
            {
                res = Math.max(res,j-i);
                j++;
            }            
        }
        return res;        
    }

    public static void main(String[] args) 
    {
        int []nums = {9,8,1,0,1,9,4,0,4,1};
        System.out.println(maxWidthRamp(nums));
    }
    
}
