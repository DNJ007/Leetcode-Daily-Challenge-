public class _6_16_24_Patching_Array {
    public static int minPatches(int[] nums, int n) {
        int output=0;
        int i=0;
        long miss=1;

        while(miss <= n)
        {
            if(i < nums.length && nums[i] <= miss)
            {
                miss += nums[i];
                i += 1;
            }
            else
            {
                miss += miss;
                output++;
            }
        }
        return output;
    }
    public static void main(String[] args) {
        int[] nums = {1,3};
        int n = 6;
        System.out.println(minPatches(nums, n));
    }
}
