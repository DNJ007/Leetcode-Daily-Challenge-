public class _1_16_24_Bitwise_XOR_of_All_Pairings
{
    public static int xorAllNums(int[] nums1, int[] nums2) 
    {
        int xor1 = 0;
        int xor2 = 0;

        int len1 = nums1.length;
        int len2 = nums2.length;

        if(len2 % 2 != 0)
        {
            for(int num : nums1)
            {
                xor1 ^= num;
            }
        }

        if(len1 % 2 != 0)
        {
            for(int num : nums2)
            {
                xor2 ^= num;
            }
        }

        return xor1 ^ xor2;
    }
    public static void main(String [] args)
    {
        int[] nums1 = {2,1,3};
        int[] nums2 = {10,2,5,0};
        System.out.println(xorAllNums(nums1, nums2)); 
    }
}