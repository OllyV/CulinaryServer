package culinary.dto;

/**
 * Created by olya on 11.02.2017.
 */
public class IngredientDto {

    private String ingredientName;

    public IngredientDto(String name) {
        this.ingredientName = name;
    }

    public IngredientDto() {}

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

}
