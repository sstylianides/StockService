package xml;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;

public class StockReader {

    public static Stocks readStockXML(String fileName) throws JAXBException {
        JAXBContext jaxbContext = JAXBContext.newInstance(Stocks.class);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Stocks stocks = (Stocks) unmarshaller.unmarshal(new File(fileName));

        return stocks;
    }



    public static void main(String args[]) throws JAXBException {
        Stocks stocks = readStockXML("./src/main/resources/xml/stock_info.xml");

        System.out.println(stocks);
    }


}
