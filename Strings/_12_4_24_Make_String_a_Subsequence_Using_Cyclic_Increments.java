import java.util.HashMap;

public class _12_4_24_Make_String_a_Subsequence_Using_Cyclic_Increments
{
    public static boolean canMakeSubsequence(String str1, String str2) 
    {
        if(str2.length() > str1.length())
        {
            return false;
        }
        int j = 0;
        HashMap<Integer,Character> hm = new HashMap<>();
        char cha = 'a';
        for(int i=0;i<26;i++)
        {
            hm.put(i,cha++);
        }
        
        for(int i=0;i<str1.length();i++)
        {           
            char ch = str1.charAt(i);
            int idx = ch-'a';
            char nextch;
            if(idx == 25)
            {
                nextch = hm.get(0);
            }
            else
            {
                nextch = hm.get(idx+1);
            }
            if(j<str2.length() && ch == str2.charAt(j))
            {
                j++;
            }
            else if(j<str2.length() && nextch == str2.charAt(j))
            {                
                j++;
            }
        }

        if(j == str2.length())
        {
            return true;
        }
        return false;        
    }
    public static void main(String [] args)
    {
        String str1 = "abc", str2 = "ad";
        System.out.println(canMakeSubsequence(str1, str2)); 
        str1 = "zc";
        System.out.println(canMakeSubsequence(str1, str2)); 
        str1 = "ab";
        str2 = "d";
        System.out.println(canMakeSubsequence(str1, str2));

    }
}