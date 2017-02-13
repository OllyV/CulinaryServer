package culinary.web;

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

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<String> getFam()  {
        return new ResponseEntity(famRepository.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<String> addFam(@RequestBody Family family, WebRequest request)  {
        return new ResponseEntity(famRepository.save(family),HttpStatus.OK);
    }

    @RequestMapping(value = "/{famId}", method = RequestMethod.GET)
    public ResponseEntity<String> getIng(@PathVariable("famId") String id)  {
        return new ResponseEntity(famRepository.findOne(id),HttpStatus.OK);
    }

    @RequestMapping(value = "/{famId}/del", method = RequestMethod.DELETE)
    public ResponseEntity<String> delIng(@PathVariable("famId") String id)  {
        famRepository.delete(id);
        return new ResponseEntity("{\""+id+"\":\"deleted\"}", HttpStatus.OK);
    }




}
