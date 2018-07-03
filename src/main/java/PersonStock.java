import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "people_stock", catalog = "stocks")
public class PersonStock {

    private int id;
    private Person person;
    private String stock;


    /**
     * Create a PersonStock that needs to be initialized
     */
    public PersonStock() {
        // this empty constructor is required by hibernate framework

    }

    /**
     * Create a valid PersonStock
     *
     * @param person the person to assign the hobby to
     * @param stock  the stock to associate the person with
     */
    public PersonStock(Person person, String stock) {
        setStock(stock);
        setPerson(person);
    }


    /**
     *
     * @return get the Person associated with this stock
     */
    @ManyToOne
    @JoinColumn(name = "person", referencedColumnName = "ID", nullable = false)
    public Person getPerson() {
        return person;
    }

    /**
     * Specify the Person associated with the Stock.
     *
     * @param person a person instance
     */
    public void setPerson(Person person) {
        this.person = person;
    }



    /**
     *
     * @return the stock
     */
    @Basic
    @Column(name = "stock", nullable = false, insertable = true, updatable = true, length = 256)
    public String getStock() {
        return stock;
    }

    /**
     *
     * @param stock a String value
     */
    public void setStock(String stock) {
        this.stock = stock;
    }



    /**
     * Primary Key - Unique ID for a particular row in the person_hobby table.
     *
     * @return an integer value
     */
    @Id
    @Column(name = "ID", nullable = false, insertable = true, updatable = true)
    public int getId() {
        return id;
    }

    /**
     * Set the unique ID for a particular row in the person_hobby table.
     * This method should not be called by client code. The value is managed in internally.
     *
     * @param id a unique value.
     */
    public void setId(int id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PersonStock that = (PersonStock) o;
        return id == that.id &&
                Objects.equals(person, that.person) &&
                Objects.equals(stock, that.stock);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, person, stock);
    }
}
