package services;

import models.StockQuote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;
import yahoofinance.histquotes.HistoricalQuote;
import yahoofinance.histquotes.Interval;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the services.StockService interface that gets
 * stock data from the Yahoo API.
 */

public class YahooStockService implements StockService{

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  new StockQuote instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */

    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException, IOException {



        Stock stock = YahooFinance.get(symbol);
        BigDecimal price = stock.getQuote(true).getPrice();
        stock.getHistory(Calendar.getInstance());

        return new StockQuote(stock.toString(), price, Calendar.getInstance());
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @param interval allows the user to retrieve daily, weekly, or monthly data
     * @return a list of models.StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * @throws IOException if if using the API generates an exception
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */

    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) throws StockServiceException, IOException {
        Interval i = Interval.DAILY;
        if(interval == IntervalEnum.WEEKLY){
            i = Interval.WEEKLY;
        }else if(interval == IntervalEnum.MONTHLY){
            i = Interval.MONTHLY;
        }
        Stock stock = YahooFinance.get(symbol, from, until, i);

        List<HistoricalQuote> stockHistQuotes = stock.getHistory();

        List<StockQuote> quotes = new ArrayList<>();

        for(HistoricalQuote hQuote: stockHistQuotes){
            quotes.add(new StockQuote(symbol, hQuote.getClose(), hQuote.getDate()));
        }
        return quotes;

    }
}
