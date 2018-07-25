package services;

public class ServiceFactory {


    /**
     * @return returns a new services.BasicStockService
     *
     *
     */
    public static StockService getStockService(){
        return new YahooStockService();
    }

    public static PersonService getPersonService(){
        return new DatabasePersonService();
    }

}
