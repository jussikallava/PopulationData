package fi.kallava.population;

import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.config.FileConfigurationSource;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;

/**
 *
 * Created by jussi kallava on 17.9.2018.
 */
public class Neo4jSessionFactory {

    private static ConfigurationSource props = new FileConfigurationSource("db.properties");
    private static Configuration configuration = new Configuration.Builder(props).build();
    private static SessionFactory sessionFactory = new SessionFactory(configuration, "fi.kallava.population.domain");
    private static Neo4jSessionFactory factory = new Neo4jSessionFactory();

    public Neo4jSessionFactory(){}

    public Session getDatabaseSession(){
        return sessionFactory.openSession();
    }

    public static Neo4jSessionFactory getInstance() {
        return factory;
    }
}
