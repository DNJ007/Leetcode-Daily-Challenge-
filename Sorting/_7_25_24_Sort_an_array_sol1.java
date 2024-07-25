import java.util.*;
public class _7_25_24_Sort_an_array_sol1
{
    public static int[] sortArray(int[] nums) 
    {
        //T.C : O(n log n)
        //S.C : O(1)
        Arrays.sort(nums);
        return nums;
    }
    public static void main(String [] args)
    {
        int[] nums = {5,2,3,1};
        nums = sortArray(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        } 
    }
}
