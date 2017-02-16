package culinary.tables;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by olya on 09.02.2017.
 */


@Document(collection = "Ingredient")
public class Ingredient implements Comparable<Ingredient> {
    @Id
    private String id;
    @JsonProperty("name")
    private String ingredientName;

    public Ingredient(String name) {
        this.ingredientName = name;
    }

    public Ingredient() {
    }


    public String getIngredientName() {
        return ingredientName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setIngredientName(String ingredientName) {
        this.ingredientName = ingredientName;
    }

    @Override
    public int compareTo(Ingredient ingredient) {
        return this.ingredientName.compareTo(ingredient.getIngredientName());
    }

}
