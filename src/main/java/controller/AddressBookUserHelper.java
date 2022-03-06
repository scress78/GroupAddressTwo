/**
 * ajwinters@dmacc.edu - ajwinters
 * CIS175 - Spring 2022
 * Mar 2, 2022
 */
package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.AddressBookUser;

/**
 * @author winte
 *
 */
public class AddressBookUserHelper {
		static EntityManagerFactory emfactory = 
			Persistence.createEntityManagerFactory("AddressGroupTwo");
		
		public void insertAddressBookUser(AddressBookUser s) {
			// new User to DB
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.persist(s);
			em.getTransaction().commit();
			em.close();  // EntityManager, begin, persist, commit, close .. looks right
		}
			
		public List<AddressBookUser> showAllAddressBookUsers() {
			// Show all users from DB
			EntityManager em = emfactory.createEntityManager();
			// make sure table exists or can be querried.. looks good, capitalization is ok
			List<AddressBookUser> allAddressBookUsers = em.createQuery("SELECT s FROM AddressBookUser s").getResultList();
			return allAddressBookUsers;
		}
		
		public AddressBookUser findAddressBookUser(String nameToLookUp) {
			// find Username by string
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AddressBookUser> typedQuery = em.createQuery("select us from AddressBookUser us where us.AddressBookUserName = :selectedName", AddressBookUser.class);
			
			typedQuery.setParameter("selectedName", nameToLookUp);
			typedQuery.setMaxResults(1);
			AddressBookUser foundAddressBookUser;
			
			try {
				foundAddressBookUser = typedQuery.getSingleResult();
			} catch (NoResultException ex) {
				foundAddressBookUser = new AddressBookUser(nameToLookUp);
			}
			
			em.close();
			return foundAddressBookUser;
		}
}
