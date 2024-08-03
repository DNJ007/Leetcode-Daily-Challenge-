public class _8_3_24_Make_two_arrays_equal_by_reversing_subarrays 
{
    public static boolean canBeEqual(int[] target, int[] arr) 
    {
        int freq[] = new int[1001];

        for(int i=0;i<target.length;i++)
        {
            freq[target[i]]++;
            freq[arr[i]]--;
        }

        for(int i=0;i<target.length;i++)
        {
            if(freq[target[i]]!=0 || freq[arr[i]]!=0)
            {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) 
    {
        int[] target = {1,2,3,4};
        int[] arr = {2,4,1,3};
        System.out.println(canBeEqual(target, arr));

        int[] target2 = {3,7,9};
        int[] arr2 = {3,7,11};
        System.out.println(canBeEqual(target2, arr2));
    }
}
