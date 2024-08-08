import java.util.ArrayList;

public class _8_8_24_Spiral_Matrix_III 
{
    public static int[][] spiralMatrixIII(int rows, int cols, int rStart, int cStart) 
    {
        int startrow = rStart;
        int startcol = cStart;
        
        ArrayList<int[]> Al= new ArrayList<int[]>();
        Al.add(new int[]{startrow,startcol});

        int step = 1;
        int totalCells = rows*cols;

    while(Al.size() < totalCells)
    {
        for(int j=1;j<=step;j++)
        {
            startcol++;
            if(startcol>=0 && startcol<cols && startrow>=0 && startrow<rows)
            {
                Al.add(new int[]{startrow,startcol});
            }            
        }
        
       
        for(int i=1;i<=step;i++)
        {
            startrow++;
            if(startcol >=0 && startcol < cols && startrow >=0 && startrow < rows)
            {
                Al.add(new int[]{startrow,startcol});
            }            
        }
        step++;

        
        for(int j=1;j<=step;j++)
        {
            startcol--;
            if(startcol >= 0 && startcol < cols && startrow >= 0 && startrow < rows)
            {
                Al.add(new int[]{startrow,startcol});
            } 
        }
        

        for(int i=1;i<=step;i++)
        {
            startrow--;
            if(startcol >= 0 && startcol < cols && startrow >= 0 && startrow < rows)
            {
                Al.add(new int[]{startrow,startcol});
            } 
        }
        step = step+1;;
    }
    
        int[][] result = new int[totalCells][2];
        for (int i = 0; i < totalCells; i++) 
        {
            result[i] = Al.get(i);
        }

        return result;
        
    }
    public static void main(String[] args) 
    {
        //spiralMatrixIII(1, 4, 0, 0);        
        int[][]mat = spiralMatrixIII(5, 6, 1, 4);

        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[0].length;j++)
            {
                System.out.print(mat[i][j]+" ");
            }
            System.out.println();
        }
    }
}
