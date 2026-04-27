package br.com.pedrohlopes;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class RecipeFile {
    private final ArrayList<Recipe> recipes = new ArrayList<>();

    public boolean addRecipes(String file) {
        String recipeName = "";
        int cookingTime = 0;
        ArrayList<String> ingredients = new ArrayList<>();

        try (Scanner scanner = new Scanner(Paths.get(file))) {
            while (scanner.hasNextLine()) {
                String row = scanner.nextLine();
                if (row.isEmpty()) {
                    recipes.add(new Recipe(recipeName, cookingTime, ingredients));
                    recipeName = "";
                    cookingTime = 0;
                    ingredients = new ArrayList<>();
                } else if (recipeName.isEmpty()) {
                    recipeName = row;
                } else if (cookingTime == 0) {
                    cookingTime = Integer.parseInt(row);
                } else {
                    ingredients.add(row);
                }
            }

            if (!recipeName.isEmpty()) {
                recipes.add(new Recipe(recipeName, cookingTime, ingredients));
            }

            return true;

        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage() + " is not a valid file.");
            return false;
        }
    }

    public void listRecipes() {
        for (Recipe recipe: recipes) {
            System.out.println(recipe);
        }
    }

    public void findByName (String searchedName) {
        System.out.println("Recipes:");
        for (Recipe recipe: recipes) {
            if (recipe.getName().contains(searchedName)) {
                System.out.println(recipe);
            }
        }
    }

    public void findByCookingTime (int maxCookingTime) {
        System.out.println("Recipes:");
        for (Recipe recipe: recipes) {
            if (recipe.getCookingTime() <= maxCookingTime) {
                System.out.println(recipe);
            }
        }
    }

    public void findByIngredient (String ingredient) {
        System.out.println("Recipes:");
        for (Recipe recipe: recipes) {
            if (recipe.getIngredients().contains(ingredient)) {
                System.out.println(recipe);
            }
        }
    }
}
