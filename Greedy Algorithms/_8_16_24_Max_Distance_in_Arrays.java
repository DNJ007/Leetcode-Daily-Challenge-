import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_16_24_Max_Distance_in_Arrays 
{
    public static int maxDistance(List<List<Integer>> arrays) 
    {
        int max1 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;

        int idx1 = -1;
        for(int i = 0 ; i < arrays.size() ; i++)
        {
            for(int j = 0 ; j < arrays.get(i).size() ; j++)
            {
                if(max1 < arrays.get(i).get(j))
                {
                    max1 = arrays.get(i).get(j);
                    idx1 = i;
                }                             
            }
        }   

        for(int i = 0 ; i < arrays.size() ; i++)
        {
            if(i == idx1)
            {
                continue;
            }
            for(int j = 0 ; j < arrays.get(i).size() ; j++)
            {
                if (min1 > arrays.get(i).get(j))
                {
                    min1 = arrays.get(i).get(j);
                }                              
            }
        }   
        int max2 = Integer.MIN_VALUE;
        int min2 = Integer.MAX_VALUE;

        int idx2 = -1;
        for(int i = 0 ; i < arrays.size() ; i++)
        {
            for(int j = 0 ; j < arrays.get(i).size() ; j++)
            {
                if (min2 > arrays.get(i).get(j))
                {
                    min2 = arrays.get(i).get(j);
                    idx2 = i;
                }                          
            }
        }   

        for(int i = 0 ; i < arrays.size() ; i++)
        {
            if(i == idx2)
            {
                continue;
            }
            for(int j = 0 ; j < arrays.get(i).size() ; j++)
            {                  
                if(max2 < arrays.get(i).get(j))
                {
                    max2 = arrays.get(i).get(j);                    
                }                           
            }
        } 
        

        int res1 = Math.abs(max1 - min1); 
        int res2 = Math.abs(max2 - min2);

        return Math.max(res1,res2);   
    }

    public static void main(String[] args) 
    {
        List<List<Integer>> listOfLists = new ArrayList<>();

        // Create lists
        List<Integer> list1 = Arrays.asList(1, 2, 3);
        List<Integer> list2 = Arrays.asList(4, 5);
        List<Integer> list3 = Arrays.asList(1, 2, 3);

        // Add lists to the list of lists
        listOfLists.add(list1);
        listOfLists.add(list2);
        listOfLists.add(list3);


        System.out.println(maxDistance(listOfLists));
        
    }
    
}
