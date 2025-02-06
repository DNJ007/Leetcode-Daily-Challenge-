import java.util.HashMap;

public class _2_6_25_Tuple_with_Same_Product 
{
    public static int tupleSameProduct(int[] nums) 
    {
        int count = 0;
        HashMap<Integer,Integer> hm = new HashMap<>();

        for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                hm.put(nums[i]*nums[j],hm.getOrDefault(nums[i]*nums[j],0)+1);
            }
        }
        
        for(int num : hm.keySet())
        {
            int freq = hm.get(num);

            int pairs = ((freq-1)*freq) / 2;
            count += 8*pairs;
        }
        return count;
    }
    public static void main(String[] args) 
    {
        int[] nums = {1,2,4,5,10};
        System.out.println(tupleSameProduct(nums));
    }
}
