package web;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class PersistenceListener implements ServletContextListener {

  private EntityManagerFactory entityManagerFactory;

  public void contextInitialized(ServletContextEvent sce) {
    ServletContext context = sce.getServletContext();
    entityManagerFactory = Persistence.createEntityManagerFactory("bculkinmod5altPU");
    context.setAttribute("entityManager", entityManagerFactory);
  }

  public void contextDestroyed(ServletContextEvent sce) {

    entityManagerFactory.close();
  }
}
