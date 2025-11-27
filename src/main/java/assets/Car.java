package assets;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Car {
	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String model;
	private double price;
	private String number;
	private String fuelType;
	private String owner;
	private String status="avilable";
	public Car(String name, String model, double price, String number, String owner, String fuelType) {
		super();
		this.name = name;
		this.model = model;
		this.price = price;
		this.number = number;
		this.owner=owner;
		this.fuelType = fuelType;
	}
	@Override
	public String toString() {
		return "Car [id=" + id + ", name=" + name + ", model=" + model + ", price=" + price + ", number=" + number
				+ ", fuelType=" + fuelType + ", owner=" + owner + ", status=" + status + "]";
	}
	public Car() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getOwner() {
		return owner;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	
	
	
	
	

}
