import org.junit.Assert;
import org.junit.Test;
import services.ServiceFactory;
import services.StockService;

public class ServiceFactoryTest {

    /**
     * test GetService to make sure that object is not null
     * @result will make sure object not null
     */
    @Test
    public void testGetService(){
        StockService stockService = ServiceFactory.getStockService();
        Assert.assertNotNull(stockService);


    }

}
