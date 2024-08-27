import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _8_24_24_Find_the_Closest_Palindrome 
{
    public static String reverse(String s,boolean even)
    {
        String rev = "";
        if(even)
        {            
            for(int i=s.length()-1;i>=0;i--)
            {
                rev += s.charAt(i);
            }
        }
        else
        {
            for(int i=s.length()-2;i>=0;i--)
            {
                rev += s.charAt(i);
            }
        }        

        return s+rev;
    }
    public static String nearestPalindromic(String n) 
    {
        List<Long> Al = new ArrayList<>();

        int N = n.length();

        long OGNum = Long.parseLong(n);

        if(N%2 == 0)
        {            
            int halfnum = Integer.parseInt(n.substring(0,N/2));

            Al.add(Long.parseLong(reverse(n.substring(0,N/2),true)));

            String str = String.valueOf(halfnum+1);
            Al.add(Long.parseLong(reverse(str,true)));

            str = String.valueOf(halfnum-1);
            Al.add(Long.parseLong(reverse(str,true)));

            Al.add((long)Math.pow(10,N)+1);
            Al.add((long)Math.pow(10,N-1)-1);
            //System.out.println(Al);
        }
        else
        {
            int halfnum = Integer.parseInt(n.substring(0,N/2+1));

            Al.add(Long.parseLong(reverse(n.substring(0,N/2+1),false)));

            String str = String.valueOf(halfnum+1);
            Al.add(Long.parseLong(reverse(str,false)));

            str = String.valueOf(halfnum-1);
            Al.add(Long.parseLong(reverse(str,false)));

            Al.add((long)Math.pow(10,N)+1);
            Al.add((long)Math.pow(10,N-1)-1);
            //System.out.println(Al);
        }

        long minDiff = Long.MAX_VALUE;
        int index = -1;
        Collections.sort(Al);
        for(int i=0;i<Al.size();i++)
        {
            long Diff = Math.abs(OGNum - Al.get(i));
            if(Diff == 0)
            {
                continue;
            }
            if(Diff < minDiff)
            {
                minDiff = Diff;
                index = i;
            }
        }

        // System.out.println(index);
        // System.out.println(minDiff);

        // System.out.println(Al.get(index));

        return String.valueOf(Al.get(index));

    }

    public static void main(String[] args) 
    {
        String n = "123";
        System.out.println(nearestPalindromic(n));
    }
}
