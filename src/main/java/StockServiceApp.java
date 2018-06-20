import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StockServiceApp {

    public static void main(String[] args) throws ParseException {

        String symbol = args[0];
        String from = args[1];
        String until = args[2];

        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));

        StockService stockService = StockServiceFactory.getService();

        System.out.println(stockService.getQuote(symbol));
        System.out.println(stockService.getQuote(symbol, fromDate, untilDate, IntervalEnum.QUARTERLY));





    }
}
