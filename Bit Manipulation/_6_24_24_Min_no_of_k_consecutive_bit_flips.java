public class _6_24_24_Min_no_of_k_consecutive_bit_flips
{
    public static int minKBitFlips(int[] nums, int k)
    {
        int n = nums.length;
        int flipped = 0, ans = 0;
        int[] isFlipped = new int[n];

        for(int i=0;i<n;i++)
        {
            if(i>=k)
            {
                flipped ^= isFlipped[i-k];
            }

            if((nums[i]^flipped)==0)
            {
                if(i+k > n)
                    return -1;
                
                ans++;
                flipped^=1;
                isFlipped[i] = 1;

            }
        }

        return ans;
    }
    public static void main(String [] args)
    {
        int[]nums = {0,1,0};
        int k = 1;
        System.out.println(minKBitFlips(nums,k)); 
    }
}