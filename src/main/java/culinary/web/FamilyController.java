package culinary.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import culinary.repository.FamilyRepository;
import culinary.tables.Family;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by olya on 12.02.2017.
 */


@Controller
@RestController
@RequestMapping(value = "/family", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
public class FamilyController {

    @Autowired
    private FamilyRepository famRepository;

    @Resource
    private ObjectMapper objectMapper;

    @CrossOrigin
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<String> getFam()  {
        List<String> str = famRepository.findAll().stream().sorted()
                .map((family) -> valueOf(family))
                .collect(Collectors.toList());
        return new ResponseEntity("["+String.join(",", str)+"]", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addFam(@RequestBody Family family, WebRequest request)  {
        return new ResponseEntity(famRepository.save(family),HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{famId}", method = RequestMethod.GET)
    public ResponseEntity<String> getIng(@PathVariable("famId") String id)  {
        return new ResponseEntity(famRepository.findOne(id),HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/{famId}/del", method = RequestMethod.DELETE)
    public ResponseEntity<String> delIng(@PathVariable("famId") String id)  {
        famRepository.delete(id);
        return new ResponseEntity("{\""+id+"\":\"deleted\"}", HttpStatus.OK);
    }

    @CrossOrigin
    @RequestMapping(value = "/all/SuperDuperDeleting", method = RequestMethod.DELETE)
    public ResponseEntity<String> delAll()  {
        famRepository.deleteAll();
        return new ResponseEntity("{\"all\":\"deleted\"}", HttpStatus.OK);
    }

    protected ResponseEntity<String> newJsonResponse(final Object object) {
        return new ResponseEntity<>(valueOf(object), HttpStatus.OK);
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
