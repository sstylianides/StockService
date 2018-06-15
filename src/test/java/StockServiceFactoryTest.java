import org.junit.Assert;
import org.junit.Test;

public class StockServiceFactoryTest {

    /**
     * test GetService to make sure that object is not null
     * @result will make sure object not null
     */
    @Test
    public void testGetService(){
        StockService stockService = StockServiceFactory.getService();
        Assert.assertNotNull(stockService);


    }

    //TODO: write another test here only if StockServiceFactory class is updated with new code



}
