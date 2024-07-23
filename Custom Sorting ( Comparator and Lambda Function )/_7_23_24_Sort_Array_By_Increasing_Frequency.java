import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class _7_23_24_Sort_Array_By_Increasing_Frequency
{
    static class Object implements Comparable<Object>
    {
        int num;
        int freq;

        public Object(int num,int freq)
        {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(Object o2)
        {
            if(this.freq == o2.freq)
            {
                return o2.num - this.num;
            }
            return this.freq - o2.freq;
        }
    }

    public static int[] frequencySort(int[] nums) 
    {
        //T.C : O(n log n)
        //S.C : O(n)
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<nums.length;i++)
        {
            hm.put(nums[i],hm.getOrDefault(nums[i],0)+1);
        }

        ArrayList<Object> Al = new ArrayList<Object>();

        for(int num : hm.keySet())
        {
            Al.add(new Object(num,hm.get(num)));
        }

        Collections.sort(Al);

        int res[] = new int[nums.length];

        int index = 0;
        for(Object obj : Al)
        {
            for(int i=0;i<obj.freq;i++)
            {
                res[index++] = obj.num;
            }
        }       
        return res;
        
    }
    public static void main(String [] args)
    {
        int [] nums = {-1,1,-6,4,5,-6,1,4,1};
        nums = frequencySort(nums); 
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }
    }
}
