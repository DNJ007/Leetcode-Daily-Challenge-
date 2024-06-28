import java.util.Arrays;

public class _6_10_24_Height_Checker 
{
    public static int heightChecker(int[] heights) {
        int temp[] = new int[heights.length];
        for(int i=0;i<heights.length;i++)
        {
            temp[i] = heights[i];
        }
        Arrays.sort(temp);
        int count = 0;
        for(int i=0,j=0;i<heights.length && j<temp.length;i++,j++)
        {
            if(heights[i] != temp[j])
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int[] heights = {1,1,4,2,1,3};
        System.out.println(heightChecker(heights));
    }
}
