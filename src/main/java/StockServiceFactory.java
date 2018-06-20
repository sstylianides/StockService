public class StockServiceFactory {


    /**
     * @return returns a new BasicStockService
     *
     *
     */
    public static StockService getService(){
        return new BasicStockService();
    }
}
