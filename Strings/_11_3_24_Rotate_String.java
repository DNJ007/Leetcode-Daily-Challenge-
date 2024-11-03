public class _11_3_24_Rotate_String
{
    public static boolean rotateString2(String s, String goal) 
    {
        if(s.length()!=goal.length())
            return false;

        String str = s+s;

        return str.contains(goal) ? true : false;
    }

    public static boolean rotateString(String s, String goal) 
    {
            int i=0;
    
            if(goal.length() == 1 && s.length() == 1)
            {
                return goal.equals(s);
            }
            while(i<goal.length())
            {
                StringBuilder temp = new StringBuilder("");
                if(s.length() > 1)
                    temp.append(s.charAt(s.length()-1));
                    temp.append(s.substring(0,s.length()-1));
    
                if(temp.toString().equals(goal))
                {
                    return true;
                }
                s = temp.toString();
                i++; 
            }
            
            return false;
    }
    
    public static void main(String [] args)
    {
        System.out.println(rotateString("abcde", "cdeab"));
        System.out.println(rotateString2("abcde", "abced")); 
    }
}