import java.util.PriorityQueue;

public class _12_16_24_Final_Array_State_After_K_Multiplication_Operations_I 
{
    static class element implements Comparable<element>
    {
        int idx;
        int val;

        public element(int val,int idx)
        {
            this.val = val;
            this.idx = idx;
        }

        @Override 
        public int compareTo(element e2)
        {
            if(this.val == e2.val)
            {
                return Integer.compare(this.idx,e2.idx);
            }
            return Integer.compare(this.val,e2.val);
        }
    }

    public static int[] getFinalState(int[] nums, int k, int multiplier) 
    {
        PriorityQueue<element> pq = new PriorityQueue<>();

        for(int i=0;i<nums.length;i++)
        {
            pq.add(new element(nums[i],i));
        }

        while(k > 0)
        {
            element e = pq.poll();
            e.val = e.val * multiplier;
            pq.add(e);
            k--;
        }

        while(!pq.isEmpty())
        {
            element e = pq.poll();
            int idx = e.idx;
            int val = e.val;

            nums[idx] = val;
        }

        return nums;        
    }
    
    public static void main(String[] args) 
    {
        int[] nums = {2,1,3,5,6};
        int k = 5;
        int multiplier = 2;
        nums = getFinalState(nums, k, multiplier);
        for(int i=0;i<nums.length;i++)
        {
            System.out.print(nums[i]+" ");
        }        
    }
}
