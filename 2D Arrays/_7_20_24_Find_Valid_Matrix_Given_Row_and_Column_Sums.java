public class _7_20_24_Find_Valid_Matrix_Given_Row_and_Column_Sums 
{
    public static int[][] restoreMatrix(int[] rowSum, int[] colSum) 
    {
        // T.C : O(M*N)
        // S.C : O(1)
        int[][] matrix = new int[rowSum.length][colSum.length];

        for (int i = 0; i < rowSum.length; i++) 
        {
            for (int j = 0; j < colSum.length; j++) 
            {
                if (rowSum[i] <= colSum[j]) 
                {
                    matrix[i][j] = rowSum[i];
                    colSum[j] -= rowSum[i];
                    rowSum[i] = 0;
                } else if (colSum[j] < rowSum[i]) 
                {
                    matrix[i][j] = colSum[j];
                    rowSum[i] -= colSum[j];
                    colSum[j] = 0;
                }
            }
        }

        return matrix;

    }

    public static void main(String[] args) 
    {
        int[] rowSum = { 3, 8 }, colSum = { 4, 7 };
        int[][] matrix = restoreMatrix(rowSum, colSum);

        for (int i = 0; i < matrix.length; i++) 
        {
            for (int j = 0; j < matrix[0].length; j++) 
            {
                System.out.println(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
}