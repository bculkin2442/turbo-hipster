/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import data.Type;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Benjamin
 */
public class TypeDAO {

  private static EntityManagerFactory emf;

  private EntityManager em;

  static {
    emf = Persistence.createEntityManagerFactory("bculkinmod5altPU");
  }

  public TypeDAO() {
    em = emf.createEntityManager();
  }

  public void registerType(Type ty) {
    em.persist(ty);
    flush();
  }

  public Type getType(String cde) {
    return em.find(Type.class, cde);
  }

  public void deleteType(String cde) {
    em.remove(getType(cde));
  }

  public void flush() {
    em.getTransaction().begin();
    em.flush();
    em.getTransaction().commit();
  }
}
