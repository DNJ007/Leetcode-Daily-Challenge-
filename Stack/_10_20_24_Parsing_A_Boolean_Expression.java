import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _10_20_24_Parsing_A_Boolean_Expression 
{
    private static char solve(char op, List<Character> Al)
    {
        if(op == '!')
            return Al.get(0) == 't' ? 'f' : 't';

        if(op == '&')
            return Al.stream().anyMatch(ch -> ch == 'f') ? 'f' : 't';
        
        if(op == '|')
            return Al.stream().anyMatch(ch -> ch == 't') ? 't' : 'f';
        
        return 't';
    }
    public static boolean parseBoolExpr2(String expression) 
    {
        Stack<Character> s = new Stack<>();

        for(int i=0;i<expression.length();i++)
        {            
            char ch = expression.charAt(i);
            if(ch == ',')
            {
                continue;
            }
            
            if(ch == ')')
            {
                List<Character> Al = new ArrayList<>();

                while(s.peek() != '(')
                {
                    Al.add(s.pop());
                }      
                s.pop();
                char op = s.pop();
                s.push(solve(op,Al));
            }           
            else
            {
                s.push(ch);
            }
        }
        return s.peek() == 't';
    }

    public static boolean parseBoolExpr(String expression) 
    {
        Stack<Character> s = new Stack<>();

        for(char ch : expression.toCharArray())
        {
            
            if(ch == ',' || ch == '(')
            {
                continue;
            }
            if(ch == '&' || ch == 't' || ch == '|' || ch == '!' || ch == 'f')
            {
                s.push(ch);
            }
            else if(ch == ')')
            {
                boolean trueFlag = false, falseFlag = false;

                while(s.peek() != '!' && s.peek() != '&' && s.peek() != '|')
                {
                    char c = s.pop();
                    if(c == 't')
                    {
                        trueFlag = true;
                    }
                    if(c == 'f')
                    {
                        falseFlag = true;
                    }
                }

                char op = s.pop();
                if(op == '!')
                {
                    s.push(trueFlag ? 'f' : 't');
                }
                else if(op == '&')
                {
                    s.push(falseFlag ? 'f' : 't');
                }
                else
                {
                    s.push(trueFlag ? 't' : 'f');
                }            
            }            
        }
        return s.peek() == 't';
    }

    public static void main(String[] args) 
    {
        String expression = "!(&(f,t))";
        System.out.println(parseBoolExpr(expression));
        System.out.println(parseBoolExpr2(expression));
        
    }
}
    

