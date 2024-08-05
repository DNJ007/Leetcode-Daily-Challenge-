import java.util.HashMap;

public class _8_5_24_Kth_Distict_String_in_an_array
{
    public static String kthDistinct(String[] arr, int k) 
    {
        //T.C : O(n)
        //S.C : O(n)
        HashMap<String,Integer> hm = new HashMap<String,Integer>();

        for(String s: arr)
        {
            hm.put(s,hm.getOrDefault(s,0)+1);
        }

        int count = 0;
        for(String s : arr)
        {
            if(hm.get(s) == 1)
            {
                count++;
            
            if(count == k)
            {
                return s;
            }

            }
        }

        return "";
    }
    public static void main(String [] args)
    {
        String[]arr = {"aaa","aa","a"};
        int k = 1;
        System.out.println(kthDistinct(arr, k)); 
    }
}