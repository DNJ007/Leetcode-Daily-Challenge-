import java.util.*;
public class _10_13_24_Smallest_Range_Covering_Elements_from_K_Lists
{
    static class element implements Comparable<element>
    {
        int value;
        int row;
        int col;

        element(int value,int row,int col)
        {
            this.value = value;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(element e2)
        {
            return Integer.compare(this.value,e2.value);
        }
    }

    public static int[] smallestRange(List<List<Integer>> nums) 
    {
        PriorityQueue<element> minHeap = new PriorityQueue<>();
        int max = Integer.MIN_VALUE;
        int[] listsize = new int[nums.size()];
        for(int i=0;i<nums.size();i++)
        {
            listsize[i] = nums.get(i).size();
            max = Math.max(max,nums.get(i).get(0));
            minHeap.add(new element(nums.get(i).get(0),i,0));
        }        

        int ansEnd = max;
        int ansStart = minHeap.peek().value;

        while(!minHeap.isEmpty())  
        {
            element e = minHeap.poll();
            int min = e.value;

            if(max - min < ansEnd - ansStart)
            {
                ansEnd = max;
                ansStart = min;
            }

            if(e.col+1< listsize[e.row])
            {
                max = Math.max(max, nums.get(e.row).get(e.col + 1));
                minHeap.add(new element(nums.get(e.row).get(e.col + 1),e.row,e.col+1));
            }
            else
            {
                break;
            }            
        } 
        return new int[] {ansStart,ansEnd};
    }
    public static void main(String [] args)
    {
        List<List<Integer>> Al = new ArrayList<>();
        Al.add(Arrays.asList(4,10,15,24,26));
        Al.add(Arrays.asList(0,9,12,20));
        Al.add(Arrays.asList(5,18,22,30));
        int[] arr = smallestRange(Al);

        for(int i=0;i<arr.length;i++)
        {
            System.out.print(arr[i]+" ");
        }
    }
}