import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class _8_13_24_Combination_Sum_II
{
    private static void backtrack(List<List<Integer>> result, List<Integer> tempList, int[] candidates, int remain, int start) 
    {
        if (remain < 0) 
        {
            return; 
        } 
        else if (remain == 0) 
        {
            result.add(new ArrayList<>(tempList)); // Found a combination
        } 
        else 
        {
            for (int i = start; i < candidates.length; i++) 
            {
                if (i > start && candidates[i] == candidates[i - 1]) 
                    continue; // Skip duplicates
                tempList.add(candidates[i]);
                backtrack(result, tempList, candidates, remain - candidates[i], i + 1); // i + 1 since each number can only be used once
                tempList.remove(tempList.size() - 1); // Backtrack
            }
        }
    }
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) 
    {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);  
        backtrack(result, new ArrayList<>(), candidates, target, 0);
        return result;
    }
    public static void main(String [] args)
    {
        int[] candidates = {10,1,2,7,6,1,5};
        int target = 8;

        System.out.println(combinationSum2(candidates, target)); 
    }
}
