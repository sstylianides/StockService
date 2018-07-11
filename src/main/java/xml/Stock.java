package xml;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "")

@XmlRootElement(name = "stock")

public class Stock implements XMLDomainObject{


    @XmlAttribute(name = "symbol", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String symbol;

    @XmlAttribute(name = "price", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String price;

    @XmlAttribute(name = "time", required = true)
    @XmlSchemaType(name = "anySimpleType")
    protected String time;



    /**
     * Gets the value of the symbol property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getSymbol() {
        return symbol;
    }

    /**
     * Sets the value of the symbol property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setSymbol(String value) {
        this.symbol = value;
    }


    /**
     * Gets the value of the price property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getPrice() {
        return price;
    }

    /**
     * Sets the value of the price property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setPrice(String value) {
        this.price = value;
    }


    /**
     * Gets the value of the time property.
     *
     * @return
     *     possible object is
     *     {@link String }
     *
     */
    public String getTime() {
        return time;
    }

    /**
     * Sets the value of the time property.
     *
     * @param value
     *     allowed object is
     *     {@link String }
     *
     */
    public void setTime(String value) {
        this.time = value;
    }


    @Override
    public String toString() {
        return "Stock{" +

                "symbol='" + symbol + '\'' +
                ", price=" + price +
                ", time=" + time +
                '}';
    }
}
