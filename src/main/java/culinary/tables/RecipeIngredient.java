package culinary.tables;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by olya on 12.02.2017.
 */
public class RecipeIngredient {

    @JsonProperty("name")
    private String ingredientName;
    @JsonProperty("count")
    private Float ingredientCount;
    @JsonProperty("unit")
    private String ingredientUnit;

    public RecipeIngredient(String name, Float count, String unit) {
        this.ingredientName = name;
        this.ingredientCount = count;
        this.ingredientUnit = unit;
    }

    public RecipeIngredient() {
    }

    public Float getIngredientCount() {
        return ingredientCount;
    }

    public void setIngredientCount(Float ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    public String getIngredientUnit() {
        return ingredientUnit;
    }

    public void setIngredientUnit(String ingredientUnit) {
        this.ingredientUnit = ingredientUnit;
    }


}
