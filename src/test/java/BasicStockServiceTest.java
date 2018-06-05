import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BasicStockServiceTest {

    private BasicStockService stockService;


    @Before
    public void setup() {

        stockService = new BasicStockService();

    }

    @Test
    public void testGetQuote(){

        StockQuote stockQuote = stockService.getQuote("SPY");
        Assert.assertNotNull(stockQuote);


    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolNull(){
        stockService.getQuote(null);
    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolEmpty(){
        stockService.getQuote("");
    }

    @Test
    public void testGetQuoteReturnsCorrectSymbol(){
        StockQuote stockQuote = stockService.getQuote("QQQ");
        Assert.assertEquals("QQQ", stockQuote.getSymbol());


    }


}
