import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class _6_15_24_IPO 
{
    static class Project implements Comparable<Project>{
        int capital;
        int profit;

        Project(int capital,int profit)
        {
            this.capital = capital;
            this.profit = profit;
        }

        public int compareTo(Project p2)
        {
            return this.capital - p2.capital;
        }
    }
    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {

        int n = capital.length;

        Project[] project = new Project[n];

        for(int i=0;i< n;i++)
        {
            project[i] = new Project(capital[i],profits[i]);
        }

        Arrays.sort(project);

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(n,Collections.reverseOrder());

        int currIdx = 0;

        for(int i=0;i<k;i++)
        {
            while(currIdx < n && project[currIdx].capital <= w)
            {
                pq.add(project[currIdx++].profit);
            }

            if(pq.isEmpty())
            {
                break;
            }

            w += pq.poll();
        }
        return w;
        
    }


    public static void main(String[] args) 
    {
        int k =2,w=0;
        int[] profits = {1,2,3};
        int[] capital = {0,1,1};
        System.out.println(findMaximizedCapital(k, w, profits, capital));
    }
    
}
