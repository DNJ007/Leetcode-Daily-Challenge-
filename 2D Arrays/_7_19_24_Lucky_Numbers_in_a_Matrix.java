import java.util.ArrayList;
import java.util.List;

public class _7_19_24_Lucky_Numbers_in_a_Matrix 
{
    public static List<Integer> luckyNumbers (int[][] matrix) {
        
        List<Integer> Al = new ArrayList<Integer>();
        int min = Integer.MAX_VALUE;
        int colIdx = -1;
        int rowIdx = -1;
        boolean flag = false;

        for(int i=0;i<matrix.length;i++)
        {
            for(int j=0;j<matrix[0].length;j++)
            {
                if(matrix[i][j] < min)
                {
                    min = matrix[i][j];
                    rowIdx = i;
                    colIdx = j;
                    flag = true;
                }
            }

            for(int k=0;k<matrix.length;k++)
            {
                if(matrix[k][colIdx] > matrix[rowIdx][colIdx])
                {
                    flag = false;
                }
            }

            if(flag == true)
            {
                Al.add(matrix[rowIdx][colIdx]);
            }

            flag = false;       
            min = Integer.MAX_VALUE;             
        }

        return Al;
    }
    public static void main(String[] args) {
        int[][]matrix = {{3,7,8},{9,11,13},{15,16,17}};
        System.out.println(luckyNumbers(matrix));
    }
}
