package culinary.tables;

/**
 * Created by olya on 12.02.2017.
 */
public class RecipeIngredient {

    private String ingredientName;

    private Integer ingredientCount;

    public RecipeIngredient(String name, Integer count) {
        this.ingredientName = name;
        this.ingredientCount = count;
    }

    public RecipeIngredient() {}

    public Integer getIngredientCount() {
        return ingredientCount;
    }

    public void setIngredientCount(Integer ingredientCount) {
        this.ingredientCount = ingredientCount;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

}
