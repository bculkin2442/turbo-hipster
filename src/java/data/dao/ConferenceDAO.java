/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.Conference;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.FlushModeType;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * DAO for conferences
 *
 * @author Benjamin
 */
public class ConferenceDAO {

  private static EntityManagerFactory emf;

  private EntityManager em;

  static {
    emf = Persistence.createEntityManagerFactory("bculkinmod5altPU");
  }

  public ConferenceDAO() {
    em = emf.createEntityManager();
  }

  public boolean hasBeenConnected() {
    return em != null;
  }

  public String registerConference(Conference cf) {
    String strang = "";
    if (em.contains(cf)) {
      return "Conference with this code already exists."
              + " Choose another one";
    } else {
      boolean commited = false;
      try {
        em.persist(cf);
        flush();
        em.refresh(cf);
        commited = true;
        return "Succesfully registered conference.";

      } catch (SecurityException ex) {
      } catch (IllegalStateException ex) {
      } finally {
        if (!commited) {
          try {
            em.getTransaction().rollback();
          } catch (IllegalStateException ex) {
            Logger.getLogger(ConferenceDAO.class.getName()).log(Level.SEVERE, null, ex);
          } catch (SecurityException ex) {
            Logger.getLogger(ConferenceDAO.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
            strang = "Something bad happened. Please try again.";
          }
        }
        strang = "Something bad happened. Please try again.";
      }
      return strang;
    }
  }

  public Conference
          getConference(String cde) {
    return em.find(Conference.class, cde);
  }

  public List<Conference> getConferences(int max, int page) {
    TypedQuery<Conference> tq = em.createQuery("SELECT c FROM Conference AS c", Conference.class
    );
    if (max
            <= 0) {
      return tq.getResultList();
    } else {
      return tq.setFirstResult(page * max).setMaxResults(max).getResultList();
    }
  }

  public void deleteConference(String cde) {
    em.remove(getConference(cde));
    flush();
  }

  public void refreshListing() {
    List<Conference> cl = getConferences(0, 0);
    for (Conference c : cl) {
      refresh(c);
    }
  }

  public void flush() {
    em.getTransaction().begin();
    em.flush();
    em.getTransaction().commit();
  }

  public void refresh(Conference cf) {
    em.refresh(cf);
  }
}
