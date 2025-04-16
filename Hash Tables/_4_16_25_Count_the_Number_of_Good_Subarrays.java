import java.util.HashMap;

public class _4_16_25_Count_the_Number_of_Good_Subarrays
{
    public static long countGood(int[] nums, int k) 
    {
        int j = 0;
        long count = 0;
        long ans = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            while(count < k && j < nums.length)
            {
                count += hm.getOrDefault(nums[j],0);
                hm.put(nums[j],hm.getOrDefault(nums[j],0)+1);
                j++;
            }
            if(count >= k)
            {
                ans += nums.length - j + 1;
            }
            int freq = hm.getOrDefault(nums[i], 0);
            count -= freq - 1;

            if (hm.get(nums[i]) == 1)
                hm.remove(nums[i]);
            else
                hm.put(nums[i], hm.get(nums[i]) - 1);
        }   

        return ans;
    }
    public static void main(String [] args)
    {
        int[] nums = {3,1,4,3,2,2,4};
        int k = 2;
        System.out.println(countGood(nums, k)); 
    }
}