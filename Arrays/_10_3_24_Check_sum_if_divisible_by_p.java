import java.util.*;
public class _10_3_24_Check_sum_if_divisible_by_p 
{
    public static int minSubarray(int[] nums, int p) 
    {
        int n = nums.length;
        int totalSum = 0;

        for(int num : nums)
        {
            totalSum = (totalSum + num) % p;
        }

        int target = totalSum % p;

        if(target == 0)
        {
            return 0;
        }

        HashMap<Integer,Integer> modMap = new HashMap<>();
        modMap.put(0,-1);

        int currSum = 0;
        int minLen = n;

        for(int i = 0;i < n ;i++)
        {
            currSum = (currSum + nums[i]) % p;

            int needed = (currSum - target + p) % p;

            if(modMap.containsKey(needed))
            {
                minLen = Math.min(minLen, i - modMap.get(needed));
            }

            modMap.put(currSum, i);
        }

        return minLen == n ? -1 : minLen;
        
    }

    public static void main(String[] args) 
    {
        int[] nums = {6,3,5,2};
        int p = 9;

        System.out.println(minSubarray(nums, p));
        
    }
    
}
