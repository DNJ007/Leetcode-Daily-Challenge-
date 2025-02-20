import java.util.*;
public class _2_20_25_Find_Unique_Binary_String 
{
    public static String findDifferentBinaryString(String[] nums) 
    {
        HashSet<String> hs = new HashSet<>();
        for(String s : nums)
        {
            hs.add(s);
        }

        int n = nums[0].length();
        StringBuilder sb = new StringBuilder("");
        solve(sb,n,hs);  

        return sb.toString();      
    }

    public static boolean solve(StringBuilder sb, int n,HashSet<String> hs)
    {
        if(n == sb.length())
        {
            if(!hs.contains(sb.toString()))
            {
                return true;
            }
            return false;
        }
        for(char ch = '0'; ch <= '1' ; ch++)
        {
            sb.append(ch);
            if(solve(sb,n,hs))
            {
                return true;
            }
            sb.deleteCharAt(sb.length()-1);
        }
       return false;
    }

    public static String findDifferentBinaryStringOpt(String[] nums) 
    {
        int n = nums[0].length();
        StringBuilder sb = new StringBuilder("");
       
        for(int i=0;i<n;i++)
        {
            char ch = nums[i].charAt(i) == '0' ? '1' : '0';
            sb.append(ch);
        }
        return sb.toString();      
    }
    public static void main(String[] args) 
    {
        String nums[] = {"111","011","001"};
        System.out.println(findDifferentBinaryStringOpt(nums));
        
    }
    
}
