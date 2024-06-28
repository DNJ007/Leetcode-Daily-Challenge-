import java.util.HashMap;

public class _6_9_24_Subarray_Sums_divisible_by_k {
    public static int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        int rem = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        hm.put(0,1);
        for(int i=0;i<nums.length;i++)
        {
            sum += nums[i];
            rem = sum % k;

            if(rem < 0)
            {
                rem += k;
            }

            if(hm.containsKey(rem))
            {
                count = count + hm.get(rem);
                hm.put(rem,hm.get(rem)+1);
            }
            else
            {
                hm.put(rem,1);
            }           
        }
        return count;
    }
    public static void main(String[] args) {
        int nums[] = {4,5,0,-2,-3,1};
        int k = 5;
        System.out.println(subarraysDivByK(nums, k));
    }
}
