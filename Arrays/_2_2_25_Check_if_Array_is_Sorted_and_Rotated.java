import java.util.Arrays;

public class _2_2_25_Check_if_Array_is_Sorted_and_Rotated 
{
    public static boolean check(int[] nums) 
    {
        int size = nums.length;

        int[] sortedNums = nums.clone();
        Arrays.sort(sortedNums);

        for (int rotationOffset = 0; rotationOffset < size; ++rotationOffset) 
        {
            boolean isMatch = true;
            for (int index = 0; index < size; ++index) 
            {
                if (nums[(rotationOffset + index) % size] != sortedNums[index]) 
                {
                    isMatch = false;
                    break;
                }
            }
            if (isMatch) 
            {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) 
    {
        int[]nums = {3,4,5,1,2};
        System.out.println(check(nums));
    }    
}
