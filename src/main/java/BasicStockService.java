public class BasicStockService implements StockService{

    /**
     * Returns a new StockQuote object when getQuote is called
     * first checks if symbol symbol is null or is empty
     * throws an exception if symbol is empty or null
     * @param symbol takes in a stock ticker symbol
     * @return returns a StockQuote object
     */

    @Override
    public StockQuote getQuote(String symbol) {
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }
        return new StockQuote(symbol, 274.90);
    }
}
