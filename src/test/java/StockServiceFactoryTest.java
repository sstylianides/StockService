import org.junit.Assert;
import org.junit.Test;

public class StockServiceFactoryTest {

    @Test
    public void testGetService(){
        StockService stockService = StockServiceFactory.getService();
        Assert.assertNotNull(stockService);


    }



}
