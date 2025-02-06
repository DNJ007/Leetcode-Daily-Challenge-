import java.util.Arrays;

public class _2_5_25_Check_If_One_String_Swap_Can_Make_Strings_Equal 
{
    public static boolean areAlmostEqual(String s1, String s2) 
    {
        if(s1.equals(s2))
        {
            return true;
        }

        char[] s1Freq = new char[26];
        char[] s2Freq = new char[26];

        int count = 0;
        for(int i=0;i<s1.length();i++)
        {
            char ch = s1.charAt(i);
            char ch2 = s2.charAt(i);

            if(ch != ch2)
            {
                count++;
                if(count > 2)
                {
                    return false;
                }
            }

            s1Freq[s1.charAt(i)-'a']++;
            s2Freq[s2.charAt(i)-'a']++;

        }

        return Arrays.equals(s1Freq,s2Freq);
    }

    public static void main(String[] args) 
    {
        String s1 = "bank", s2 = "kanb";
        System.out.println(areAlmostEqual(s1, s2));
        
    }
    
}
