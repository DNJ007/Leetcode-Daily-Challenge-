import java.util.*;
public class _10_21_24_Split_String_Into_Max_Number_of_Unique_Substring 
{
    public static int maxUniqueSplit(String s) 
    {
        return backtrack(s,new HashSet<>(),0);
    }

    private static int backtrack(String s,HashSet<String> hs, int start)
    {
        if(start == s.length())
        {
            return 0;
        }

        int max = 0;

        for(int i = start + 1; i <= s.length(); i++)
        {
            String str = s.substring(start,i);

            if(!hs.contains(str))
            {
                hs.add(str);
                max = Math.max(max, 1 + backtrack(s, hs, i));
                hs.remove(str);
            }
        }
        return max;
    }

    public static void main(String[] args) 
    {
        System.out.println(maxUniqueSplit("ababccc"));
        
    }
    
}
