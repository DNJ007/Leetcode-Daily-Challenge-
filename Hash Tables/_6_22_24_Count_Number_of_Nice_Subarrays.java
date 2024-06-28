import java.util.HashMap;

public class _6_22_24_Count_Number_of_Nice_Subarrays
{
    public static int numberOfSubarrays(int[] nums, int k) 
    {
        int currSum=0;
        int subarrays=0;
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        hm.put(currSum,1);

        for(int i=0;i<nums.length;i++)
        {
            currSum += nums[i]%2;

            if(hm.containsKey(currSum-k))
            {
                subarrays += hm.get(currSum-k);
            }

           hm.put(currSum, hm.getOrDefault(currSum,0)+1);
        }
        return subarrays;        
    }
    public static void main(String [] args)
    {
        int[]nums = {1,1,2,1,1};
        int k = 3;
        System.out.println(numberOfSubarrays(nums,k)); 
    }
}