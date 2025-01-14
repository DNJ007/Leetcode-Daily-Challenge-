import java.util.HashMap;

public class _1_14_25_Find_the_Prefix_Common_Array_of_Two_Arrays 
{
    public static int[] findThePrefixCommonArray(int[] A, int[] B) 
    {
        int[] C = new int[A.length];
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();
        for(int i=0;i<A.length;i++)
        {
            if(!hm.containsKey(A[i]))
            {
                hm.put(A[i],hm.getOrDefault(A[i],0)+1);
            }
            else
            {
                count++;
            }

            if(!hm.containsKey(B[i]))
            {
                hm.put(B[i],hm.getOrDefault(B[i],0)+1);
            }
            else
            {
                count++;
            }
            C[i] = count;
        }
        return C;
    }

    public static void main(String[] args) 
    {
        int[] A = {1,3,2,4};
        int[] B = {3,1,2,4};
        int[]C = findThePrefixCommonArray(A, B);
        for(int i=0;i<C.length;i++)
        {
            System.out.println(C[i]+" ");
        }
    }
}
