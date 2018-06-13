public class StockServiceFactory {

    //Justin: Does this stay the same?


    /**
     * @return returns a new BasicStockService
     *
     *
     */
    public static StockService getService(){
        return new BasicStockService();
    }
}
