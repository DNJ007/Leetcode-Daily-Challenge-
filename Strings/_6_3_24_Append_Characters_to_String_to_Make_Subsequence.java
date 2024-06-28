public class _6_3_24_Append_Characters_to_String_to_Make_Subsequence
{
    public static int appendCharacters(String s, String t) {
        int i,j =0;
        for(i=0,j=0;i<s.length()&&j<t.length();)
        {            
            if(s.charAt(i) == t.charAt(j))
            {                    
                j++;
            }
            i++;            
        }        
        return t.length() - j;
    }
    public static void main(String [] args)
    {
        String s = "coaching"; String t = "coding";
        System.out.println(appendCharacters(s,t)); 
    }

}