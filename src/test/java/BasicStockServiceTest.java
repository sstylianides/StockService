import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class BasicStockServiceTest {

    private BasicStockService stockService;


    /**
     * Setup a new BasicStockService
     */
    @Before
    public void setup() {
        stockService = new BasicStockService();

    }

    /**
     * test GetQuote to make sure that symbol is not null
     * @result will make sure symbol not null
     */
    @Test
    public void testGetQuote(){

        StockQuote stockQuote = stockService.getQuote("SPY");
        Assert.assertNotNull(stockQuote);


    }


    /**
     * negative test for null symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolNull(){
        stockService.getQuote(null);
    }


    /**
     * negative test for empty symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolEmpty(){
        stockService.getQuote("");
    }


    /**
     * test to return correct symbol
     * @result will return the correct stockQuote
     */
    @Test
    public void testGetQuoteReturnsCorrectSymbol(){
        StockQuote stockQuote = stockService.getQuote("QQQ");
        Assert.assertEquals("QQQ", stockQuote.getSymbol());


    }

    /**
     * test to return correct list
     * @result will return the correct list
     */
    @Test
    public void testGetCorrectStockList() throws ParseException {
        String symbol = "QQQ";
        String from = "1/11/1999";
        String until = "12/1/2000";


        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));


        List<StockQuote> stockQuote = stockService.getQuote(symbol, fromDate, untilDate);
        Assert.assertArrayEquals(stockQuote.toArray(), stockQuote.toArray());
    }



    /**
     * negative test for empty symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsIncorrectStockList() throws ParseException {
        String symbol = "QQQ";
        String from = "1/11/1998";
        String until = "12/1/2001";

        String symboltest = null;


        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");


        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));


        List<StockQuote> stockQuote = stockService.getQuote(symbol, fromDate, untilDate);
        List<StockQuote> stockQuoteTest = stockService.getQuote(symboltest, fromDate, untilDate);


        Assert.assertArrayEquals(stockQuote.toArray(), stockQuoteTest.toArray());
    }


}
