public class _2_11_25_Remove_All_Occurences_of_Substring 
{
    public static String removeOccurrences(String s, String part) 
    {
        //T.C : O(N^3)
        //S.C : O(N)
        StringBuilder sb = new StringBuilder(s);
        sb.insert(0,"1");
        sb.append("1");
        int i=0;
        int j=i+1;
       for(;i<sb.length();i++)
       {
            for(j=i+1;j<sb.length();j++)
            {
                if(sb.substring(i,j).equals(part))
                {
                    sb.delete(i,j); 
                    i = 0;
                    j = i+1; 
                }
            }
       }
       
       int l = sb.length();
       return sb.substring(1,l-1);
    }

    public static String removeOccurrences2(String s, String part) 
    {
        //T.C : O(N^2/M)
        //S.C : O(N)
        StringBuilder sb = new StringBuilder(s);
        int index;
        
        while ((index = sb.indexOf(part)) != -1) 
        { 
            sb.delete(index, index + part.length()); 
        }
        
        return sb.toString();
    }

    public static String removeOccurrences3(String s, String part) 
    {
        //T.C : O(N^2/M)
        //S.C : O(N)
        StringBuilder sb = new StringBuilder("");

        for (char ch : s.toCharArray()) 
        { 
            sb.append(ch);
            
            if(sb.length() >= part.length() && sb.substring(sb.length()-part.length()).equals(part))
            {
                sb.delete(sb.length()-part.length(),sb.length());
            }
        }
        
        return sb.toString();
    }

    public static void main(String[] args) 
    {
        String s = "daabcbaabcbc", part = "abc";
        System.out.println(removeOccurrences(s, part));
        
    }
    
}
