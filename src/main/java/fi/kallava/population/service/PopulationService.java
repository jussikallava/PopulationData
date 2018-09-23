package fi.kallava.population.service;

import fi.kallava.population.Neo4jSessionFactory;
import fi.kallava.population.domain.*;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class PopulationService {

    private static final Logger log = LoggerFactory.getLogger(PopulationService.class);
    private static CsvLoader csvLoader = new CsvLoader();

    @Autowired
    private MunicipalityServiceImpl municipalityService;

    @Autowired
    private FirstNameServiceImpl firstnameService;

    @Autowired
    private LastNameServiceImpl lastnameService;

    @Autowired
    private CountyServiceImpl countyService;

    private DateFormat df = new SimpleDateFormat("ddMMyyyy");

    public PopulationService() {
    }

    public void createPopulationMen() {

        List<FirstNameEntity> namesMen = csvLoader.loadObjectList(FirstNameEntity.class,
                "resources/etunimet_miehet.csv");

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for (int i = 0; namesMen.size() > i; i++) {
                FirstNameEntity p = new FirstNameEntity(namesMen.get(i).getName(), "man", namesMen.get(i).getCount());
                dbSession.save(p, 0);
                log.info(namesMen.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virheluokka: " + e.getClass());
            log.error("Virhe: " + e.getMessage());
        }
    }

    public void createPopulationMunicipalities() {

        List<Municipality> municipalities = csvLoader.loadObjectList(Municipality.class, "resources/kunnat.csv");

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for (int i = 0; municipalities.size() > i; i++) {
                MunicipalityEntity p = new MunicipalityEntity(municipalities.get(i).getName(),
                        countyService.getEntityByCountyNo(municipalities.get(i).getCountyNo()),
                        municipalities.get(i).getMunicipalityNo());
                dbSession.save(p, 1);
                log.info(municipalities.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virheluokka: " + e.getClass());
            log.error("Virhe: " + e.getMessage());
        }
    }

    public void createPopulationCounties() {

        List<County> counties = csvLoader.loadObjectList(County.class, "resources/maakunnat.csv");

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for (int i = 0; counties.size() > i; i++) {
                CountyEntity p = new CountyEntity(counties.get(i).getName(), counties.get(i).getCountyNo());
                dbSession.save(p, 0);
                log.info(counties.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virheluokka: " + e.getClass());
            log.error("Virhe: " + e.getMessage());
        }

    }

    public void createPopulationWomen() {

        List<FirstNameEntity> namesWomen = csvLoader.loadObjectList(FirstNameEntity.class,
                "resources/etunimet_naiset.csv");

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for (int i = 0; namesWomen.size() > i; i++) {
                FirstNameEntity p = new FirstNameEntity(namesWomen.get(i).getName(), "woman",
                        namesWomen.get(i).getCount());
                dbSession.save(p, 0);
                log.info(namesWomen.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virheluokka: " + e.getClass());
            log.error("Virhe: " + e.getMessage());
        }
    }

    public void createPopulationLastnames() {

        List<LastNameEntity> lastnames = csvLoader.loadObjectList(LastNameEntity.class, "resources/sukunimet.csv");

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for (int i = 0; lastnames.size() > i; i++) {
                LastNameEntity p = new LastNameEntity(lastnames.get(i).getName(), lastnames.get(i).getCount());
                dbSession.save(p, 0);
                log.info(lastnames.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virheluokka: " + e.getClass());
            log.error("Virhe: " + e.getMessage());
        }
    }

    public void createPeople(Long items) {

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        System.out.println("randomia: ");
        try (Transaction tx = dbSession.beginTransaction()) {
            for (int i = 0; items.longValue() > i; i++) {
                System.out.println("randomia 22: ");
                System.out.println("randomia: "+firstnameService.getRandomEntity().getName());
                Random rnd;
                Date dt;
                long ms;
                rnd = new Random();
                ms = -946771200000L + (Math.abs(rnd.nextLong()) % (70L * 365 * 24 * 60 * 60 * 1000));
                dt = new Date(ms);
                System.out.println("randomia: "+firstnameService.getRandomEntity().getName());
                PersonEntity p = new PersonEntity(firstnameService.getRandomEntity(),lastnameService.getRandomEntity(),municipalityService.getRandomEntity(),df.format(dt)+"-"+String.valueOf(rnd.nextInt())+String.valueOf(rnd.nextInt())+String.valueOf(rnd.nextInt()),dt);
                dbSession.save(p, 1);
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virheluokka: " + e.getClass());
            log.error("Virhe: " + e.getMessage());
        }
    }

}
