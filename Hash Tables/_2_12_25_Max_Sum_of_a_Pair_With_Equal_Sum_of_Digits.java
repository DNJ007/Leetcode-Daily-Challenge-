import java.util.HashMap;

public class _2_12_25_Max_Sum_of_a_Pair_With_Equal_Sum_of_Digits 
{
    public static int maximumSum(int[] nums) 
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        
        int digitSum = 0;
        int ans = -1;
        for(int num : nums)
        {            
            digitSum = 0;
            int n = num;
            while(n > 0)
            {
                digitSum += n%10;
                n = n/10;
            }

            if(hm.containsKey(digitSum))
            {
                ans = Math.max(ans,num + hm.get(digitSum));

                if(num > hm.get(digitSum))
                {
                    hm.put(digitSum,num);
                }
            }
            else
            {
                hm.put(digitSum,num);
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        int[] nums = {18,43,36,13,7};
        System.out.println(maximumSum(nums));
        
    }    
}
