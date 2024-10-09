import java.util.Stack;

public class _10_9_24_Min_Add_to_Make_Parentheses_Valid 
{
    public static int minAddToMakeValid(String s) 
    {
        Stack<Character> s1 = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch == '(')
            {
                s1.push(ch);
            }

            if(ch == ')' && !s1.isEmpty() )
            {
                if(s1.peek() == '(')
                {
                    s1.pop();
                }         
                else
                {
                    s1.push(ch);
                }           
            }
            else if(ch == ')' && s1.isEmpty())
            {
                s1.push(ch);
            }
        }

        return s1.size();
        
    }
    public static void main(String[] args) 
    {
        String s = "()))((";
        System.out.println(minAddToMakeValid(s));
    }
    
}
