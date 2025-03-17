class _3_17_25_Divide_Array_Into_Equal_Pairs
{
    public static boolean divideArray(int[] nums) 
    {
        int n = nums.length/2;
        int[] freq = new int[501];

        for(int num : nums)
        {
            freq[num]++;
        }

        int ans = 0;
        for(int i=0;i<freq.length;i++)
        {
            if(freq[i]%2!=0)
            {
                return false;
            }
            if(freq[i]>0)
            {
                int count = freq[i];
                
                ans += count/2;
            }
        }

        if(ans == n)
        {
            return true;
        }
        return false;
    }
    public static void main(String [] args)
    {
        int[] nums = {3,2,3,2,2,2};
        System.out.println(divideArray(nums)); 
    }
}