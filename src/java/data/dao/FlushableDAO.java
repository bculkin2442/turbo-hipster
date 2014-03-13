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
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 * A base class
 *
 * @author Benjamin
 */
public class FlushableDAO<T, K> {

  private EntityManagerFactory emf;

  private EntityManager em;
  private final String clasz;
  private final String shortClasz;

  public FlushableDAO(String unitName, String clasz) {
    emf = Persistence.createEntityManagerFactory(unitName);
    em = emf.createEntityManager();
    this.clasz = clasz;
    String[] tmp = clasz.split(".");
    shortClasz = tmp[tmp.length - 1];
  }

  @PreDestroy
  public void dispose() {
    flush();
    em.close();
    emf.close();
  }

  public void register(T registrant) {
    em.persist(registrant);
    flush();
  }

  public void remove(T toBeRemoved) {
    em.remove(toBeRemoved);
    em.flush();
  }

  public T get(K id) {
    try {
      return (T) em.find(Class.forName(clasz), id);
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(FlushableDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public List<T> getMultiple(int max, int page) {

    try {
      TypedQuery<T> tq = (TypedQuery<T>) em.createQuery("SELECT c FROM "
              + shortClasz + "AS c", Class.forName(clasz)
      );
      if (max
              <= 0) {
        return tq.getResultList();
      } else {
        return tq.setFirstResult(page * max).setMaxResults(max).getResultList();
      }
    } catch (ClassNotFoundException ex) {
      Logger.getLogger(FlushableDAO.class.getName()).log(Level.SEVERE, null, ex);
    }
    return null;
  }

  public void flush() {
    em.getTransaction().begin();
    em.flush();
    em.getTransaction().commit();
  }
}
