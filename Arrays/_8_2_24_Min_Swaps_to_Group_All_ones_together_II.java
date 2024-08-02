public class _8_2_24_Min_Swaps_to_Group_All_ones_together_II 
{
    public static int minSwaps(int[] nums) 
    {
        int n = nums.length;
        int TotalOnes = 0;
        for(int num: nums)
        {
            if(num == 1)
            {
                TotalOnes++;
            }
        }

        int i = 0;
        int j = 0;

        int currOnes = 0;
        int maxCount = 0;

        while(j < 2*n)
        {
            if(nums[j%n] == 1)
            {
                currOnes++;
            }

            if(j-i+1 > TotalOnes)
            {
                currOnes -= nums[i%n];
                i++;
            }
            maxCount = Math.max(maxCount,currOnes);
            j++;
        }

        return TotalOnes - maxCount;        
    }

    public static void main(String[] args) {
        
        int[] nums = {0,1,1,1,0,0,1,1,0};
        System.out.println(minSwaps(nums)); 
    }
    
}
