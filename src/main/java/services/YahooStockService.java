package services;

import models.StockQuote;
import yahoofinance.Stock;
import yahoofinance.YahooFinance;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class YahooStockService implements StockService{

    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException, IOException {
        Stock stock = YahooFinance.get(symbol);
        BigDecimal price = stock.getQuote(true).getPrice();
        stock.getHistory(Calendar.getInstance());

        return new StockQuote(stock.toString(), price, Calendar.getInstance());
    }

    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) throws StockServiceException, IOException {
        Stock stock = YahooFinance.get(symbol);
        BigDecimal price = stock.getQuote(true).getPrice();
        stock.getHistory(Calendar.getInstance());

        return Arrays.asList(new StockQuote(stock.toString(),price,from), new StockQuote(stock.toString(),price,until));

    }
}
