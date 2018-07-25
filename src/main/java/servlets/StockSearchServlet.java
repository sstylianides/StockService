package servlets;

import models.StockQuote;
import services.IntervalEnum;
import services.ServiceFactory;
import services.StockService;
import services.StockServiceException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class StockSearchServlet extends HttpServlet {

    private static StockService stockService = ServiceFactory.getStockService();

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{

        String symbol = request.getParameter("symbol");
        String startDate = request.getParameter("startDate");
        String endDate = request.getParameter("endDate");
        String interval = request.getParameter("interval");



        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat parser2 = new SimpleDateFormat("MM/dd/yyyy");
        Calendar fromDate = Calendar.getInstance();
        Calendar untilDate = Calendar.getInstance();



        try {
            fromDate.setTime(parser.parse(startDate));
            untilDate.setTime(parser.parse(endDate));
        } catch (ParseException e) {
            try{
                fromDate.setTime(parser2.parse(startDate));
                untilDate.setTime(parser2.parse(endDate));
            }catch (ParseException f){
                throw new ServletException();
            }
        }

        IntervalEnum i = IntervalEnum.DAILY;
        if(interval.equals("weekly")){
            i = IntervalEnum.WEEKLY;
        }else if(interval.equals("monthly")){
            i = IntervalEnum.MONTHLY;
        }

        List<StockQuote> quotes;
        try {
            quotes = stockService.getQuote(symbol, fromDate, untilDate, i);
        } catch (StockServiceException e) {
            throw new ServletException();
        }

        HttpSession session = request.getSession();

        session.setAttribute("quotes", quotes);


        ServletContext servletContext = getServletContext();
        RequestDispatcher dispatcher =
                servletContext.getRequestDispatcher("/stockquoteResults.jsp");
        dispatcher.forward(request, response);
    }


}
