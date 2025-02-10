import java.util.*;

public class _2_10_25_Clear_Digits 
{
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

    
    public static void main(String[] args) 
    {
        String s = "cb2fdfdf34i0";
        //System.out.println(clearDigits1(s));
        System.out.println(clearDigits2(s));
       // System.out.println(clearDigits3(s));
    }
    
}
