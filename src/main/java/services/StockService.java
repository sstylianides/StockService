package services;

import models.StockQuote;

import javax.validation.constraints.NotNull;

import java.io.IOException;
import java.util.Calendar;
import java.util.List;

public interface StockService{
    /**
     * Return the current price for a share of stock  for the
     * given symbol
     * @param symbol the stock symbol of the company you want a
     * quote for e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     */
    StockQuote getQuote(@NotNull String symbol) throws StockServiceException, IOException;



    /**
     *
     * Get a historical list of stock quotes for the provide symbol
     * This method will return one models.StockQuote per interval specified. *
     * @param symbol t​he stock symbol to search for
     * @param from t​he date of the first stock quote
     * @param until​ t​he date of the last stockquote
     * @param interval ­​the number of StockQuotes to get. E.g. if Interval.DAILY was specified
     * one models.StockQuote per day will be returned.
     * @return a​list of models.StockQuote instances. One for each day in the range specified.
     */


    List<StockQuote> getQuote(@NotNull String symbol, @NotNull Calendar from, @NotNull Calendar until, IntervalEnum interval) throws StockServiceException, IOException;


}
