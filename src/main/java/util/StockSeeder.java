package util;

import com.ibatis.common.jdbc.ScriptRunner;
import models.StockQuote;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import services.StockServiceException;
import xml.StockReader;
import xml.Stocks;

import javax.xml.bind.JAXBException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

public class StockSeeder {

    public static void main(String args[]) throws JAXBException, ParseException, StockServiceException, DatabaseInitializationException {
        Stocks stocks = StockReader.readStockXML("./src/main/resources/xml/stock_info.xml");

        List<StockQuote> stockQuotes = StockQuoteXMLAdapter.stocksXMLtoStockQuotes(stocks);

        dropAndCreateTable();

        for(StockQuote stockQuote: stockQuotes){
            addQuoteToDB(stockQuote);
        }


    }


    private static void dropAndCreateTable() throws DatabaseInitializationException {
        Connection connection = null;
        try {
            connection = DatabaseUtils.getConnection();
            connection.setAutoCommit(false);
            ScriptRunner runner = new ScriptRunner(connection, false, false);
            InputStream inputStream = new FileInputStream("./src/main/java/sql/quote_db_initialization.sql");

            InputStreamReader reader = new InputStreamReader(inputStream);

            runner.runScript(reader);
            reader.close();
            connection.commit();
            connection.close();

        } catch (DatabaseConnectionException | SQLException | IOException e) {
            throw new DatabaseInitializationException("Could not initialize db because of:"
                    + e.getMessage(), e);
        }
    }

    private static void addQuoteToDB(StockQuote stockQuote) throws StockServiceException {

        Session session = DatabaseUtils.getSessionFactory().openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.saveOrUpdate(stockQuote);
            transaction.commit();
        } catch (HibernateException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();  // close transaction
            }
            throw new StockServiceException("Could not save or update person data. " + e.getMessage(), e);

        } finally {
            if (transaction != null && transaction.isActive()) {
                transaction.commit();
            }
        }

    }

}
