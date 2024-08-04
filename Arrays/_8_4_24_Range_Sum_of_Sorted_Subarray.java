import java.util.ArrayList;
import java.util.Collections;

public class _8_4_24_Range_Sum_of_Sorted_Subarray
{
    private static final int MOD = 1_000_000_007;
    public static int rangeSum(int[] nums, int n, int left, int right) 
    {
        ArrayList<Integer> Al = new ArrayList<Integer>();

        for(int i=0;i<nums.length;i++)
        {
            Al.add(nums[i]);
            int subsum = nums[i];
            for(int j=i+1;j<nums.length;j++)
            {
                subsum = (subsum + nums[j])%MOD;
                Al.add(subsum);
            }   
        }

        Collections.sort(Al);

        int l = left-1;
        int r = right-1;

        int sum = 0;

        
        for(int i=l;i<=r;i++)
        {
            sum = (sum + Al.get(i))%MOD;
        }
        return sum;
    }
    public static void main(String [] args)
    {
        int[] nums = {1,2,3,4};
        int n = 4;
        int left = 1, right = 5;
        System.out.println(rangeSum(nums, n, left, right)); 
    }
}