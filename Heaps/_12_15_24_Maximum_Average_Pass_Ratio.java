import java.util.PriorityQueue;

public class _12_15_24_Maximum_Average_Pass_Ratio
{
    static class element implements Comparable<element>
    {
        int passStudents;
        int totalStudents;
        double passRatio;

        public element(int passStudent,int totalStudents)
        {
            this.passStudents = passStudent;
            this.totalStudents = totalStudents;
            this.passRatio = (double) passStudents / totalStudents;
        }

        @Override
        public int compareTo(element e2)
        {
            double improvement1 = ((double) (this.passStudents + 1) / (this.totalStudents+1)) - this.passRatio;
            double improvement2 = ((double) (e2.passStudents + 1) / (e2.totalStudents+1)) - e2.passRatio;
            return Double.compare(improvement2,improvement1);
        }
    }
    public static double maxAverageRatio(int[][] classes, int extraStudents) 
    {
        PriorityQueue<element> pq = new PriorityQueue<>();
        for(int []classy : classes)
        {
            pq.add(new element (classy[0],classy[1]));
        }

        while(extraStudents > 0)
        {
            element e = pq.poll();
            e.passStudents++;
            e.totalStudents++;
            e.passRatio = (double) e.passStudents /  e.totalStudents;
            pq.add(e);

            extraStudents--;
        }

        double sum = 0.0;
        while(!pq.isEmpty())
        {
            element e = pq.poll();
            sum += e.passRatio;
        }

        return sum/classes.length;

    }
    public static void main(String [] args)
    {
        int[][] classes = {{1,2},{3,5},{2,2}};
        int extraStudents = 2;
        System.out.println(maxAverageRatio(classes, extraStudents)); 
    }
}