public class StockQuote{

    private final String symbol;
    private final double value;


    /**
     * StockQuote constructor with getters for symbol and value
     * first checks if symbol symbol is null or is empty
     * throws an exception if symbol is empty or null
     * throws an exception if value is equal or less than zero
     * @param symbol takes in a stock ticker symbol
     * @param value takes in a price for the symbol
     * @return getters return value and symbol of StockQuote Object
     */
    public StockQuote(String symbol, double value) {
        if(value <= 0){
            throw new IllegalArgumentException("Stock value must be positive");
        }
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }
        this.symbol = symbol;
        this.value = value;
    }

    public String getSymbol() {
        return symbol;
    }


    public double getValue() {
        return value;
    }

}
