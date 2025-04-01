import java.util.*;
public class _3_27_25_Minimum_Index_of_a_Valid_Split 
{
    static class element implements Comparable<element>
    {
        int num;
        int freq;

        element(int num,int freq)
        {
            this.num = num;
            this.freq = freq;
        }

        @Override
        public int compareTo(element e2)
        {
            return Integer.compare(e2.freq,this.freq);
        }
    }
    
    public static int minimumIndex(List<Integer> nums) 
    {
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(Integer num : nums)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        PriorityQueue<element> pq = new PriorityQueue<>();
        for(int num : hm.keySet())
        {
            pq.add(new element(num,hm.get(num)));
        }

        element e = pq.poll();
        int dominantNumber = e.num;

        int count = 0;
        for(int i=0;i<nums.size();i++)
        {
            if(nums.get(i) == dominantNumber)
            {
                count++;
            }
            //check
            int len = i+1;
            float r1 = (float)count/(float)len;

            int otherlen = nums.size()-len;
            int remCount = e.freq - count;

            float r2 = (float)remCount/(float)otherlen;
            if(r1 > 0.5 && r2 > 0.5)
            {
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) 
    {
        List<Integer> nums = Arrays.asList(2,1,3,1,1,1,7,1,2,1);
        System.out.println(minimumIndex(nums));    
    }
}
