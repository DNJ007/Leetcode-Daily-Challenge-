import java.util.ArrayList;
import java.util.HashMap;

public class _7_2_24_Intersection_of_Two_Arrays_II
{
    public static int[] intersect(int[] nums1, int[] nums2) 
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
        for(int num : nums1)
        {
            hm.put(num,hm.getOrDefault(num,0)+1);
        }

        ArrayList<Integer> result = new ArrayList<Integer>();
        for(int num : nums2)
        {
            if(hm.containsKey(num) && hm.get(num) > 0)
            {
                result.add(num);
                hm.put(num,hm.get(num)-1);
            }
        }

        int res[] = new int[result.size()];
        for(int i=0;i<result.size();i++)
        {
            res[i] = result.get(i);
        }
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
        return res;
    }

    public static void main(String [] args)
    {
        int []nums1 = {1,2,2,1};
        int []nums2 = {2,2};
        intersect(nums1,nums2); 
    }
}