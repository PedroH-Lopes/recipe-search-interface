package br.com.pedrohlopes;

import java.util.Scanner;

public class UserInterface {
    public void start() {
        Scanner scanner = new Scanner(System.in);
        RecipeFile recipeFile = new RecipeFile();
        boolean sucess = false;

        while (!sucess) {
            System.out.print("File to read: ");
            String file = scanner.nextLine();

            sucess = recipeFile.addRecipes(file);
        }

        while (true) {
            System.out.println("Commands");
            System.out.println("list - list the recipes");
            System.out.println("find name - searches recipes by name");
            System.out.println("find cooking time - searches recipes by cooking time");
            System.out.println("find ingredient - searches recipes by ingredient");
            System.out.println("stop - stops the program");
            System.out.println();
            System.out.println("Enter command: ");
            String command = scanner.nextLine();

            if (command.equals("stop")) {
                break;
            }

            if (command.equals("list")) {
                recipeFile.listRecipes();
                System.out.println();
            }

            if (command.equals("find name")) {
                System.out.print("Searched word: ");
                String searchedName = scanner.nextLine();
                recipeFile.findByName(searchedName);
                System.out.println();
            }

            if (command.equals("find cooking time")) {
                System.out.print("Max cooking time: ");
                int maxCookingTime = Integer.parseInt(scanner.nextLine());
                recipeFile.findByCookingTime(maxCookingTime);
                System.out.println();
            }

            if (command.equals("find ingredient")) {
                System.out.print("Ingredient: ");
                String ingredient = scanner.nextLine();
                recipeFile.findByIngredient(ingredient);
                System.out.println();
            }
        }
    }
}
