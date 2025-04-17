import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class _4_17_25_Count_Equal_and_Divisible_Pairs_in_an_Array 
{
    public static int BrutecountPairs(int[] nums, int k) 
    {
        int count = 0;
        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j] && (i*j)%k == 0)
                {
                    count++;
                }
            }
        }
        return count;
    }

    
   private static int gcd(int a, int b) 
   {
        while (b != 0) {
            int t = b;
            b = a % b;
            a = t;
        }
        return a;
    }

    public static int OptcountPairs(int[] nums, int k) 
    {
        int count = 0;
        HashMap<Integer,List<Integer>> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++)
        {
            hm.putIfAbsent(nums[i],new ArrayList<>());
            hm.get(nums[i]).add(i);
        }

        Set<Integer> div = new HashSet<>();
        for(int i=1;i*i<=k;i++)
        {
            if(k%i == 0)
            {
                div.add(i);
                div.add(k/i);
            }
        }

        
        for (Map.Entry<Integer, List<Integer>> entry : hm.entrySet()) 
        {
            List<Integer> indices = entry.getValue();
            HashMap<Integer,Integer> factorMap = new HashMap<>();

            for(int num : indices)
            {
                int GCD = gcd(num,k);
                int j = k / GCD;

                count += factorMap.getOrDefault(j,0);

                for(int f : div)
                {
                    if(num % f == 0)
                    {
                        factorMap.put(f,factorMap.getOrDefault(f,0)+1);
                    }
                }
            }            
        }

        return count;
    }


    public static void main(String[] args) 
    {
        int[] nums = {3,1,2,2,2,1,3};
        int k = 2;

        System.out.println(OptcountPairs(nums,k));
        System.out.println(BrutecountPairs(nums,k));
    }
}
