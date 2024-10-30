import java.util.*;
public class _10_28_24_Longest_Square_Streak_in_an_Array 
{
    public static int longestSquareStreak(int[] nums) 
    {
        HashSet<Long> hs = new HashSet<>();
        for(int num : nums)
        {
            hs.add((long)num);
        }

        int longestStreak = 0;
        for(long num : hs)
        {
            if(hs.contains(num*num))
            {
                int streak = 0;
                long current = num;
             
            while(hs.contains(current))
            {
                streak++;
                current *= current;
            }
            longestStreak = Math.max(longestStreak, streak);
        }
        }
        
        return longestStreak > 1 ? longestStreak : -1;
    }

    public static void main(String[] args) 
    {
        int nums[] = {4,3,6,16,8,2};
        System.out.println(longestSquareStreak(nums));        
    }    
}
