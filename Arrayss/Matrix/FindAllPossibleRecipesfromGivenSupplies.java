package Arrayss.Matrix;

import java.util.*;

public class FindAllPossibleRecipesfromGivenSupplies {
    /**
     * 2115. Find All Possible Recipes from Given Supplies
     * You have information about n different recipes. You are given a string array recipes and a 2D string array ingredients. The ith recipe has the name recipes[i], and you can create it if you have all the needed ingredients from ingredients[i]. A recipe can also be an ingredient for other recipes, i.e., ingredients[i] may contain a string that is in recipes.
     *
     * You are also given a string array supplies containing all the ingredients that you initially have, and you have an infinite supply of all of them.
     *
     * Return a list of all the recipes that you can create. You may return the answer in any order.
     *
     * Note that two recipes may contain each other in their ingredients.
     *
     *
     *
     * Example 1:
     *
     * Input: recipes = ["bread"], ingredients = [["yeast","flour"]], supplies = ["yeast","flour","corn"]
     * Output: ["bread"]
     * Explanation:
     * We can create "bread" since we have the ingredients "yeast" and "flour".
     * Example 2:
     *
     * Input: recipes = ["bread","sandwich"], ingredients = [["yeast","flour"],["bread","meat"]], supplies = ["yeast","flour","meat"]
     * Output: ["bread","sandwich"]
     * Explanation:
     * We can create "bread" since we have the ingredients "yeast" and "flour".
     * We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
     * Example 3:
     *
     * Input: recipes = ["bread","sandwich","burger"], ingredients = [["yeast","flour"],["bread","meat"],["sandwich","meat","bread"]], supplies = ["yeast","flour","meat"]
     * Output: ["bread","sandwich","burger"]
     * Explanation:
     * We can create "bread" since we have the ingredients "yeast" and "flour".
     * We can create "sandwich" since we have the ingredient "meat" and can create the ingredient "bread".
     * We can create "burger" since we have the ingredient "meat" and can create the ingredients "bread" and "sandwich".
     *
     *
     * Constraints:
     *
     * n == recipes.length == ingredients.length
     * 1 <= n <= 100
     * 1 <= ingredients[i].length, supplies.length <= 100
     * 1 <= recipes[i].length, ingredients[i][j].length, supplies[k].length <= 10
     * recipes[i], ingredients[i][j], and supplies[k] consist only of lowercase English letters.
     * All the values of recipes and supplies combined are unique.
     * Each ingredients[i] does not contain any duplicate values.
     * */
    public static void main(String[] args) {
        String[] recipes = {"bread","sandwich","burger"};
        List<List<String>> ingredients = List.of(List.of("yeast","flour"), List.of("bread","meat"), List.of("sandwich","meat","bread"));
        String[] supplies = {"yeast","flour","meat"};
        System.out.println(findAllRecipes(recipes, ingredients, supplies));
    }

    //Solution 1 : Using Set
    //Time Complexity: O(n * m) where n is the number of recipes and m is the number of ingredients in each recipe
    //Space Complexity: O(n * m)
    public static List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Set<String> processed = new HashSet<>();
        List<String> ans = new ArrayList<>();

        boolean added = true;

        while (added) {
            added = false;

            for (int i = 0; i < recipes.length; i++) {
                if (processed.contains(recipes[i])) continue;

                boolean canMake = true;
                for (String ingredient : ingredients.get(i)) {
                    if (!available.contains(ingredient)) {
                        canMake = false;
                        break;
                    }
                }

                if (canMake) {
                    available.add(recipes[i]);
                    ans.add(recipes[i]);
                    processed.add(recipes[i]);
                    added = true;
                }
            }
        }

        return ans;
    }

}
