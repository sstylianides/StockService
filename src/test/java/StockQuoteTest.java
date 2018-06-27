import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.util.Calendar;

public class StockQuoteTest {

    /**
     * test GetSymbol
     * @result will return the correct stockQuote
     */
    @Test
    public void testGetSymbol(){
        StockQuote stockQuote = new StockQuote("SPY", BigDecimal.valueOf(200.1), Calendar.getInstance());

        Assert.assertEquals( "SPY", stockQuote.getSymbol());

    }

    /**
     * test GetValue
     * @result will return the correct value
     */
    @Test
    public void testGetValue(){
        StockQuote stockQuote = new StockQuote("SPY", BigDecimal.valueOf(200.1), Calendar.getInstance());

        Assert.assertEquals(BigDecimal.valueOf(200.1), stockQuote.getValue());
    }


    /**
     * negative test for negative value
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenValueNegative(){
        new StockQuote("SPY", BigDecimal.valueOf(-1.00), Calendar.getInstance());

    }



    /**
     * negative test for zero value
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenValueZero(){
        new StockQuote("SPY", BigDecimal.ZERO, Calendar.getInstance());

    }


    /**
     * negative test for null symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolNull(){
        new StockQuote(null, BigDecimal.ONE, Calendar.getInstance());

    }


    /**
     * negative test for empty symbol
     * @result will return exception
     */
    @Test (expected = java.lang.IllegalArgumentException.class)
    public void testThrowsWhenSymbolEmpty(){
        new StockQuote("", BigDecimal.ONE, Calendar.getInstance());

    }


}
