package POJO;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ID;
    @Column(name = "Name")
    private String Name;
    @Column(name = "Price")
    private  int Price;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getPrice() {
        return Price;
    }

    public void setPrice(int price) {
        Price = price;
    }

    public Product(int ID, String name, int price) {
        this.ID = ID;
        Name = name;
        Price = price;
    }

    public Product(){};

    @Override
    public String toString() {
        return "Product{" +
                "ID='" + ID + '\'' +
                ", Name='" + Name + '\'' +
                ", Price=" + Price +
                '}';
    }
}
