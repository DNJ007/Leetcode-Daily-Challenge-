import java.util.HashSet;

public class _9_12_24_Count_Number_of_Consistent_Strings
{
    public static int countConsistentStrings(String allowed, String[] words) 
    {
        HashSet<Character> hs = new HashSet<Character>();
        for(char ch: allowed.toCharArray())
        {
            hs.add(ch);
        }
        int res = 0;
        boolean flag = true;
        for(int i=0;i<words.length;i++)
        {
            flag = true;
            for(int j=0;j<words[i].length();j++)
            {
                char ch = words[i].charAt(j);
                if(!hs.contains(ch))
                {
                    flag = false;
                    break;
                }
            }
            if(flag)
            {
                res++;
            }
        }
        return res;
    }
    public static void main(String [] args)
    {
        String allowed = "cad";
        String[] words = {"cc","acd","b","ba","bac","bad","ac","d"};
        System.out.println(countConsistentStrings(allowed, words)); 
    }
}
