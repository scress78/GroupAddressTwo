/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package model;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class AddressBookDetails {
	@Id
	@GeneratedValue
	private int id; // select explanatory
	private String listName; // Kind of a placeholder. Name of specific Address-List
	private LocalDate dateStamp; // Date added  - AW

	
	//  OTM types. Match classes Address and AddressBookUser
	@ManyToOne(cascade=CascadeType.PERSIST)
	private AddressBookUser addressBookUser;
	
	//@JoinTable
	// Merge used below // always RETURN HERE AND CHECK MERGE VS PERSIST!
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Address> listOfAddresses;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getListName() {
		return listName;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public AddressBookUser getAddressBookUser() {
		return addressBookUser;
	}

	public void setAddressBookUser(AddressBookUser addressBookUser) {
		this.addressBookUser = addressBookUser;
	}

	public List<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(List<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
	}
	
	public LocalDate getDateStamp() {
		return dateStamp;
	}
	/**
	 * @param tripDate the tripDate to set
	 */
	public void setDateStamp(LocalDate dateStamp) {
		this.dateStamp = dateStamp;
	}

	

	public AddressBookDetails(int id, String listName, AddressBookUser addressBookUser, List<Address> listOfAddresses, LocalDate dateStamp) {
		super();
		this.id = id;
		this.listName = listName;
		this.addressBookUser = addressBookUser;
		this.listOfAddresses = listOfAddresses;
		this.dateStamp = dateStamp;
	}
	
	public AddressBookDetails(String listName, AddressBookUser addressBookUser, List<Address> listOfAddresses, LocalDate dateStamp) {
		super();
		this.listName = listName;
		this.addressBookUser = addressBookUser;
		this.listOfAddresses = listOfAddresses;
		this.dateStamp = dateStamp;
	}
	
	public AddressBookDetails(String listName, AddressBookUser addressBookUser, LocalDate dateStamp) {
		super();
		this.listName = listName;
		this.addressBookUser = addressBookUser;
		this.dateStamp = dateStamp;
	}
	
	public AddressBookDetails() {
		super();
	}

	@Override
	public String toString() {
		return "AddressBookDetails [id=" + id + ", listName=" + listName + ", dateStamp=" + dateStamp
				+ ", addressBookUser=" + addressBookUser + ", listOfAddresses=" + listOfAddresses + "]";
	}
	
	

}
