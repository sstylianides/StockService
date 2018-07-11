package models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;

@Entity
@Table(name="quotes")
public class StockQuote {


    private int id;
    private String symbol;
    private BigDecimal value;
    private Calendar date;

    public static SimpleDateFormat formatter = new SimpleDateFormat("MM/dd/yyyy");


    /**
     * models.StockQuote constructor with getters for symbol and value
     * first checks if symbol symbol is null or is empty
     * throws an exception if symbol is empty or null
     * throws an exception if value is equal or less than zero
     * @param symbol takes in a stock ticker symbol
     * @param value takes in a price for the symbol
     * @param date
     * @return getters return value and symbol of models.StockQuote Object
     * @throws IllegalArgumentException if symbol is null or empty, or date is null
     */
    public StockQuote(@NotNull String symbol, @NotNull BigDecimal value, @NotNull Calendar date) {

        if(value == null || value.compareTo(BigDecimal.ZERO) <= 0){
            throw new IllegalArgumentException("Stock value must be non-null & positive");
        }
        if(symbol == null || symbol.isEmpty()){
            throw new IllegalArgumentException("Stock Symbol must be a non-empty non-null string");
        }
        if(date == null){
            throw new IllegalArgumentException("Date must be non-null");
        }
        this.symbol = symbol;
        this.value = value;
        this.date = date;
    }


    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "symbol", nullable = false, insertable = true, updatable = true, length = 256)
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol){
        this.symbol = symbol;
    }

    @Basic
    @Column(name = "price", nullable = false, insertable = true, updatable = true)
    public BigDecimal getValue() {
        return value;
    }

    public void setValue(BigDecimal value){
        this.value = value;
    }

    @Basic
    @Column(name = "time", nullable = false, insertable = true, updatable = true)
    public Calendar getDate() {

        return date;
    }

    public void setDate (Calendar date){
        this.date = date;
    }

    @Override
    public String toString() {
        return "StockQuote{" +
                "id=" + id +
                ", symbol='" + symbol + '\'' +
                ", value=" + value +
                ", date=" + formatter.format(date.getTime()) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StockQuote that = (StockQuote) o;
        return id == that.id &&
                Objects.equals(symbol, that.symbol) &&
                Objects.equals(value, that.value) &&
                Objects.equals(date, that.date);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, symbol, value, date);
    }
}
