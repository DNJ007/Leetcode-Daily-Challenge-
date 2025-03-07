import java.util.*;
public class _3_7_25_Closest_Prime_Numbers_in_Range
{
    public static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if((n % i)==0)
            {
                return false;
            }
        }
        return true;
    }
    public static int[] closestPrimes(int left, int right) 
    {
        ArrayList<Integer> Al = new ArrayList<>();

        for(int i=left;i<=right;i++)
        {
            if(i==1) continue;
            if(isPrime(i))
            {      
                if(Al.size() != 0 && i - Al.get(Al.size()-1) <= 2) 
                {
                    return new int[]{Al.get(Al.size()-1),i};
                }    
                Al.add(i);
            }
        }      

        if(Al.size() < 2)
        {
            return new int[]{-1,-1};
        } 
        int minD = Al.get(1) - Al.get(0);
        int num1 = Al.get(0);
        int num2 = Al.get(1);

        for(int i=1;i<Al.size()-1;i++)
        {
            int diff = Al.get(i+1) - Al.get(i);

            if(diff < minD)
            {
                minD = diff;
                num1 = Al.get(i);
                num2 = Al.get(i+1);
            }
        }
        return new int[]{num1,num2}; 
    }
    public static void main(String [] args)
    {
        int left = 10, right = 19;
        int[] res = closestPrimes(left, right);
        System.out.println(res[0]+" "+res[1]); 
    }
}