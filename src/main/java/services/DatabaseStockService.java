package services;

import models.StockQuote;
import util.DatabaseConnectionException;
import util.DatabaseUtils;

import java.math.BigDecimal;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * An implementation of the services.StockService interface that gets
 * stock data from a database.
 */
public class DatabaseStockService implements StockService {

    public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * Return the current price for a share of stock  for the given symbol
     *
     * @param symbol the stock symbol of the company you want a quote for.
     *               e.g. APPL for APPLE
     * @return a  <CODE>BigDecimal</CODE> instance
     * @throws StockServiceException if using the service generates an exception.
     *                               If this happens, trying the service may work, depending on the actual cause of the
     *                               error.
     */
    @Override
    public StockQuote getQuote(String symbol) throws StockServiceException {

        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from quotes where symbol = '" + symbol + "'";

            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                Calendar cal = Calendar.getInstance();
                cal.setTime(time);
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(symbolValue, price, cal));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        if (stockQuotes.isEmpty()) {
            throw new StockServiceException("There is no stock data for:" + symbol);
        }
        return stockQuotes.get(0);
    }

    /**
     * Get a historical list of stock quotes for the provide symbol
     *
     * @param symbol the stock symbol to search for
     * @param from   the date of the first stock quote
     * @param until  the date of the last stock quote
     * @return a list of models.StockQuote instances
     * @throws   StockServiceException if using the service generates an exception.
     * If this happens, trying the service may work, depending on the actual cause of the
     * error.
     */
    @Override
    public List<StockQuote> getQuote(String symbol, Calendar from, Calendar until, IntervalEnum interval) throws StockServiceException{

        List<StockQuote> stockQuotes = null;
        try {
            Connection connection = DatabaseUtils.getConnection();
            Statement statement = connection.createStatement();
            String queryString = "select * from quotes where symbol = '" + symbol + "' " +
                    "and time >= '" + formatter.format(from.getTime()) + "' " +
                    "and time <= '" + formatter.format(until.getTime()) + "'";


            ResultSet resultSet = statement.executeQuery(queryString);
            stockQuotes = new ArrayList<>(resultSet.getFetchSize());
            while(resultSet.next()) {
                String symbolValue = resultSet.getString("symbol");
                Date time = resultSet.getDate("time");
                Calendar cal = Calendar.getInstance();
                cal.setTime(time);
                BigDecimal price = resultSet.getBigDecimal("price");
                stockQuotes.add(new StockQuote(symbolValue, price, cal));
            }

        } catch (DatabaseConnectionException | SQLException exception) {
            throw new StockServiceException(exception.getMessage(), exception);
        }
        return stockQuotes;
    }
}
