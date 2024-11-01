public class _11_1_24_Delete_Characters_to_Make_Fancy_String 
{   
    public static String makeFancyString(String s) 
    {
        int count = 1;
        char prev = s.charAt(0);
        StringBuilder str = new StringBuilder("");
        str.append(prev);
        for(int i=1;i<s.length();i++)
        {
            char ch = s.charAt(i);
            if(ch == prev)
            {
                count++;
                if(count <= 2)
                {
                    str.append(ch);
                }
            }
            else
            {
                count = 1;
                str.append(ch);
            }
            prev = ch;
        }

        return str.toString();
    }

    public static void main(String[] args) 
    {
        System.out.println(makeFancyString("aaaabaaaa"));
        
    }
}
    

