import java.util.HashSet;
import java.util.Stack;

public class _2_10_25_Clear_Digits 
{
    public static String clearDigits1(String s) 
    {
        //T.C : O(N^2)
        //S.C : O(N)
        int i = 0;
        int j = -1;
        HashSet<Integer> hs = new HashSet<>();
        boolean[] vis = new boolean[s.length()];
        while(i<s.length())
        {
            if(s.charAt(i)-'0' <= 9 && s.charAt(i)-'0' >= 0)
            {
                j=i-1;
                while(j>=0)
                {
                    if(s.charAt(j)-'a' <= 25 && s.charAt(j)-'a' >= 0 && !vis[j])
                    {
                        hs.add(i);
                        hs.add(j);
                        vis[i] = true;
                        vis[j] = true;
                        break;
                    }
                    j--;
                }
            }
            i++;
        }
        StringBuilder sb = new StringBuilder("");
        for(int k=0;k<s.length();k++)
        {
            if(hs.contains(k))
            {
                continue;
            }
            sb.append(s.charAt(k));
        }
        return sb.toString();
    }

    public static String clearDigits2(String s) 
    {
        //T.C : O(N)
        //S.C : O(N)
        Stack<Character> st = new Stack<>();

        for(int i=0;i<s.length();i++)
        {
            if(s.charAt(i)-'0' >= 0 && s.charAt(i)-'0' <= 9)
            {
                if(st.isEmpty())
                {
                    continue;
                }
                else
                {
                    st.pop();
                }
            }
            else
            {
                st.push(s.charAt(i));
            }
        }

        StringBuilder sb = new StringBuilder("");
        if(st.isEmpty())
        {
            return "";
        }
        else
        {
            while(!st.isEmpty())
            {
                char ch = st.pop();
                sb.append(ch);
            }
        }

        return sb.reverse().toString();
    }

    public static String clearDigits3(String s) 
    {
       //T.C : O(N)
       //S.C : O(1)
       int i = 0;
       int j = 0;

       char[] ch = s.toCharArray();
       while(i<ch.length)
       {
            if (ch[i] >= '0' && ch[i] <= '9') 
            {
                if (j > 0) j--;  // Remove the last valid character
            }
            else
            {
                ch[j] = ch[i];
                j++;
            }
            i++;
       }
       return new String(ch,0,j);
    }
    public static void main(String[] args) 
    {
        String s = "cb2fdfdf34i0";
        System.out.println(clearDigits1(s));
        System.out.println(clearDigits2(s));
        System.out.println(clearDigits3(s));
    }
    
}
