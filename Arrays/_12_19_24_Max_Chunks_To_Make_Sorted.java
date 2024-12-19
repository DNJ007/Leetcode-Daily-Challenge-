public class _12_19_24_Max_Chunks_To_Make_Sorted 
{
    public static int maxChunksToSorted(int[] arr) 
    {
        int[] maxLeft = new int[arr.length];
        int[] minRight = new int[arr.length];
        maxLeft[0] = arr[0];
        for(int i=1;i<maxLeft.length;i++)
        {
            maxLeft[i] = Math.max(arr[i],maxLeft[i-1]);
        }

        minRight[minRight.length-1] = arr[minRight.length-1];
        for(int i=minRight.length-2;i>=0;i--)
        {
            minRight[i] = Math.min(arr[i],minRight[i+1]);
        }

        int res = 0;

        for(int i=0;i<arr.length-1;i++)
        {
            if(maxLeft[i] <= minRight[i+1])
                res++;
        }

        return res+1;
    }

    public static void main(String[] args) {
        int[] arr = {2,0,1};
        System.out.println(maxChunksToSorted(arr));
    }

    
}
