public class _7_30_24_Min_Deletions_to_make_string_balanced 
{
    public static int minimumDeletions(String s) 
    {
        //T.C : O(n)
        //S.C : O(1)
        int bCount = 0; 
        int deletions = 0; 
        
        for(int i=0;i<s.length();i++) 
        {
            char c = s.charAt(i);
            if (c == 'b') 
            {
                bCount++;
            } 
            else if (c == 'a') 
            {
                if (bCount > 0) 
                {
                    deletions++;
                    bCount--;
                }
            }
        }
        
        return deletions;
        
    }
    public static void main(String[] args) 
    {
        String  s = "aababbab";
        System.out.println(minimumDeletions(s));
    }    
}
