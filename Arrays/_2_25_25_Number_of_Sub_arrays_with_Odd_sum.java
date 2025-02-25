public class _2_25_25_Number_of_Sub_arrays_with_Odd_sum 
{
    public static int numOfSubarrays(int[] arr) 
    {
        int countO = 0;
        int countE = 1;
        int ans = 0;
        int sum = 0;
        int MOD = 1000000007;
        for(int num : arr)
        {
            sum += num;
            if((sum%2) != 0)
            {
                ans = (ans + countE) % MOD;
                countO++;
            }
            else
            {
                ans = (ans + countO) % MOD;
                countE++;
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] arr = {1,2,3,4,5,6,7};
        System.out.println(numOfSubarrays(arr));
    }
    
}
