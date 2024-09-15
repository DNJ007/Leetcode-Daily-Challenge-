import java.util.*;

public class _9_15_24_Find_the_Longest_SubSTRING_Containing_Vowels_in_Even_Counts 
{
    public static int findTheLongestSubstring(String s) 
    {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0,-1);

        int bitmask = 0;
        int maxlength = 0;

        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            switch(ch) 
            {
                case 'a':
                    bitmask ^= (1 << 0);
                    break;
                case 'e':
                    bitmask ^= (1 << 1);
                    break;
                case 'i':
                    bitmask ^= (1 << 2);
                    break;        
                case 'o':
                    bitmask ^= (1 << 3);
                    break;
                case 'u':
                    bitmask ^= (1 << 4);
                    break;
                default:
                    break;
            }

            if(map.containsKey((bitmask)))
            {
                maxlength = Math.max(maxlength, i-map.get(bitmask));
            }
            else
            {
                map.put(bitmask,i);
            }
        }

        return maxlength;

    }
    public static void main(String[] args) 
    {
        String s = "eleetminicoworoepe";
        System.out.println(findTheLongestSubstring(s));
        
    }
    
}
