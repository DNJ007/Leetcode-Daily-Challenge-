import java.util.TreeMap;

public class _6_11_24_Relative_Sort_Array {
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        
        TreeMap<Integer,Integer> tm = new TreeMap<Integer,Integer>();

        int temp[] = new int[arr1.length];
        for(int i=0;i<arr1.length;i++)
        {
            tm.put(arr1[i],tm.getOrDefault(arr1[i],0)+1);
        }

        int k = 0;
        for(int i=0;i<arr2.length;i++)
        {
            int num = arr2[i];
            if(tm.containsKey(num))
            {
                int count = tm.get(num);
                while(count > 0)
                {
                    temp[k++] = num;
                    count --;
                    tm.put(num,tm.get(num)-1);
                }                
            }           
        }

        for(int num : tm.keySet())
        {
            int count = tm.get(num);
            while(count > 0)
            {
                temp[k++] = num;
                count --;
                tm.put(num,tm.get(num)-1);
            }
        }

        return temp;
    }
    public static void main(String[] args) {
        int []arr1 = {2,3,1,3,2,4,6,7,9,2,19};
        int []arr2 = {2,1,4,3,9,6};
        arr1 = relativeSortArray(arr1,arr2);

        for(int i=0;i<arr1.length;i++)
        {
            System.out.print(arr1[i]+" ");
        }
    }
}
