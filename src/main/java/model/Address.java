/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 27, 2022
 */
package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="address")
public class Address {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	private String name;
	private String address; // may want to consider changing this to street, property address within class address confusing
	// space for other fields
	
	
	public Address(int id, String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Address(String name, String address) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
	}
	
	public Address() {
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

}
