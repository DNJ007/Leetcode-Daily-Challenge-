public class _3_5_25_Count_total_number_of_colored_cells 
{
    public static long coloredCells(int n) 
    {
        long ans = 1;
        for(int i=1;i<n;i++)
        {
            ans += 4 * i;
        }
        return ans;        
    }
    public static void main(String[] args) {
        System.out.println(coloredCells(5));
    }
}
