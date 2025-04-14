import java.util.ArrayList;

public class _4_14_25_Count_Good_Triplets
{
    static class element 
    {
        int i;
        int j;
        element(int i,int j)
        {
            this.i = i;
            this.j = j;
        }
    }
    public static int countGoodTriplets(int[] arr, int a, int b, int c) 
    {
        int count = 0;
        ArrayList<element> Al = new ArrayList<>();

        for(int i=0;i<arr.length-2;i++)
        {
            for(int j=i+1;j<arr.length-1;j++)
            {
                if(Math.abs(arr[i]-arr[j])<=a)
                {
                    Al.add(new element(i,j));
                }                
            }
        }

        for(element e : Al)
        {
            int i = e.i;
            int j = e.j;

            for(int k=j+1;k<arr.length;k++)
            {
                if(Math.abs(arr[j]-arr[k])<=b &&
                Math.abs(arr[i]-arr[k])<=c )
                {
                    count++;
                }
            }
        }
        
        return count;
        
    }
    public static void main(String [] args)
    {
        int[] arr = {3,0,1,1,9,7};
        int a = 7, b = 2, c = 3;
        System.out.println(countGoodTriplets(arr, a, b, c)); 
    }
}