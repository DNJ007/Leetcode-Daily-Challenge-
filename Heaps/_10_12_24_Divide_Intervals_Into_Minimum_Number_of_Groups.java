import java.util.Arrays;
import java.util.PriorityQueue;

public class _10_12_24_Divide_Intervals_Into_Minimum_Number_of_Groups 
{
    public static int minGroups(int[][] intervals) 
    {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
 
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for (int[] interval : intervals)
        {
            if (!pq.isEmpty() && pq.peek() < interval[0])
            {
                pq.poll(); 
            }
            pq.add(interval[1]);
        }
        
        return pq.size();

    }

    public static void main(String[] args) 
    {
        int[][] intervals = {{5,10},{6,8},{1,5},{2,3},{1,10}};
        System.out.println(minGroups(intervals));
        
    }
    
}
