package culinary.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import culinary.dto.IngredientResponse;
import culinary.dto.IngredientDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import culinary.tables.Ingredient;
import culinary.repository.IngredientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;


import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olya on 11.02.2017.
 */

@Controller
@RestController
@RequestMapping(value = "/ingredient", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class IngredientController {

    @Autowired
    private IngredientRepository ingRepository;

    @Resource
    private ObjectMapper objectMapper;

    //@CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<String> getIngs()  {
        return new ResponseEntity(ingRepository.findAll(),HttpStatus.OK);
    }

    //@CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addIngs(@RequestBody Ingredient ingredient, WebRequest request)  {
        return new ResponseEntity(ingRepository.save(ingredient),HttpStatus.OK);
    }

    //@CrossOrigin(origins = "http://localhost:8090")
    @RequestMapping(value = "/{ingId}", method = RequestMethod.GET)
    public ResponseEntity<String> getIng(@PathVariable("ingId") String id)  {
        return new ResponseEntity(ingRepository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/{ingId}/del", method = RequestMethod.DELETE)
    public ResponseEntity<String> delIng(@PathVariable("ingId") String id)  {
        ingRepository.delete(id);
        return new ResponseEntity("{\""+id+"\":\"deleted\"}", HttpStatus.OK);
    }


    protected ResponseEntity<String> newJsonResponse(final Object object) {
        return new ResponseEntity(valueOf(object), HttpStatus.OK);
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






