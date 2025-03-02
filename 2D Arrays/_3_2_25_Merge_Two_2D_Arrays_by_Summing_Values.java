import java.util.ArrayList;
import java.util.List;

public class _3_2_25_Merge_Two_2D_Arrays_by_Summing_Values 
{
    public static int[][] mergeArrays(int[][] nums1, int[][] nums2) 
    {
        int i=0;
        int j=0;
        List<ArrayList<Integer>> Al = new ArrayList<>();
        while(i<nums1.length && j<nums2.length)
        {   
            ArrayList<Integer> Al2 = new ArrayList<>();
            if(nums1[i][0] == nums2[j][0])
            {   
                Al2.add(nums1[i][0]);
                Al2.add(nums1[i][1]+nums2[j][1]);
                i++;j++;
            }
            else if(nums1[i][0] < nums2[j][0])
            {                 
                Al2.add(nums1[i][0]);
                Al2.add(nums1[i][1]);   
                i++;
            }
            else
            {
                Al2.add(nums2[j][0]);
                Al2.add(nums2[j][1]);   
                j++;
            }
            Al.add(Al2);
        }

        while(i<nums1.length)
        {
            ArrayList<Integer> Al2 = new ArrayList<>();
            Al2.add(nums1[i][0]);
            Al2.add(nums1[i][1]); 
            Al.add(Al2);  
            i++;
        }
        while(j<nums2.length)
        {
            ArrayList<Integer> Al2 = new ArrayList<>();
            Al2.add(nums2[j][0]);
            Al2.add(nums2[j][1]); 
            Al.add(Al2);  
            j++;
        }

        int[][]res = new int[Al.size()][2];
        for(int k=0;k<Al.size();k++)
        {
            res[k][0] = Al.get(k).get(0);
            res[k][1] = Al.get(k).get(1);
        }
        return res;        
    }

    public static void main(String[] args) 
    {
        int[][] nums1 = {{1,2},{2,3},{4,5}};
        int[][] nums2 = {{1,4},{3,2},{4,1}};
        
        int[][] res =mergeArrays(nums1, nums2);
        for(int i=0;i<res.length;i++)
        {
            System.out.println(res[i][0]+" "+res[i][1]);
        }
    }
    
}
