/**
 * @author Spencer Cress - scress
 * CIS175 - Spring 2022
 * Feb 27, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Address;

public class AddressHelper {
	static EntityManagerFactory emfactory =
			Persistence.createEntityManagerFactory("AddressGroupTwo");

	public void insertItem(Address li) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(li);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Address> showAllItems(){
		EntityManager em = emfactory.createEntityManager();
		List<Address> allItems = em.createQuery("SELECT i FROM Address i").getResultList();
		return allItems;
	}
	
	public void deleteItem(Address toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		
		TypedQuery<Address>typedQuery = em.createQuery(
				"select li from Address li where li.name = :selectedName and li.address = :selectedAddress", Address.class);
		
		//substitute parameter with actual data from toDelete
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedAddress", toDelete.getAddress());
		
		// limit to one result
		typedQuery.setMaxResults(1);
		
		//get the result, save to new list item
		Address result = typedQuery.getSingleResult();
		
		//remove result
		em.remove(result);
		em.getTransaction().commit(); // commit and close
		em.close();
	}

	/**
	 * @param idToEdit
	 * @return
	 */
	public Address searchForItemById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Address found = em.find(Address.class, idToEdit);
		em.close();
		return found;
	}

	/**
	 * @param toEdit
	 */
	public void updateItem(Address toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
		
	}

	/**
	 * @param storeName
	 * @return
	 */
	public List<Address> searchforItemByName(String Name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address>typedQuery = em.createQuery(
				"select li from Address li where li.Name = :selectedName", Address.class);
		typedQuery.setParameter("selectedName", Name);
		
		List<Address> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}

	/**
	 * @param itemName
	 * @return
	 */
	public List<Address> searchForItemByAddress(String Address) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Address>typedQuery = em.createQuery(
				"select li from Address li where li.Address = :selectedAddress", Address.class);
		typedQuery.setParameter("selectedAddress", Address);
		
		List<Address> foundItems = typedQuery.getResultList();
		em.close();
		
		return foundItems;
	}
	
	public void cleanUp() {
		emfactory.close();
	}
	
}
