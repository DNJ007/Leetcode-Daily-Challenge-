import java.util.PriorityQueue;

public class _8_12_24_Kth_Largest_Element_in_a_Stream 
{
    PriorityQueue<Integer> heap = new PriorityQueue<>();
    int k;
    public _8_12_24_Kth_Largest_Element_in_a_Stream(int k, int[] nums) 
    {
        this.k = k;
        for(int n:nums)
        {
            add(n);
        }
    }
    
    public int add(int val) 
    {
       if(heap.size()<k)
           heap.offer(val);
        else if(val > heap.peek())
        {
            heap.poll();
            heap.offer(val);
        }
        return heap.peek();
    }
    
}
