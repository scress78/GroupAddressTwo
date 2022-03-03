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

import model.AddressBookDetails;

/**
 * @author winte
 *
 */
public class AddressBookDetailsHelper {

	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("AddressGroupTwo");
	
		public void insertNewListDetails(AddressBookDetails s) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();
		}
		
		public List<AddressBookDetails> getLists() {
			EntityManager em = emfactory.createEntityManager();
			List<AddressBookDetails> allDetails = em.createQuery("SELECT d FROM AddressBookDetails d").getResultList();
			return allDetails;
		}
	}

