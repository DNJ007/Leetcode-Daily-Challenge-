import java.util.*;
public class _3_30_25_Partition_Labels 
{
    public static List<Integer> partitionLabels(String s) 
    {
        HashMap<Character,Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            hm.put(ch,i);
        }       

        int maxIdx = 0;
        List<Integer> Al = new ArrayList<>();
        int prev = 0;
        for(int i=0;i<s.length();)
        {   
            char ch = s.charAt(i);
            maxIdx = hm.get(ch);  
            int j=i;  
                   
            while(j<maxIdx)
            {
                char ch2 = s.charAt(j);
                int idx = hm.get(ch2);

                if(idx > maxIdx)
                {
                    maxIdx = idx;
                }
                j++;
            }
            prev = i;
            i = maxIdx+1;
            Al.add(maxIdx+1-prev);
        }  
        
        return Al;
    }

    public static void main(String[] args) 
    {
        String s = "ababcbacadefegdehijhklij";
        System.out.println(partitionLabels(s));
    }
}
