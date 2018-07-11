import java.util.List;

public interface PersonService {

    /**
     * Get a list of all people
     *
     * @return a list of Person instances
     * @throws StockServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */

    List<Person> getPeople() throws StockServiceException;



    /**
     * Get a list of all a person's stocks.
     *
     * @return a list of stock instances
     * @throws StockServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */

    List<String> getStocks(Person person) throws StockServiceException;



    /**
     * Add a new person or update an existing Person's data
     *
     * @param person a person object to either update or create
     * @throws StockServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */

    void addOrUpdatePerson(Person person) throws StockServiceException;




    /**
     * Assign a hobby to a person.
     *
     * @param symbol  The stock symbol to assign
     * @param person The person to assign the stock symbol to.
     * @throws StockServiceException if a service can not read or write the requested data
     *                                    or otherwise perform the requested operation.
     */

    void addStockToPerson(String symbol, Person person) throws StockServiceException;


}

