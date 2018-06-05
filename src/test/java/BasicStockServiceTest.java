import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

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


}
