import org.junit.Test;

import java.text.ParseException;

public class MainTest {

    //TODO: write positive and negative Main Test

    @Test(expected = NullPointerException.class)
    public void testMainNegative() throws ParseException {
        Main.main(null);
    }
}
