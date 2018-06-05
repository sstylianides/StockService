public class StockQuote{

    private final String symbol;
    private final double value;

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
