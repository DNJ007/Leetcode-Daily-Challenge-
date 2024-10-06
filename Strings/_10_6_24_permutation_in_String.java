import java.util.Arrays;

public class _10_6_24_permutation_in_String 
{
    public static boolean checkInclusion(String s1, String s2) 
    {
        int n = s1.length();
        s1 = sort(s1);
        for(int i=0;i<=s2.length()-n;i++) 
        {
            String s = s2.substring(i,i+n);
            if(s1.equals(sort(s)))
            {
                return true;
            }
        }       
        return false;
    }

    public static String sort(String s)
    {
        char [] t = s.toCharArray();
        Arrays.sort(t);
        return new String(t);
    }

    public static void main(String[] args) 
    {
        String s1 = "ab", s2 = "eidbaooo";
        System.out.println(checkInclusion(s1, s2));    
    }
    
}
