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
