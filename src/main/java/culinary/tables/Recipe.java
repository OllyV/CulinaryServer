package culinary.tables;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;


/**
 * Created by olya on 09.02.2017.
 */

@Document(collection = "recipes")
public class Recipe {

    @Id
    private String id;
    private String recipeName;
    private String recipeText;
    private Family recipeFamily;
    private ArrayList<RecipeIngredient> recipeIngredients;
    private ArrayList<String> recipeFotos;


    public Recipe(String name, String text, Family family,
                      ArrayList<RecipeIngredient> ingredients, ArrayList<String> fotos) {
        this.recipeName = name;
        this.recipeText = text;
        this.recipeFamily = family;
        this.recipeIngredients = ingredients;
        this.recipeFotos = fotos;
    }

    public Recipe() {}

    public String getRecipeName() {
        return recipeName;
    }

    public void setRecipeName(String recipeName) {
        this.recipeName = recipeName;
    }

    public String getRecipeText() {
        return recipeText;
    }

    public void setRecipeText(String recipeText) {
        this.recipeText = recipeText;
    }

    public Family getRecipeFamily() {
        return recipeFamily;
    }

    public void setRecipeFamily(Family recipeFamily) {
        this.recipeFamily = recipeFamily;
    }

    public ArrayList<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeFamily(ArrayList<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public ArrayList<String> getRecipeFotos() {
        return recipeFotos;
    }

    public void setRecipeFotos(ArrayList<String> recipeFotos) {
        this.recipeFotos = recipeFotos;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
