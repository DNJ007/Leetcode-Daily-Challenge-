import java.util.*;

public class _2_9_25_Count_Number_of_Bad_Pairs 
{
    public static long countBadPairs(int[] nums) 
    {
        long bpcount = 0;
        Map<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            int diff = i - nums[i];
            int gpcount = hm.getOrDefault(diff,0);

            bpcount += i - gpcount;

            hm.put(diff,gpcount+1);
        }
        return bpcount;
    }
    public static void main(String[] args) 
    {
        int[]nums = {4,1,3,3};
        System.out.println(countBadPairs(nums));        
    }
    
}
