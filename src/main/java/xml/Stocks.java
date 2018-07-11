package xml;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
        "stock"
})


@XmlRootElement(name = "stocks")
public class Stocks implements XMLDomainObject{

    @XmlElement(required = true)
    protected List<Stock> stock;


    /**
     * Gets the value of the stock property.
     *
     * @return
     *     possible object is
     *     {@link Stocks }
     *
     */
    public List<Stock> getStock() {
        if(stock ==null){
            stock = new ArrayList<>();
        }
        return stock;
    }


    @Override
    public String toString() {
        return "Stocks{" +
                "stock=" + stock +
                '}';
    }
}
