package kd.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="customer")
public class Customer {
 @Id
// @GeneratedValue(strategy = GenerationType.)
 @Column(name="id")
 private int id;
 @Column(name="name")
 private String name;
 @Column(name="address")
 private String address;
 @Column(name="bill")
 private int bill;
 
public Customer() {
	super();
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

public String getAddress() {
	return address;
}

public void setAddress(String address) {
	this.address = address;
}

public int getBill() {
	return bill;
}

public void setBill(int bill) {
	this.bill = bill;
}
 
 
 
 
}
