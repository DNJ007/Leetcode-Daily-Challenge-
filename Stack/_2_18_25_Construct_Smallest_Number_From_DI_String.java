import java.util.Stack;

public class _2_18_25_Construct_Smallest_Number_From_DI_String
{
    public static String smallestNumber(String pattern) 
    {
        int num = 1;
        pattern += 'X';
        String res = "";
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<pattern.length();i++)
        {
            if(pattern.charAt(i) == 'I')
            {
                if(s.isEmpty())
                {   
                    res += String.valueOf(num++);                    
                }
                else
                {
                    s.push(num++);
                    while(!s.isEmpty())
                    {
                        res += String.valueOf(s.pop());
                    }
                }               
            }
            else
            {
                s.push(num++);
            }
        }
        while(!s.isEmpty())
        {
            res += String.valueOf(s.pop());
        }
        return res;
    }
    public static void main(String [] args)
    {
        String pattern = "IIIDIDDD";
        System.out.println(smallestNumber(pattern)); 
    }
}