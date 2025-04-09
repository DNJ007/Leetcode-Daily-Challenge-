import java.util.*;

public class _4_9_25_Minimum_Operations_to_Make_Array_Values_Equal_to_K 
{
    public static int minOperations(int[] nums, int k) 
    {
        HashSet<Integer> hs = new HashSet<>();

        int min = Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++)
        {
            hs.add(nums[i]);
            min = Math.min(min,nums[i]);
        }        

        if(min < k)
        {
            return -1;
        }

        if(k == min)
        {
            return hs.size()-1;
        }

        return hs.size();
    }

    public static void main(String[] args) 
    {
        int[] nums = {5,2,5,4,5};
        int k = 2;

        System.out.println(minOperations(nums, k));  
    }
}
