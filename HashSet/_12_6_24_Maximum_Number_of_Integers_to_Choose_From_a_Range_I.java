import java.util.HashSet;

public class _12_6_24_Maximum_Number_of_Integers_to_Choose_From_a_Range_I 
{
    public static int maxCount(int[] banned, int n, int maxSum) 
    {
        HashSet<Integer> hs = new HashSet<>();
        int count = 0,sum = 0;
        for(int num:banned)
        {
            hs.add(num);
        }
        for(int i=1;i<=n;i++)
        {
            if(hs.contains(i))
            {
                continue;
            }
            else
            {
                sum += i;
                if(sum > maxSum)
                {
                    break;
                }
                count++;
                
            }
        }        
        return count;
    }

    public static void main(String[] args) 
    {
        int[] banned = {1,6,5};
        int n = 5, maxSum = 6;
        System.out.println(maxCount(banned, n, maxSum));
        
    }
    
}
