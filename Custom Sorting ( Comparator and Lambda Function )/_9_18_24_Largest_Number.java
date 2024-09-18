import java.util.*;
public class _9_18_24_Largest_Number
{
    static class Comp implements Comparator<String>
    {
        Comp(){
        }

        @Override
        public int compare(String a,String b)
        {
            String ab = a + b;
            String ba = b + a;

            int comparison = ab.compareTo(ba);
            return (-1) * comparison;
        }
    }
    
    public static String largestNumber(int[] nums) 
    {        
        String str[] = new String[nums.length];
        int i = 0;
        for(int num : nums)
        {
            str[i++] = String.valueOf(num);
        }
        Arrays.sort(str,new Comp());
        String ans = "";

        for(String s : str)
        {
            ans += s;
        }

        boolean flag = true;
        for(String s : str)
        {
            if(Integer.parseInt(s) != 0)
            {
                flag = false;
                break;
            }
        }
        if(flag)
        {
            return "0";
        }
        return ans;
    }
    public static void main(String [] args)
    {
        int[] nums = {3,30,34,5,9};
        System.out.println(largestNumber(nums)); 
    }
}