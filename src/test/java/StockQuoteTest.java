import org.junit.Assert;
import org.junit.Test;

public class StockQuoteTest {

    @Test
    public void testGetSymbol(){
        StockQuote stockQuote = new StockQuote("SPY", 200.1);

        Assert.assertEquals( "SPY", stockQuote.getSymbol());

    }

    @Test
    public void testGetValue(){
        StockQuote stockQuote = new StockQuote("SPY", 200.1);

        Assert.assertEquals(200.1, stockQuote.getValue(), 0.001);
    }


    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenValueNegative(){
        new StockQuote("SPY", -1.00);

    }


    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenValueZero(){
        new StockQuote("SPY", 0.00);

    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolNull(){
        new StockQuote(null, 1.00);

    }

    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolEmpty(){
        new StockQuote("", 1.00);

    }
}
