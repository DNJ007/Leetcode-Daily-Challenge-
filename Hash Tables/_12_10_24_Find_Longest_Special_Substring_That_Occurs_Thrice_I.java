import java.util.HashMap;
import java.util.Objects;

public class _12_10_24_Find_Longest_Special_Substring_That_Occurs_Thrice_I 
{
    static class Pair
    {
        char ch;
        int len;

        Pair(char ch, int len)
        {
            this.ch = ch;
            this.len = len;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            Pair pair = (Pair) obj;
            return ch == pair.ch && len == pair.len;
        }

        @Override
        public int hashCode() {
            return Objects.hash(ch, len);
        }
    }

    public static int maximumLengthOptimized(String s) 
    {
        HashMap<Pair, Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);
            int len = 0;
            for(int j=i;j<s.length();j++)
            {
                if( ch == s.charAt(j))
                {
                    len++;
                    Pair pair = new Pair(ch,len);
                    hm.put(pair,hm.getOrDefault(pair,0)+1);
                }
                else
                {
                    break;
                }
            }
        }

        int res = 0;
        for(Pair p : hm.keySet())
        {
            if(hm.get(p) >=3 && p.len > res)
            {
                res = p.len;
            }
        }

         return res == 0 ? -1 : res;
        
    }
    public static int maximumLengthBruteForce(String s) 
    {
        HashMap<String, Integer> hm = new HashMap<>();
        for(int i=0;i<s.length();i++)
        {
            StringBuilder curr = new StringBuilder("");
            for(int j=i;j<s.length();j++)
            {
                char prev = s.charAt(i);
                if(curr.length() == 0 || prev == s.charAt(j))
                {
                    curr.append(s.charAt(j));
                    hm.put(curr.toString(),hm.getOrDefault(curr.toString(),0)+1);
                    prev = s.charAt(j);
                }
                else
                {
                    break;
                }
            }
        }

        int res = 0;
        for(String s1 : hm.keySet())
        {
            if(hm.get(s1) >=3 && s1.length() > res)
            {
                res = s1.length(); 
            }
        }

         return res == 0 ? -1 : res;
        
    }
    
    public static void main(String[] args) 
    {
        String s1 = "aaaa";
        System.out.println(maximumLengthBruteForce(s1));

        String s2 = "abcdef";
        System.out.println(maximumLengthOptimized(s2));
        
    }
}
