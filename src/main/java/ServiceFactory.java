public class ServiceFactory {


    /**
     * @return returns a new BasicStockService
     *
     *
     */
    public static StockService getStockService(){
        return new DatabaseStockService();
    }

    public static PersonService getPersonService(){
        return new DatabasePersonService();
    }
}
