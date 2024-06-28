public class _6_12_24_Sort_Colors {
    public static void sortColors(int[] nums) {
        int largest = Integer.MIN_VALUE;
         for(int i=0;i<nums.length;i++)
         {
             largest = Math.max(largest, nums[i]);           
 
         }
 
         int count[] = new int[largest+1];
         for(int i=0;i<nums.length;i++)
         {
            count[nums[i]]++;       
         }
 
         int j=0;
         for(int i=0;i<count.length;i++)
         {
             while(count[i]>0)
             {
                 nums[j]=i;
                 j++;
                 count[i]--;
             }
         }
     }
     public static void main(String[] args) {
        int [] nums = {2,0,2,1,1,0};
        sortColors(nums);
     }
}
