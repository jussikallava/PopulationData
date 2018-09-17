package fi.kallava.population.service;

import fi.kallava.population.Neo4jSessionFactory;
import fi.kallava.population.domain.FirstName;
import fi.kallava.population.domain.Person;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.transaction.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.boot.actuate.metrics.GaugeService;
import org.springframework.stereotype.Service;

import java.util.List;

/*
 * Sample service to demonstrate what the API would use to get things done
 */
@Service
public class PopulationService {

    private static final Logger log = LoggerFactory.getLogger(PopulationService.class);
    private static CsvLoader csvLoader = new CsvLoader();

    public PopulationService() {
    }

    public void createPopulationMen() {

        List<FirstName> namesMen = csvLoader.loadObjectList( FirstName.class, "resources/etunimet_miehet.csv" );

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for(int i = 0;namesMen.size()>i;i++){
                FirstName p = new FirstName(namesMen.get(i).getName(),namesMen.get(i).getCount());
                dbSession.save(p,0);
                log.info(namesMen.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virhe: "+e.getMessage());
        }
    }

    public void createPopulationWomen() {

        List<FirstName> namesWomen = csvLoader.loadObjectList( FirstName.class, "resources/etunimet_naiset.csv" );

        Session dbSession = new Neo4jSessionFactory().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for(int i = 0;namesWomen.size()>i;i++){
                FirstName p = new FirstName(namesWomen.get(i).getName(),namesWomen.get(i).getCount());
                dbSession.save(p,0);
                log.info(namesWomen.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            log.error("Virhe: "+e.getMessage());
        }
    }

}
