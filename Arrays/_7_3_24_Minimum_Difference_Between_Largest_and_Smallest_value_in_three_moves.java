import java.util.Arrays;

public class _7_3_24_Minimum_Difference_Between_Largest_and_Smallest_value_in_three_moves {
    
    public int minDifference(int[] nums) {
        if(nums.length <=4)
        {
            return 0;
        }
        Arrays.sort(nums);

        int mindiff = Integer.MAX_VALUE;

        for(int i=0,j=nums.length-4;i<4;i++,j++)
        {
            mindiff = Math.min(mindiff,nums[j] - nums[i]);
        }

        return mindiff;
    }

}
