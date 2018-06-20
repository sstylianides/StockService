import org.apache.http.annotation.Immutable;

import javax.validation.constraints.NotNull;
import java.util.Calendar;

@Immutable
public class StockQuote {

    private final String symbol;
    private final double value;
    private final Calendar date;



    public Calendar getDate() {
        return date;
    }


    /**
     * StockQuote constructor with getters for symbol and value
     * first checks if symbol symbol is null or is empty
     * throws an exception if symbol is empty or null
     * throws an exception if value is equal or less than zero
     * @param symbol takes in a stock ticker symbol
     * @param value takes in a price for the symbol
     * @param date
     * @return getters return value and symbol of StockQuote Object
     * @throws IllegalArgumentException if symbol is null or empty, or date is null
     */
    public StockQuote(@NotNull String symbol, double value, @NotNull Calendar date) {

        if(value <= 0){
            throw new IllegalArgumentException("Stock value must be positive");
        }
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }
        if(date == null){
            throw new IllegalArgumentException("Date must be non-null");
        }
        this.symbol = symbol;
        this.value = value;
        this.date = date;
    }

    public String getSymbol() {
        return symbol;
    }


    public double getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "symbol='" + symbol + '\'' +
                ", value=" + value +
                ", date=" + date +
                '}';
    }

}
