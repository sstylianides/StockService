public class StockServiceFactory {

    public static StockService getService(){
        return new BasicStockService();
    }
}
