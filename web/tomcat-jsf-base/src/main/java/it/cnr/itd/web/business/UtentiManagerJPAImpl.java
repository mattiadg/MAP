package it.cnr.itd.web.business;

import it.cnr.itd.web.model.Utente;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.NotSupportedException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.UserTransaction;

@ApplicationScoped

public class UtentiManagerJPAImpl implements Serializable, UtentiManager {
	
	@PersistenceContext//(type=PersistenceContextType.EXTENDED)
    private EntityManager entityManager;
	
	@Inject UserTransaction tx;
	

	@Override
	public Utente check(String username, String password) {
		Utente u=null;
		try {
			u = entityManager.createQuery(
				    "SELECT c FROM Utente c WHERE c.username=:custName",Utente.class)
				    .setParameter("custName", username)
				    .getSingleResult();
		} catch (javax.persistence.NoResultException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public void update(Utente utente) {
		//EntityTransaction tx = entityManager.getTransaction();
		try {
			tx.begin();
			entityManager.merge(utente);
			tx.commit();
		} catch (NotSupportedException | SystemException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalStateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicMixedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (HeuristicRollbackException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
