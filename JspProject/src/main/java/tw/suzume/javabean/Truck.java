package tw.suzume.javabean;

import java.io.Serializable;

public class Truck implements Serializable {

	   private int id;
	   private String brand;
	   private String size;
	   private int price;
	
	   
	
	@Override
	public String toString() {
		return this.getId()+" "+this.getBrand()+" "+this.getSize()+" "+this.getPrice();
	}

	public int getId() {
		return id;
	}

	public String getBrand() {
		return brand;
	}
	

	public Truck(int id, String brand, String size, int price) {
		this.id = id;
		this.brand = brand;
		this.size = size;
		this.price = price;
	}
	
	public Truck(String brand, String size, int price) {
		this.brand = brand;
		this.size = size;
		this.price = price;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public Truck() {
	
	}

}