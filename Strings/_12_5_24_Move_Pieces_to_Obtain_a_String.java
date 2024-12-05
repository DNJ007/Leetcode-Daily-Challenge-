public class _12_5_24_Move_Pieces_to_Obtain_a_String 
{
    public static boolean canChange(String start, String target) 
    {
        int i = 0, j = 0;
        int n = start.length();

        while(i<n || j<n)
        {
            while(i<n && start.charAt(i) == '_')
                i++;
            
            while(j<n && target.charAt(j) == '_')
                j++;
            
            if(i == n && j== n)
                return true;
            
            if(i == n || j == n)
                return false;
            
            if(start.charAt(i) != target.charAt(j))
                return false;
            
            if(start.charAt(i) == 'L' && j > i)
                return false;
            
            if(start.charAt(i) == 'R' && j < i)
                return false;

            i++;
            j++;
        }
        return true;        
    }

    public static void main(String[] args) 
    {
        String start = "_L__R__R_", target = "L______RR";
        System.out.println(canChange(start, target));
        
    }
    
}
