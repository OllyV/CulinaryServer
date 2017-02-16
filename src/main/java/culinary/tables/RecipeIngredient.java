package culinary.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by olya on 12.02.2017.
 */
public class RecipeIngredient {


    @JsonProperty("name")
    private String ingredientName;
    @JsonProperty("count")
    private String ingredientCount;

    public RecipeIngredient(String name, String count) {
        this.ingredientName = name;
        this.ingredientCount = count;
    }

    public RecipeIngredient() {
    }

    public String getIngredientCount() {
        return ingredientCount;
    }

    public void setIngredientCount(String ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }


}
