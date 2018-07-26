import org.junit.Test;


import java.io.IOException;
import java.text.ParseException;

public class MainTest {




    /**
     * negative test for empty Main
     * @result will return exception
     */
    @Test(expected = NullPointerException.class)
    public void testMainNegative() throws ParseException, StockServiceException, IOException {
        StockQuoteApp.main(null);
    }
}

