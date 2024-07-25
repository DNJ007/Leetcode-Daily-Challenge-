public class _7_25_24_Sort_an_array_sol4 
{
      //Merge Sort
      //T.C : O(n log n)
      //S.C : O(n)
    private static void merge(int[] nums, int left, int mid, int right)
    {
        
        int n1 = mid - left + 1;
        int n2 = right - mid;

        
        int[] L = new int[n1];
        int[] R = new int[n2];

        
        for (int i = 0; i < n1; ++i) {
            L[i] = nums[left + i];
        }
        for (int j = 0; j < n2; ++j) {
            R[j] = nums[mid + 1 + j];
        }

        
        int i = 0, j = 0;

        
        int k = left;
        while (i < n1 && j < n2) 
        {
            if (L[i] <= R[j]) 
            {
                nums[k] = L[i];
                i++;
            } else 
            {
                nums[k] = R[j];
                j++;
            }
            k++;
        }

       
        while (i < n1) {
            nums[k] = L[i];
            i++;
            k++;
        }

       
        while (j < n2) {
            nums[k] = R[j];
            j++;
            k++;
        }
    }

    
    private static void mergeSort(int[] nums, int left, int right) 
    {
        
        if (left < right) 
        {
           
            int mid = left + (right - left) / 2;

           
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);

            merge(nums, left, mid, right);
        }
    }

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void main(String [] args)
    {
        int[] nums = {5,2,3,1};
        nums = sortArray(nums);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        } 
    }    
}
