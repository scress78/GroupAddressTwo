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
import javax.persistence.TypedQuery;

import model.AddressBookDetails;


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
		
		public void deleteList(AddressBookDetails toDelete) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			TypedQuery<AddressBookDetails> typedQuery = em.createQuery("select detail from AddressBookDetails detail where detail.id = :selectedId", AddressBookDetails.class);
			// Substitute parameter with actual data from the toDelete item
			typedQuery.setParameter("selectedId", toDelete.getId());
			// we only want one result
			typedQuery.setMaxResults(1);
			// get the result and save it into a new list item
			AddressBookDetails result = typedQuery.getSingleResult();
			// remove it
			em.remove(result);
			em.getTransaction().commit();
			em.close();
		}
		
		public AddressBookDetails searchForListDetailsById(Integer tempId) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			AddressBookDetails found = em.find(AddressBookDetails.class, tempId);
			em.close();
			return found;
			}
		
		public void updateList(AddressBookDetails toEdit) {
			EntityManager em = emfactory.createEntityManager();
			em.getTransaction().begin();
			em.merge(toEdit);
			em.getTransaction().commit();
			em.close();
			}
	}

