public class _9_9_24_Spiral_Matrix_IV 
{
    public static class ListNode 
    {
             int val;
             ListNode next;
             ListNode() {}
             ListNode(int val) { this.val = val; }
             ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public static int[][] spiralMatrix(int m, int n, ListNode head) 
    {
        int[][] mat = new int[m][n];
        int visitedCells = 0;
        int totalCells = m*n;

        ListNode temp = head;

        int i = 0;
        int j = 0;

        int top = 0;
        int bottom = m-1;
        int left = 0;
        int right = n-1;

        while(visitedCells < totalCells)
        {
            for(j=left;j<=right && visitedCells < totalCells;j++)
            {
                if(temp == null)
                {
                    mat[top][j] = -1;
                    visitedCells++;
                    continue;
                }
                mat[top][j] = temp.val;
                visitedCells++;
                temp = temp.next;
            }
            top++;

            for(i=top;i<=bottom && visitedCells < totalCells;i++)
            {
                if(temp == null)
                {
                    mat[i][right] = -1;
                    visitedCells++;
                    continue;
                }
                mat[i][right] = temp.val;
                visitedCells++;
                temp = temp.next;
            }
            right--;

            for(j = right;j>=left && visitedCells < totalCells;j--)
            {
                if(temp == null)
                {
                    mat[bottom][j] = -1;
                    visitedCells++;
                    continue;
                }
                mat[bottom][j] = temp.val;
                visitedCells++;
                temp = temp.next;
            }
            bottom--;

            for(i = bottom;i>=top && visitedCells < totalCells;i--)
            {
                if(temp == null)
                {
                    mat[i][left] = -1;
                    visitedCells++;
                    continue;
                }
                mat[i][left] = temp.val;
                visitedCells++;
                temp = temp.next;
            }
            left++;
        }
        return mat;
    }

    public static void main(String[] args) 
    {
        int m = 3, n = 5;
        
        ListNode head = new ListNode(3);
        head.next = new ListNode(0);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(6);
        head.next.next.next.next = new ListNode(8);
        head.next.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next.next = new ListNode(7);
        head.next.next.next.next.next.next.next = new ListNode(9);
        head.next.next.next.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next.next.next.next.next.next = new ListNode(0);

        int[][] mat = spiralMatrix(m, n, head);

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
