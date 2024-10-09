import java.util.Stack;

public class _10_8_24_Min_Number_of_Swaps_To_Make_String_Balanced 
{
    public static int minSwaps(String s) 
    {
        //SPACE OPTIMIZED STACK 
        int res = 0;
        for(int i=0;i<s.length();i++)
        {
            char ch = s.charAt(i);

            if(ch == '[')
            {
                res++;
            }
            else
            {
                if(res > 0)
                {
                    res--;
                }
            }
        }

        return (res+1)/2;        
    }

    public static int minSwaps2(String s) {
        Stack<Character> stack = new Stack<>();
        int unbalanced = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // If an opening bracket is encountered, push it in the stack.
            if (ch == '[') stack.push(ch);
            else {
                // If the stack is not empty, pop it.
                if (!stack.isEmpty()) stack.pop();
                // Otherwise increase the count of unbalanced brackets.
                else unbalanced++;
            }
        }
        return (unbalanced + 1) / 2;
    }
    public static void main(String[] args) {
        String s = "]]][[[";
        System.out.println(minSwaps(s));
        System.out.println(minSwaps2(s));
    }
}
    

