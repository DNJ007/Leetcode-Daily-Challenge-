import java.util.ArrayList;
import java.util.HashMap;

public class _9_17_24_Uncommon_Words_from_Two_Sentences
{
    public static String[] uncommonFromSentences(String s1, String s2) 
    {
        HashMap<String,Integer> hm = new HashMap<String,Integer>();

        String[] str1 = s1.split(" ");
        String[] str2 = s2.split(" ");

        for(int i=0;i<str1.length;i++)
        {
            hm.put(str1[i],hm.getOrDefault(str1[i],0)+1);
        }

        for(int i=0;i<str2.length;i++)
        {
            hm.put(str2[i],hm.getOrDefault(str2[i],0)+1);
        }

        ArrayList<String> Al = new ArrayList<>();
        for(String s : hm.keySet())
        {
            if(hm.get(s) == 1)
            {
                Al.add(s);
            }
        }

        String[] s = new String[Al.size()];
        int k = 0;
        for(int i=0;i<Al.size();i++)
        {
            s[k++] = Al.get(i);
        }
        return s;
    }
    public static void main(String [] args)
    {
        String s1 = "this apple is sweet", s2 = "this apple is sour";
        String[] s = uncommonFromSentences(s1, s2);

        for(int i=0;i<s.length;i++)
        {
            System.out.print(s[i]+" ");
        }
    }
}