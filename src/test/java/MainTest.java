import org.junit.Test;
import services.StockServiceException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainTest {

    /**
     * test main
     * @result will return the correct Main
     */
    @Test
    public void testMain() throws ParseException, StockServiceException, IOException {
        String symbol = "VNET";
        String from = "02/10/2015";
        String until = "02/10/2015";

        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");


        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));

        StockQuoteApp.main(new String[] {symbol, from, until});
    }


    /**
     * negative test for empty Main
     * @result will return exception
     */
    @Test(expected = NullPointerException.class)
    public void testMainNegative() throws ParseException, StockServiceException, IOException {
        StockQuoteApp.main(null);
    }
}
