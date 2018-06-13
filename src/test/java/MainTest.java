import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainTest {

    //TODO: write positive and negative Main Test

    /**
     * test main
     * @result will return the correct Main
     */
    @Test
    public void testMain() throws ParseException {
        String symbol = "QQQ";
        String from = "1/11/1998";
        String until = "12/1/2001";

        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");


        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));

        Main.main(new String[] {symbol, from, until});
    }


    /**
     * negative test for empty Main
     * @result will return exception
     */
    @Test(expected = NullPointerException.class)
    public void testMainNegative() throws ParseException {
        Main.main(null);
    }
}
