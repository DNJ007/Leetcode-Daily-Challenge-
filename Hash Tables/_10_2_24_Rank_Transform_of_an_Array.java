import java.util.HashMap;
import java.util.TreeMap;

public class _10_2_24_Rank_Transform_of_an_Array
{
    public static int[] arrayRankTransform(int[] arr) 
    {
        TreeMap<Integer,Integer> freq = new TreeMap<>();
        for(int i=0;i<arr.length;i++)
        {
            freq.put(arr[i],freq.getOrDefault(arr[i],0)+1);
        }

        int r = 1;
        HashMap<Integer,Integer> rank = new HashMap<>();
        for(int num : freq.keySet())
        {
            rank.put(num,r); 
            r++;
        }

        for(int i=0;i<arr.length;i++)
        {
            arr[i] = rank.get(arr[i]);
        }

        return arr;
    }
    public static void main(String [] args)
    {
        int []arr = {37,12,28,9,100,56,80,5,12};
        arr = arrayRankTransform(arr); 

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}