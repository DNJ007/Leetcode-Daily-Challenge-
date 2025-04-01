import java.util.*;

public class _3_28_25_Maximum_Number_of_Points_From_Grid_Queries
{
    static class element implements Comparable<element>
    {
        int idx;
        int num;
        element(int num,int idx)
        {
            this.num = num;
            this.idx = idx;
        }

        @Override
        public int compareTo(element e2)
        {
            return Integer.compare(this.num,e2.num);
        }
    }

    static class object implements Comparable<object>
    {
        int num;
        int i;
        int j;

        object(int num,int i,int j)
        {
            this.num = num;
            this.i = i;
            this.j = j;
        }

        @Override
        public int compareTo(object o2)
        {
            return Integer.compare(this.num,o2.num);
        }
    }

    public static int[] maxPoints(int[][] grid, int[] queries) 
    {
        List<element> Al = new ArrayList<>();
        for(int i=0;i<queries.length;i++)
        {
            Al.add(new element(queries[i],i));
        }
        Collections.sort(Al);

        PriorityQueue<object> pq = new PriorityQueue<>();
        boolean[][] vis = new boolean[grid.length][grid[0].length];
        int points = 0;
        pq.add(new object(grid[0][0],0,0));
        vis[0][0] = true;
        int[] res = new int[queries.length];
        int[][] directions = {{0,1},{1,0},{0,-1},{-1,0}};
        for(int i=0;i<Al.size();i++)
        {
            int num = Al.get(i).num;
            int idx = Al.get(i).idx;
            while(!pq.isEmpty() && pq.peek().num < num)
            {
                int x = pq.peek().i;
                int y = pq.peek().j;
                pq.poll();
                points++;

                for(int[] dir : directions)
                {
                    int i_ = x + dir[0];
                    int j_ = y + dir[1];

                    if(i_>=0 && i_<grid.length && j_>=0 && j_<grid[0].length && !vis[i_][j_])
                    {
                        pq.add(new object(grid[i_][j_],i_,j_));
                        vis[i_][j_] = true;
                    }
                }
            }
            res[idx] = points;            
        }

        return res;
        
    }
    public static void main(String [] args)
    {
        int[][]grid = {{1,2,3},{2,5,7},{3,5,1}};
        int[] queries = {5,6,2};
        System.out.println(maxPoints(grid, queries)); 
    }
}