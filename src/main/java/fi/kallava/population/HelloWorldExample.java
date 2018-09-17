/*
package fi.kallava.population;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvParser;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
*/
/*import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;*//*

import fi.kallava.population.config.PopulationDataSource;
import org.neo4j.ogm.config.ClasspathConfigurationSource;
import org.neo4j.ogm.config.Configuration;
import org.neo4j.ogm.config.ConfigurationSource;
import org.neo4j.ogm.config.FileConfigurationSource;
import org.neo4j.ogm.session.Session;
import org.neo4j.ogm.session.SessionFactory;
import org.neo4j.ogm.transaction.Transaction;
import org.springframework.core.io.ClassPathResource;
import fi.kallava.population.dao.entity.Person;

import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import static org.neo4j.driver.v1.Values.parameters;

public class HelloWorldExample
{
    */
/*private final Driver driver;

    public HelloWorldExample( String uri, String user, String password )
    {
        driver = GraphDatabase.driver( uri, AuthTokens.basic( user, password ) );
    }

    @Override
    public void close() throws Exception
    {
        driver.close();
    }

    public void printGreeting( final String message )
    {
        try ( Session session = driver.session() )
        {
            String greeting = session.writeTransaction( new TransactionWork<String>()
            {
                @Override
                public String execute( Transaction tx )
                {
                    StatementResult result = tx.run( "CREATE (a:Greeting) " +
                                                     "SET a.message = $message " +
                                                     "RETURN a.message + ', from node ' + id(a)",
                            parameters( "message", message ) );
                    return result.single().get( 0 ).asString();
                }
            } );
            System.out.println( greeting );
        }
    }*//*

    
    public static void main( String... args ) throws Exception {

*/
/*
        HelloWorldExample greeter = new HelloWorldExample();

        List<Person> namesMen = greeter.loadObjectList( Person.class, "resources/etunimet_miehet.csv" );
        List<Person> namesWomen = greeter.loadObjectList( Person.class, "resources/etunimet_naiset.csv" );

        Session dbSession = new PopulationDataSource().getDatabaseSession();

        try (Transaction tx = dbSession.beginTransaction()) {
            for(int i = 0;namesMen.size()>i;i++){
                Person p = new Person(namesMen.get(i).getName(),namesMen.get(i).getCount());
                dbSession.save(p,0);
                System.out.println(namesMen.get(i).getName());
            }
            tx.commit();
        } catch (Exception e) {
            System.out.println("Virhe: "+e.getMessage());
        }
*//*


        */
/*try ( HelloWorldExample greeter = new HelloWorldExample( "bolt://localhost:7687", "neo4j", "passu" ) )
        {
            boolean threeNames = false;
            int namesCount = 1;
            for(String argument: args) {
                System.out.println(argument);
                if(argument.startsWith("-threeNames")) {
                    threeNames = true;
                }
                else if (argument.startsWith("-namesCount")) {
                    namesCount = Integer.parseInt(argument.split("=")[1]);
                }
            }

            greeter.printGreeting( "hello, world" );

            List<Person> namesMen = greeter.loadObjectList( Person.class, "resources/etunimet_miehet.csv" );
            List<Person> namesWomen = greeter.loadObjectList( Person.class, "resources/etunimet_naiset.csv" );

            System.out.println("Miehet");
            for(int i = 0;namesCount>i;i++){
                Random rand = new Random();
                int  nFirstName = rand.nextInt(namesMen.size()) + 1;
                int  nSecondName = rand.nextInt(namesMen.size()) + 1;
                int  nSecondName2 = rand.nextInt(namesMen.size()) + 1;
                String currName = "Satunnainen miehen nimi: "+namesMen.get(nFirstName).getName()+" "+namesMen.get(nSecondName).getName();
                if(threeNames){
                    currName = currName + " " + namesMen.get(nSecondName2).getName();
                }
                currName = currName + ", joita on "+namesMen.get(nFirstName).getCount();
                System.out.println(currName);
            }

            System.out.println("Naiset");
            for(int i = 0;namesCount>i;i++){
                Random rand = new Random();
                int  nFirstName = rand.nextInt(namesWomen.size()) + 1;
                int  nSecondName = rand.nextInt(namesWomen.size()) + 1;
                int  nSecondName2 = rand.nextInt(namesWomen.size()) + 1;
                String currName = "Satunnainen naisen nimi: "+namesWomen.get(nFirstName).getName()+" "+namesWomen.get(nSecondName).getName();
                if(threeNames){
                    currName = currName + " " + namesWomen.get(nSecondName2).getName();
                }
                currName = currName + ", joita on "+namesWomen.get(nFirstName).getCount();
                System.out.println(currName);
            }
        }*//*

    }
}*/
