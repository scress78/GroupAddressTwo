/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import model.AddressBookUser;

/**
 * @author winte
 *
 */
public class AddressBookUserHelper {
	
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressGroupTwo");
			public void insertAddressBookUser(AddressBookUser s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		}
			
			public List<AddressBookUser> showAllAddressBookUsers() {
				EntityManager em = emfactory.createEntityManager();
				List<AddressBookUser> allAddressBookUsers = em.createQuery("SELECT s FROM AddressBookUser s").getResultList();
				return allAddressBookUsers;
				}
}
