package no.hvl.dat108;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;



@Stateless
public class DeltakerEAO {
	@PersistenceContext(name = "deltakerPU")
    private EntityManager em;
	
	public void leggTilDeltaker(Deltaker d) {
		em.persist(d);
	}
	
	public List<Deltaker> hentDeltakere() {
		List<Deltaker> listen = em.createQuery("SELECT d FROM Deltaker d").getResultList();
//		List<Deltaker> listen = em.createQuery("From Deltaker").getResultList();
		return listen;
	}
	
	public boolean finnesMobilnummer(String mobilnummer) {
		Long l = (long) em.createQuery("SELECT COUNT(d) FROM Deltaker d WHERE d.mobil=:mobil").setParameter("mobil", mobilnummer).getSingleResult();
		return l >= 1 ? true : false;
		
//		return em.find(Deltaker.class, mobilnummer) != null;
//		try {
//			Deltaker d = em.find(Deltaker.class, mobilnummer);
//		} catch (NullPointerException e) {
//			return false;
//		}
//		
//		return true;
	}
	
	public String hentPassord(String mobilnummer) {
		return em.find(Deltaker.class, mobilnummer).getPassord();
	}

}
