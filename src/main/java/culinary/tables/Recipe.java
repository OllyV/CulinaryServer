package culinary.tables;


import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

import com.fasterxml.jackson.core.JsonProcessingException;

import javax.annotation.Resource;

/**
 * Created by olya on 09.02.2017.
 */

@Document(collection = "Recipe")
public class Recipe implements Comparable<Recipe> {

    @Id
    private String id;
    @JsonProperty("name")
    private String recipeName;
    @JsonProperty("text")
    private String recipeText;



    @JsonProperty("family")
    private String recipeFamily;
    @JsonProperty("ingredients")
    private ArrayList<RecipeIngredient> recipeIngredients;



    @JsonProperty("foto")
    private String recipeFoto;


    public Recipe(String name, String text, String family,
                  ArrayList<RecipeIngredient> ingredients, String foto) {
        this.recipeName = name;
        this.recipeText = text;
        this.recipeFamily = family;
        this.recipeIngredients = ingredients;
        this.recipeFoto = foto;
    }

    public Recipe(String name, String text) {
        this.recipeName = name;
        this.recipeText = text;
    }

    public String toString(Recipe object) {
        ObjectMapper objectMapper = new ObjectMapper() ;
        String returnResult = null;
        try {
            returnResult = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
        }
        return returnResult;
    }

    @Override
    public int compareTo(Recipe recipe) {
        return this.recipeName.compareTo(recipe.getRecipeName());
    }


    public Recipe() {}

    public String getRecipeFamily() {
        return recipeFamily;
    }

    public void setRecipeFamily(String recipeFamily) {
        this.recipeFamily = recipeFamily;
    }

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


    public ArrayList<RecipeIngredient> getRecipeIngredients() {
        return recipeIngredients;
    }

    public void setRecipeIngredients(ArrayList<RecipeIngredient> recipeIngredients) {
        this.recipeIngredients = recipeIngredients;
    }

    public String getRecipeFoto() {
        return recipeFoto;
    }

    public void setRecipeFoto(String recipeFoto) {
        this.recipeFoto = recipeFoto;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}
