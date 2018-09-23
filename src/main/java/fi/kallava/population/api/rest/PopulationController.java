package fi.kallava.population.api.rest;

import com.fasterxml.jackson.databind.ObjectMapper;
import fi.kallava.population.domain.Municipality;
import fi.kallava.population.domain.MunicipalityEntity;
import fi.kallava.population.domain.PersonEntity;
import fi.kallava.population.domain.Person;
import fi.kallava.population.service.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/*
 * Demonstrates how to set up RESTful API endpoints using Spring MVC
 */

@RestController
@RequestMapping(value = "/population/v1")
// @Api(tags = {"people"})
public class PopulationController extends AbstractRestHandler {

    @Autowired
    private PopulationService populationService;

    @Autowired
    private PersonServiceImpl personService;

    @Autowired
    private FirstNameServiceImpl firstNameService;

    @Autowired
    private LastNameServiceImpl lastNameService;

    @Autowired
    private MunicipalityServiceImpl municipalityService;

    @Autowired
    private CountyServiceImpl countyService;

    private ObjectMapper mapper = new ObjectMapper();

    /* Endpoints for people */
    @RequestMapping(value = "/create/men/firstname", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create men.")
    public void createPopulationMen(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationMen();
    }

    @RequestMapping(value = "/create/women/firstname", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create women.")
    public void createPopulationWomen(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationWomen();
    }

    @RequestMapping(value = "/create/lastname", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create lastnames.")
    public void createPopulationLastnames(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationLastnames();
    }

/*    @ResponseBody
    @RequestMapping(value = "/create/woman", headers = {
            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create woman.")
    public void createPopulationWoman(@RequestBody @Valid Person pRequest, HttpServletRequest request,
                                      HttpServletResponse response) {
        this.personService.createOrUpdate(
                new PersonEntity(firstNameService.find(Long.parseLong(pRequest.getFirstname())), lastNameService.find(Long.parseLong(pRequest.getLastname())), pRequest.getSsid()));
    }*/

    @RequestMapping(value = "/person/{id}", method = RequestMethod.GET, produces = { "application/json", "application/xml" })
    @ResponseStatus(HttpStatus.OK)
    @ApiOperation(value = "Get a single person.", notes = "You have to provide a valid person ID.")
    public @ResponseBody
    PersonEntity getPerson(
            @ApiParam(value = "The ID of the person.", required = true) @PathVariable("id") Long id,
            HttpServletRequest request, HttpServletResponse response) throws Exception {
        PersonEntity person = this.personService.find(id);
        // checkResourceFound(person);
        return person;
    }

    /****************************************/

    /* Endpoints for municipality */
    @ResponseBody
    @RequestMapping(value = "/create/municipality", headers = {
            "content-type=application/json" }, consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create municipality.")
    public void createMunicipality(@RequestBody Municipality municipality, HttpServletRequest request, HttpServletResponse response) {
                this.municipalityService.createOrUpdate(new MunicipalityEntity(municipality.getName(),countyService.find(new Long(municipality.getCountyNo())),municipality.getMunicipalityNo()));
    }

    @RequestMapping(value = "/create/municipalities", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create municipalities.")
    public void createPopulationMunicipalities(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationMunicipalities();
    }

    @RequestMapping(value = "/create/counties", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create counties.")
    public void createPopulationCounties(HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPopulationCounties();
    }

    @ResponseBody
    @RequestMapping(value = "/create/people", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ApiOperation(value = "Create people.")
    public void createPeople( HttpServletRequest request, HttpServletResponse response) {
        this.populationService.createPeople(Long.parseLong("2"));
    }
}
