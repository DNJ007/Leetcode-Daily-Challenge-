import java.util.*;

public class _3_21_25_Find_All_Possible_Recipes_from_given_supplies 
{
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) 
    {
        int n = recipes.length;
        HashSet<String> hs = new HashSet<>(Arrays.asList(supplies));
        boolean[] cooked = new boolean[n];

        List<String> res = new ArrayList<>();

        int count = n;
        while (count-- > 0) {
            for (int i = 0; i < recipes.length; i++) 
            {
                if (cooked[i]) 
                {
                    continue;
                }
                boolean flag = true;
                for (int j = 0; j < ingredients.get(i).size(); j++) 
                {
                    String s = ingredients.get(i).get(j);
                    if (!hs.contains(s)) 
                    {
                        flag = false;
                        break;
                    }
                }
                if (flag) 
                {
                    res.add(recipes[i]);
                    hs.add(recipes[i]);
                    cooked[i] = true;
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