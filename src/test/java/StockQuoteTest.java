import org.junit.Assert;
import org.junit.Test;

import java.util.Calendar;

public class StockQuoteTest {

    /**
     * test GetSymbol
     * @result will return the correct stockQuote
     */
    @Test
    public void testGetSymbol(){
        StockQuote stockQuote = new StockQuote("SPY", 200.1, Calendar.getInstance());

        Assert.assertEquals( "SPY", stockQuote.getSymbol());

    }

    /**
     * test GetValue
     * @result will return the correct value
     */
    @Test
    public void testGetValue(){
        StockQuote stockQuote = new StockQuote("SPY", 200.1, Calendar.getInstance());

        Assert.assertEquals(200.1, stockQuote.getValue(), 0.001);
    }


    /**
     * negative test for negative value
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenValueNegative(){
        new StockQuote("SPY", -1.00, Calendar.getInstance());

    }



    /**
     * negative test for zero value
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenValueZero(){
        new StockQuote("SPY", 0.00, Calendar.getInstance());

    }


    /**
     * negative test for null symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolNull(){
        new StockQuote(null, 1.00, Calendar.getInstance());

    }


    /**
     * negative test for empty symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolEmpty(){
        new StockQuote("", 1.00, Calendar.getInstance());

    }


}
