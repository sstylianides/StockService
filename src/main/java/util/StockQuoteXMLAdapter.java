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

    /**
     * adapter class that helps convert XML to StockQuote objects
     */

    private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * method that gets XML and converts to StockQuote object
     *
     * @param stock input needed from XML
     * @return a new StockQuote
     * @throws ParseException if using the service generates an exception
     */


    public static StockQuote stockXMLToStockQuote(Stock stock) throws ParseException {
        String symbol = stock.getSymbol();
        String price = stock.getPrice();
        String time = stock.getTime();

        Calendar cal = Calendar.getInstance();
        cal.setTime(sdf.parse(time));

        return new StockQuote(symbol,new BigDecimal(price),cal);
    }


    /**
     * method that gets XML and converts to a list of StockQuote object
     *
     * @param stocks input needed from XML
     * @return a new List of StockQuotes
     * @throws ParseException if using the service generates an exception
     */
    public static List<StockQuote> stocksXMLtoStockQuotes(Stocks stocks) throws ParseException{
        List<StockQuote> stockQuotes = new ArrayList<>();

        for(Stock stock: stocks.getStock()){
            stockQuotes.add(stockXMLToStockQuote(stock));
        }

        return stockQuotes;

    }
}
