import services.IntervalEnum;
import services.ServiceFactory;
import services.StockService;
import services.StockServiceException;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class StockQuoteApp {

    /**
     * main method that calls stockService to get new quotes
     * @throws ParseException if using the service generates an exception.
     * @throws IOException if if using the API generates an exception
     * @throws StockServiceException if using the service generates an exception.
     */

    public static void main(String[] args) throws ParseException, StockServiceException, IOException {

        String symbol = args[0];
        String from = args[1];
        String until = args[2];

        SimpleDateFormat parser = new SimpleDateFormat("MM/dd/yyyy");
        Calendar fromDate = Calendar.getInstance();
        fromDate.setTime(parser.parse(from));
        Calendar untilDate = Calendar.getInstance();
        untilDate.setTime(parser.parse(until));

        StockService stockService = ServiceFactory.getStockService();

        System.out.println(stockService.getQuote(symbol));
        System.out.println(stockService.getQuote(symbol, fromDate, untilDate, IntervalEnum.QUARTERLY));





    }
}
