import java.util.*;
public class _4_12_25_Find_the_Count_of_Good_Integers 
{
    public static long countGoodIntegers(int n, int k) 
    {
        int d = 0;
        if(n%2 != 0)
        {
            d = (n+1)/2;
        }
        else
        {
            d = n/2;
        }
        
        int start =(int) Math.pow(10,d-1); 
        int last =(int) Math.pow(10,d)-1;

        Set<String> hs = new HashSet<>();

        for(int i=start;i<=last;i++)
        {
            String left = String.valueOf(i);
            StringBuilder leftsb = new StringBuilder(left);
            String right = leftsb.reverse().toString(); 
            String s = "";
            if(n%2 == 0)
            {
                s = left+right;
            }
            else
            {
                s = left + right.substring(1);
            }

            long num = Long.parseLong(s);
            if(num%k != 0)
            {
                continue;
            }

            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            s = String.valueOf(ch);
            hs.add(s);
        }

        long[] factorial = new long[11];
        Arrays.fill(factorial,1);
        for(int i=1;i<11;i++)
        {
            factorial[i] = factorial[i-1] * i;
        }
        long result = 0;
        for(String s : hs)
        {
            int[] freq = new int[10];
            for(char ch : s.toCharArray())
            {
                freq[ch-'0']++;
            }

            int totalDigits = s.length();
            int zeroDigits = freq[0];
            int nonZeroDigits = totalDigits - zeroDigits;


            long perm = nonZeroDigits * factorial[totalDigits-1];

            for(int i =0;i<10;i++)
            {
                perm /= factorial[freq[i]];
            }

            result += perm;
        }

        return result;
    }

    public static void main(String[] args) 
    {
        int n = 3, k = 5;
        System.out.println(countGoodIntegers(n, k));
    }
}
