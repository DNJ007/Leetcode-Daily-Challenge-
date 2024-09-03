public class _2_9_24_Convert_1D_Array_Into_2D_Array 
{
    public static int[][] construct2DArray(int[] original, int m, int n) 
    {
        if(original.length != m*n )
        {
            return new int[][]{};
        }
        int[][] mat = new int[m][n];

        int i = 0;
        int row = 0;
        int col = 0;

        while(row < m)
        {
            col = 0;
            while(i <= (row+1) * n-1)
            {
                mat[row][col] = original[i++];
                col++;
            }
            row++;
        }
        print(mat);
        return mat;
    }

    public static void print(int[][] mat)
    {
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) 
    {
        int[] original = {1,2,3,4};
        int m = 2, n = 2;

        construct2DArray(original, m, n);
    }
    
}
