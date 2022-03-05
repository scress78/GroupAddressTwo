/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="addressbookuser")
public class AddressBookUser {
	
	@Id
	@GeneratedValue
	private int id;
	private String userName;
	
	
	public AddressBookUser() {
		super();
	}
	
	public AddressBookUser(int id, String userName) {
		super();
		this.id = id;
		this.userName = userName;
	}
	
	public AddressBookUser(String userName) {
		super();
		this.userName = userName;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Override
	public String toString() {
		return "AddressBookUser [id=" + id + ", userName=" + userName + "]";
	}

}
