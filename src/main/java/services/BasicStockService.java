package services;

import models.StockQuote;

import javax.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


public class BasicStockService implements StockService{

    /**
     * Returns a new models.StockQuote object when getQuote is called
     * first checks if symbol symbol is null or is empty
     * throws an exception if symbol is empty or null
     * @param symbol takes in a stock ticker symbol
     * @return returns a models.StockQuote object
     * @throws IllegalArgumentException if symbol is null or empty
     */

    @Override
    public StockQuote getQuote(@NotNull String symbol) {
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }

        return new StockQuote(symbol, BigDecimal.valueOf(274.90), Calendar.getInstance());
    }


    /**
     * Returns a new models.StockQuote object when getQuote is called
     * first checks if symbol symbol is null or is empty
     * throws an exception if symbol is empty or null
     * @param symbol takes in a stock ticker symbol
     * @param from takes in a Calendar object
     * @param until takes in a Calendar object
     * @param interval is the time period that should be returned
     * @return returns a models.StockQuote object
     * @throws IllegalArgumentException if symbol is null or empty, from or until is null, until is later than today, or
     * from is after until
     */

    @Override
    public List<StockQuote> getQuote(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until, IntervalEnum interval) {
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }
        if(from == null || until == null){
            throw new IllegalArgumentException("From and until must be non-null");
        }
        if(until.after(Calendar.getInstance())){
            throw new IllegalArgumentException("Until must be no later than today");
        }
        if(from.after(until)){
            throw new IllegalArgumentException("From date cannot be after until");
        }
        return Arrays.asList(new StockQuote(symbol, BigDecimal.valueOf(275.45), from), new StockQuote(symbol, BigDecimal.valueOf(300.10), until));

    }
}
