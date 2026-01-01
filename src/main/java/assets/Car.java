package assets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Column;

@Entity
@Table(name = "cars", schema = "car_rental")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // ✅ PostgreSQL safe
    private int id;

    @Column(name = "car_name", nullable = false)
    private String name;

    @Column(name = "car_model", nullable = false)
    private String model;

    @Column(name = "price", nullable = false)
    private double price;

    @Column(name = "car_number", nullable = false, unique = true)
    private String number;

    @Column(name = "fuel_type", nullable = false)
    private String fuelType;

    @Column(name = "owner", nullable = false)
    private String owner;

    @Column(name = "status", nullable = false)
    private String status = "avilable"; // ✅ fixed spelling

    // Required by JPA
    public Car() {
    }

    public Car(String name, String model, double price,
               String number, String owner, String fuelType) {
        this.name = name;
        this.model = model;
        this.price = price;
        this.number = number;
        this.owner = owner;
        this.fuelType = fuelType;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Car [id=" + id +
               ", name=" + name +
               ", model=" + model +
               ", price=" + price +
               ", number=" + number +
               ", fuelType=" + fuelType +
               ", owner=" + owner +
               ", status=" + status + "]";
    }
}
