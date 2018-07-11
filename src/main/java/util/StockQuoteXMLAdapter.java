package util;

import models.StockQuote;
import xml.Stock;
import xml.Stocks;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


public class StockQuoteXMLAdapter {

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");


    public static StockQuote stockXMLToStockQuote(Stock stock) throws ParseException {
        String symbol = stock.getSymbol();
        String price = stock.getPrice();
        String time = stock.getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(time));

        return new StockQuote(symbol,new BigDecimal(price),cal);
    }

    public static List<StockQuote> stocksXMLtoStockQuotes(Stocks stocks) throws ParseException{
        List<StockQuote> stockQuotes = new ArrayList<>();

        for(Stock stock: stocks.getStock()){
            stockQuotes.add(stockXMLToStockQuote(stock));
        }

        return stockQuotes;

    }
}
