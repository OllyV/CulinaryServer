package culinary.repository;

import culinary.tables.Family;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by olya on 10.02.2017.
 */
public interface FamilyRepository extends MongoRepository<Family,String> {
}
