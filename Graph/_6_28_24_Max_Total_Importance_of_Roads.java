import java.util.Arrays;

public class _6_28_24_Max_Total_Importance_of_Roads
{
    public static long maximumImportance(int n, int[][] roads) 
    {
        long[] degree = new long[n];
        for(int i=0;i<degree.length;i++)
        {
            degree[i] = 0;
        }
        for(int i=0;i<roads.length;i++)
        {
            degree[roads[i][0]]++;
            degree[roads[i][1]]++;
        }
        Arrays.sort(degree);

        long value = 1;
        long totalImportance = 0;

        for(int i=0;i<degree.length;i++)
        {
            totalImportance += degree[i]*value;
            value++;
        }
        return totalImportance;

    }
    public static void main(String [] args)
    {
        int n = 5;
        int [][]roads = {{0,1},{1,2},{2,3},{0,2},{1,3},{2,4}};
        System.out.println(maximumImportance(n, roads)); 
    }
}