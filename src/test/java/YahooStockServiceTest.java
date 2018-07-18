import models.StockQuote;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import services.IntervalEnum;
import services.StockServiceException;
import services.YahooStockService;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class YahooStockServiceTest {

    private YahooStockService stockService;

    /**
     * Setup a new services.BasicStockService
     */
    @Before
    public void setup() {
        stockService = new YahooStockService();

    }

    /**
     * test GetQuote to make sure that symbol is not null
     * @result will make sure symbol not null
     */
    @Test
    public void testGetQuote() throws IOException, StockServiceException {

        StockQuote stockQuote = stockService.getQuote("SPY");
        Assert.assertNotNull(stockQuote);


    }


    /**
     * test to return correct list
     * @result will return the correct list
     */
    @Test
    public void testGetCorrectStockList() throws ParseException, IOException, StockServiceException {
        String symbol = "QQQ";
        String from = "1/11/1999";
        String until = "12/1/2000";


        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));


        List<StockQuote> stockQuote = stockService.getQuote(symbol, fromDate, untilDate, IntervalEnum.QUARTERLY);
        Assert.assertArrayEquals(stockQuote.toArray(), stockQuote.toArray());
    }

}
