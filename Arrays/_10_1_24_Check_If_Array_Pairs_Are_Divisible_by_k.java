public class _10_1_24_Check_If_Array_Pairs_Are_Divisible_by_k 
{
    public static boolean canArrange(int[] arr, int k) 
    {
        int[] freq = new int[k];

        for(int num : arr)
        {
            freq[((num%k)+k)%k]++;
        }

        if(freq[0]%2 != 0)
        {
            return false;
        }

        for(int i=1;i<=k/2;i++)
        {
            if(freq[i] != freq[k-i])
            {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) 
    {
        int []arr = {1,2,3,4,5,10,6,7,8,9};
        int k = 5;

        System.out.println(canArrange(arr, k));

        int arr1[] = {75,5,-5,75,-2,-3,88,10,10,87};
        k =10;
        
        System.out.println(canArrange(arr1, k));
    }
    
}
