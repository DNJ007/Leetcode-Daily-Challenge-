import java.util.*;
public class _3_21_25_Find_All_Possible_Recipes_from_Given_Supplies 
{
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) 
    {
        int n = recipes.length;
        HashSet<String> hs = new HashSet<>(Arrays.asList(supplies));
        List<String> res = new ArrayList<>();

        HashMap<String,List<Integer>> adj = new HashMap<>();

       int[] indegree = new int[n]; 
        for(int i=0;i<n;i++)
        {
            for(String ing : ingredients.get(i))
            {
                if(!hs.contains(ing))
                {
                    adj.computeIfAbsent(ing, k -> new ArrayList<>()).add(i);
                    indegree[i]++;
                }
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if(indegree[i] == 0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int i = q.poll();
            String r = recipes[i];
            res.add(r);
            hs.add(r);
            for(int idx : adj.getOrDefault(r, new ArrayList<>()))
            {
               indegree[idx]--;
               if(indegree[idx]==0)
               {
                    q.add(idx);
               }
            }
        }

        return res;
    }

    public static void main(String[] args) 
    {
        String[] recipes = { "bread", "sandwich", "burger" };
        String[][] ingredients = { { "yeast", "flour" }, { "bread", "meat" }, { "sandwich", "meat", "bread" } };
        List<List<String>> ingredientsList = new ArrayList<>();
        for (String[] arr : ingredients) 
        {
            ingredientsList.add(Arrays.asList(arr));
        }
        String[] supplies = { "yeast", "flour", "meat" };
        System.out.println(findAllRecipes(recipes, ingredientsList, supplies));
    }
}

