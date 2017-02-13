package culinary.dto;

/**
 * Created by olya on 11.02.2017.
 */
public class IngredientResponse {

    private String ingredientName;

    public IngredientResponse(String name) {
        this.ingredientName = name;
    }

    public String getIngredientName() {
        return ingredientName;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }



}
