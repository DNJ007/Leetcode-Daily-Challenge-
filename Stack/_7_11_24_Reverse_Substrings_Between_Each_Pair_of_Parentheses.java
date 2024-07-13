import java.util.Stack;

public class _7_11_24_Reverse_Substrings_Between_Each_Pair_of_Parentheses
{
    public static String reverseParentheses(String s) 
    {
        Stack<Character> s1 = new Stack<Character>();
        Stack<Character> s2 = new Stack<Character>();
        Stack<Character> s3 = new Stack<Character>();


        int idx = 0;
        while(idx != s.length())
        {
            s1.push(s.charAt(idx));           

            if(s.charAt(idx) == ')')
            {                
                while(s1.peek() != '(' && !s1.isEmpty())
                {
                    s2.push(s1.pop());
                }
                s1.pop();
                while(!s2.isEmpty() && s2.peek()!=')')
                {
                    s3.push(s2.pop());
                }
                while(!s3.isEmpty())
                {
                    s1.push(s3.pop());
                }
            }
            idx++;
        }
        
        StringBuilder res = new StringBuilder("");
        while(!s1.isEmpty())
        {
            res.append(s1.pop());
        }

        return res.reverse().toString();
    }
    public static void main(String [] args)
    {
        System.out.println(reverseParentheses("(u(love)i)")); 
    }
}
