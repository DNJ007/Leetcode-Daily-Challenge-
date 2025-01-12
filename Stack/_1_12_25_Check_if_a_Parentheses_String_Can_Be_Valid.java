import java.util.Stack;

public class _1_12_25_Check_if_a_Parentheses_String_Can_Be_Valid 
{
    public static boolean canBeValidOptimized(String s, String locked) 
    {
        if(s.length()%2!=0)
        {
            return false;
        }
        
        int open = 0;
        for(int i=0;i<s.length();i++)
        {
            if(open < 0)
            {
                return false;
            }
            if(locked.charAt(i) == '0' || s.charAt(i) == '(')
            {
                open++;
            }
            else
            {
                open--;
            }
        }

        int close = 0;
        for(int i=s.length()-1;i>=0;i--)
        {
            if(close < 0)
            {
                return false;
            }
            if(locked.charAt(i) == '0' || s.charAt(i) == ')')
            {
                close++;
            }
            else{
                close--;
            }
        }

        return true;
        
    }   

    public static boolean canBeValid(String s, String locked) 
    {
        if(s.length()%2!=0)
        {
            return false;
        }
        Stack<Integer> open = new Stack<>();
        Stack<Integer> openClose = new Stack<>();
        for(int i=0;i<s.length();i++)
        {
            if(locked.charAt(i)=='1')
            {   
                if(s.charAt(i)== '(')
                {
                    open.push(i);
                }
                else if(s.charAt(i) == ')')
                {
                    if(!open.isEmpty())
                    {
                        open.pop();
                    }
                    else if(!openClose.isEmpty())
                    {
                        openClose.pop();
                    }
                    else
                    {
                        return false;
                    }
                }
            }
            else
            {
                openClose.push(i);
            }
        }

        if(open.isEmpty())
        {
            return true;
        }

        while(!open.isEmpty() && !openClose.isEmpty() && open.peek() < openClose.peek())
        {
            open.pop();
            openClose.pop();
        }
        if(!open.isEmpty())
        {
            return false;
        }
        return true;
        
    }


    public static void main(String[] args) {
        String s = "))()))";
        String locked = "010100";
        System.out.println(canBeValidOptimized(s, locked));
    }
    
}
