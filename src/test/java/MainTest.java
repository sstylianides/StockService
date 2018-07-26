import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;


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
