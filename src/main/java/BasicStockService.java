public class BasicStockService implements StockService{

    @Override
    public StockQuote getQuote(String symbol) {
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }
        return new StockQuote(symbol, 274.90);
    }
}
