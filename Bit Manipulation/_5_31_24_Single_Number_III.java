public class _5_31_24_Single_Number_III {
    public static int[] singleNumber(int[] nums) {
        int xor2no = 0;
        for(int num : nums)
        {
            xor2no = xor2no ^ num;
        }

        int lowestBit = xor2no & (-xor2no);

        int result[] = new int[2];

        for(int num:nums)
        {
            if((lowestBit & num) == 0)
            {
                result[0] = result[0] ^ num;
            }
            else
            {
                result[1] = result[1] ^ num;
            }
        }

        return result;
    }
    public static void main(String[] args) {
        int[] nums = {1,2,1,3,2,5};
        nums =singleNumber(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }
}
