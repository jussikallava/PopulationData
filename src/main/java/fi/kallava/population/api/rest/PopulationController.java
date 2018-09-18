package fi.kallava.population.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ObjectNode;
import fi.kallava.population.domain.Municipality;
import fi.kallava.population.domain.Person;
import fi.kallava.population.service.FirstNameServiceImpl;
import fi.kallava.population.service.MunicipalityServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import fi.kallava.population.service.PersonServiceImpl;
import fi.kallava.population.service.PopulationService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/population/v1")
//@Api(tags = {"people"})
public class PopulationController extends AbstractRestHandler {

    @Autowired
    private PopulationService populationService;

    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private FirstNameServiceImpl firstNameService;

    @Autowired
    private MunicipalityServiceImpl municipalityService;

    private ObjectMapper mapper = new ObjectMapper();

    /* Endpoints for people */
    @RequestMapping(value = "/create/men/firstname",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create men.")
    public void createPopulationMen(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationMen();
    }

    @RequestMapping(value = "/create/women/firstname",
            method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create women.")
    public void createPopulationWomen(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationWomen();
    }

    @RequestMapping(value = "/create/woman",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create woman.")
    public void createPopulationWoman(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            if (node.get("firstNameId") != null && node.get("ssid") != null) {
                this.personService.createOrUpdate(new Person(
                        firstNameService.find(Long.parseLong(node.get("firstNameId").textValue())), node.get("ssid").textValue(), 12
                ));
            }
        }catch(Exception e){

        }
    }

    @RequestMapping(value = "/{id}",
            method = RequestMethod.GET,
            produces = {"application/json", "application/xml"})
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single person.", notes = "You have to provide a valid person ID.")
    public
    @ResponseBody
    Person getPerson(@ApiParam(value = "The ID of the person.", required = true)
                             @PathVariable("id") Long id,
                     HttpServletRequest request, HttpServletResponse response) throws Exception {
        Person person = this.personService.find(id);
        //checkResourceFound(person);
        return person;
    }
    /****************************************/


    /* Endpoints for municipality */
    @RequestMapping(value = "/create/municipality",
            method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create municipality.")
    public void createMunicipality(@RequestBody String json, HttpServletRequest request, HttpServletResponse response) {
        try {
            ObjectNode node = mapper.readValue(json, ObjectNode.class);
            if (node.get("name") != null && node.get("municipalityNo") != null) {
                System.out.println(node.get("name").textValue());
                System.out.println(node.get("municipalityNo").textValue());
                this.municipalityService.createOrUpdate(new Municipality(node.get("name").textValue(),Integer.getInteger(node.get("municipalityNo").textValue())));
            }
        }catch(Exception e){

        }
    }


}
