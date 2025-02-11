import java.util.Stack;

public class _2_11_25_Remove_All_Occurences_of_Substring 
{
    public static String removeOccurrences(String s, String part) {
        Stack<Character> stk = new Stack<>();
        int m = s.length();
        int n = part.length();

        for (int i = 0; i< m; i++) 
        {
            stk.push(s.charAt(i));

            if (stk.size() >= n && checkMatch(stk, part, n)) 
            {
                for (int j = 0; j < n; j++) 
                {
                    stk.pop();
                }
            }
        }


        StringBuilder res = new StringBuilder();
        while (!stk.isEmpty()) 
        {
            res.append(stk.pop());
        }
        res.reverse();

        return res.toString();
    }

    
    private static boolean checkMatch(Stack<Character> stk,String part,int n) 
    {
        Stack<Character> temp = new Stack<>();
        temp.addAll(stk); 


        for (int i = n - 1; i >= 0; i--) 
        {
            if (temp.isEmpty() || temp.peek() != part.charAt(i)) 
            {
                return false;
            }
            temp.pop();
        }
        return true;
    }
    public static void main(String[] args) 
    {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));
        
    }
    
}
