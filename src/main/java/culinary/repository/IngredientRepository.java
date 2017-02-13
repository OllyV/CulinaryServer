package culinary.repository;


import culinary.tables.Ingredient;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by olya on 11.02.2017.
 */
public interface IngredientRepository extends MongoRepository<Ingredient,String> {

}
