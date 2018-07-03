import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import util.DatabaseInitializationException;
import util.DatabaseUtils;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;

public class DatabasePersonServiceTest {

    /**
     * Setup a new BasicStockService
     */
    @Before
    public void setup() throws DatabaseInitializationException {
        DatabaseUtils.initializeDatabase(DatabaseUtils.initializationFile);

    }

    /**
     * test getPeople
     * @result will return all the people in database
     */
    @Test
    public void testGetPeople() throws StockServiceException {
        PersonService personService = ServiceFactory.getPersonService();
        List<Person> people = personService.getPeople();

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("Stephan");
        person1.setLastName("Stylianides");
        person1.setBirthDate(Timestamp.valueOf("1989-06-28 00:00:00"));

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Gabriela");
        person2.setLastName("Guardado");
        person2.setBirthDate(Timestamp.valueOf("1989-10-22 00:00:00"));


        Assert.assertEquals(Arrays.asList(person1, person2), people);

    }

    @Test
    public void testGetStocks() throws StockServiceException{
        PersonService personService = ServiceFactory.getPersonService();

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("Stephan");
        person1.setLastName("Stylianides");
        person1.setBirthDate(Timestamp.valueOf("1989-06-28 00:00:00"));

        List<String> stocks1 = personService.getStocks(person1);

        Assert.assertEquals(Arrays.asList("QQQ", "SPY"), stocks1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Gabriela");
        person2.setLastName("Guardado");
        person2.setBirthDate(Timestamp.valueOf("1989-10-22 00:00:00"));

        List<String> stocks2 = personService.getStocks(person2);

        Assert.assertEquals(Arrays.asList("IWM", "TWTR"), stocks2);




    }




    @Test
    public void testaddOrUpdatePerson() throws StockServiceException {

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("Stephan");
        person1.setLastName("Stylianides");
        person1.setBirthDate(Timestamp.valueOf("1989-06-28 00:00:00"));

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Gabriela");
        person2.setLastName("Guardado");
        person2.setBirthDate(Timestamp.valueOf("1989-10-22 00:00:00"));

        Person person3 = new Person();
        person3.setId(3);
        person3.setFirstName("Steve");
        person3.setLastName("Shwang");
        person3.setBirthDate(Timestamp.valueOf("1979-11-12 00:00:00"));


        PersonService personService = ServiceFactory.getPersonService();
        //adding person to database
        personService.addOrUpdatePerson(person3);

        List<Person> people = personService.getPeople();

        Assert.assertEquals(Arrays.asList(person1, person2, person3), people);

    }

    @Test
    public void testAddStockToPerson() throws StockServiceException{
        PersonService personService = ServiceFactory.getPersonService();

        Person person1 = new Person();
        person1.setId(1);
        person1.setFirstName("Stephan");
        person1.setLastName("Stylianides");
        person1.setBirthDate(Timestamp.valueOf("1989-06-28 00:00:00"));

        personService.addStockToPerson("AAPL", person1);

        List<String> stocks1 = personService.getStocks(person1);

        Assert.assertEquals(Arrays.asList("QQQ", "SPY", "AAPL"), stocks1);

        Person person2 = new Person();
        person2.setId(2);
        person2.setFirstName("Gabriela");
        person2.setLastName("Guardado");
        person2.setBirthDate(Timestamp.valueOf("1989-10-22 00:00:00"));

        personService.addStockToPerson("AAPL", person2);


        List<String> stocks2 = personService.getStocks(person2);

        Assert.assertEquals(Arrays.asList("IWM", "TWTR", "AAPL"), stocks2);
    }

}
