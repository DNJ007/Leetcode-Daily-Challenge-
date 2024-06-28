import java.util.HashMap;

public class _6_8_24_Continuous_Subarray_Sum {
    public static boolean checkSubarraySum(int[] nums, int k) {
        int prefixMod = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        hm.put(0,-1);
        for(int i=0;i<nums.length;i++)
        {
            prefixMod = (prefixMod + nums[i]) % k;

            if(hm.containsKey(prefixMod))
            {
                if(i - hm.get(prefixMod) > 1)
                {
                    return true;
                }
            }
            else
            {
                hm.put(prefixMod,i);
            }
        }
        return false;
    }
    public static void main(String[] args) {
        int[] nums = {23,2,4,6,7};
        int k = 6;
        System.out.println(checkSubarraySum(nums, k));
    }
}
