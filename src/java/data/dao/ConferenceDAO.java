/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * DAO for conferences
 *
 * @author Benjamin
 */
public class ConferenceDAO {

  @PersistenceContext
  EntityManager em;

  public boolean hasBeenConnected() {
    return em != null && em.isOpen();
  }
}
