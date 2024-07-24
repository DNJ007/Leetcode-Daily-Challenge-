import java.util.*;

public class _7_24_24_Sort_the_jumbled_numbers
{
    static class Object implements Comparable<Object>
    {
        int num;
        int mappednum;

        public Object(int num,int mappednum)
        {
            this.num = num;
            this.mappednum = mappednum;
        }

        @Override
        public int compareTo(Object o2)
        {          
            return this.mappednum - o2.mappednum;
        }
    }

    public static int[] sortJumbled(int[] mapping, int[] nums) 
    {
        HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();

        for(int i=0;i<mapping.length;i++)
        {
            hm.put(i,mapping[i]);
        }

        int count = 0;
        int number = 0;
        int num = 0;

        int mappednums[] = new int[nums.length];

        for(int i=0;i<nums.length;i++)
        {
            count = 0;
            number = nums[i];
            while(number>0)
            {       
                int q = number%10;        
                num += hm.get(q)*Math.pow(10,count);
                count++;
                number = number/10;
            }
            mappednums[i] = num;
            num = 0;
        }

        ArrayList<Object> Al = new ArrayList<Object>();

        for(int i=0;i<nums.length;i++)
        {
            Al.add(new Object(nums[i],mappednums[i]));
        }

        Collections.sort(Al);

        int res[] = new int[nums.length];
        int i = 0;

        for(Object obj : Al)
        {
            res[i++] = obj.num;
        }
        
        return res;
    }
    public static void main(String [] args)
    {
        int[] mapping = {8,9,4,0,2,1,3,5,7,6}, nums = {991,338,38};
        int res[] = sortJumbled(mapping, nums); 
        for(int i=0;i<res.length;i++)
        {
            System.out.print(res[i]+" ");
        }
    }
}