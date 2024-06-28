public class _6_14_24_Minimum_Increment_to_Make_Array_Unique {
    public static void countingSort(int A[])
    {        
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<A.length;i++)
        {
            largest = Math.max(largest, A[i]);         
        }

        int count[] = new int[largest+1];
        for(int i=0;i<A.length;i++)
        {
           count[A[i]]++;       
        }

        //sorting
        int j=0;
        for(int i=0;i<count.length;i++)
        {
            while(count[i]>0)
            {
                A[j]=i;
                j++;
                count[i]--;
            }
        }
    }
    public static int minIncrementForUnique(int[] nums) {
        
        countingSort(nums);
        
        int minInc = 0; 
        int prev = nums[0];
        
        for (int i = 1; i < nums.length; i++) {

            int curr = nums[i];

            if(prev == curr)
            {
                nums[i] = curr + 1;
                minInc = minInc + 1;
            }   

            if(prev > curr)
            {
                while(curr <= prev)
                {
                    nums[i] = nums[i] + 1;
                    curr = nums[i];
                    minInc = minInc + 1;
                }
            }

            prev = nums[i];
        }
        
        return minInc;
    }
    public static void main(String[] args) {
        int nums[] = {3,2,1,2,1,7};
        System.out.println(minIncrementForUnique(nums));
    }
}
