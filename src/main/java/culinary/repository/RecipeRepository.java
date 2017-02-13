package culinary.repository;

import culinary.tables.Recipe;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by olya on 10.02.2017.
 */
public interface RecipeRepository extends MongoRepository<Recipe,String>{
}
