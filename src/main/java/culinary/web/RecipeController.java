package culinary.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import culinary.repository.RecipeRepository;
import culinary.tables.Recipe;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olya on 14.02.2017.
 */
@Controller
@RestController
@RequestMapping(value = "/recipe", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class RecipeController {

    @Autowired
    private RecipeRepository recRepository;

    @Resource
    private ObjectMapper objectMapper;

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addRec(@RequestBody String rec, WebRequest request) {
        try {
            Recipe recipe = objectMapper.readValue(rec, Recipe.class);
            return new ResponseEntity(recRepository.save(recipe), HttpStatus.OK);
        } catch (IOException e) {
            return new ResponseEntity("Not correct", HttpStatus.NO_CONTENT);
        }
    }

    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<String> getRec() {
        List<String> str = recRepository.findAll().stream()
                .map((recipe) -> valueOf(recipe))
                .collect(Collectors.toList());
        return new ResponseEntity("["+String.join(",", str)+"]", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{ingId}", method = RequestMethod.GET)
    public ResponseEntity<String> getIng(@PathVariable("ingId") String id)  {
        return new ResponseEntity(valueOf(recRepository.findOne(id)),HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{ingId}/del", method = RequestMethod.DELETE)
    public ResponseEntity<String> delIng(@PathVariable("ingId") String id)  {
        recRepository.delete(id);
        return new ResponseEntity("{\""+id+"\":\"deleted\"}", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/all/SuperPuperDeleting", method = RequestMethod.DELETE)
    public ResponseEntity<String> delAll()  {
        recRepository.deleteAll();
        return new ResponseEntity("{\"deleted\"}", HttpStatus.OK);
    }

    private String valueOf(final Object object) {
        String returnResult = null;
        try {
            returnResult = objectMapper.writeValueAsString(object);
        } catch (JsonProcessingException ex) {
        }
        return returnResult;
    }


}
