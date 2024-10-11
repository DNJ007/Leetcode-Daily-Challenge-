import java.util.*;
public class _10_11_24_The_Number_of_Smallest_Unoccupied_Chair 
{
    static class object implements Comparable<object>
    {
        int start;
        int end;
        int index;

        object(int start,int end,int index)
        {
            this.start = start;
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(object o2)
        {
            if(this.start == o2.start)
            {
                return Integer.compare(this.end,o2.end);
            }
            return Integer.compare(this.start,o2.start);
        }
    }
    static class object2 implements Comparable<object2>
    {
        int end;
        int index;

        object2(int end,int index)
        {
            this.end = end;
            this.index = index;
        }

        @Override
        public int compareTo(object2 o2)
        {
            return Integer.compare(this.end,o2.end);
        }
    }
    public static int smallestChair(int[][] times, int targetFriend) 
    {
        ArrayList<object> Al = new ArrayList<>();
        for(int i=0;i<times.length;i++)
        {
            Al.add(new object(times[i][0],times[i][1],i));
        }
        Collections.sort(Al);

        int chair[] = new int[times.length];
       
        PriorityQueue<object2> minEndTime = new PriorityQueue<>();

        PriorityQueue<Integer> freeChairs = new PriorityQueue<>();
        for(int i=0;i<times.length;i++)
        {
            freeChairs.add(i);
        }

        for(object obj : Al)
        {
            while(!minEndTime.isEmpty() && minEndTime.peek().end <= obj.start)
            {
                freeChairs.add(minEndTime.poll().index);
            }

            int assignedChair = freeChairs.poll();
            chair[obj.index] = assignedChair;

            if(obj.index == targetFriend)
            {
                return assignedChair;
            }

            minEndTime.add(new object2(obj.end,assignedChair));
        }
        return -1;
    }


    public static void main(String[] args) 
    {
        int[][] times ={{3,10},{1,5},{2,4},{3,5},{6,7}};
        System.out.println(smallestChair(times, 3));        
    }
    
}
