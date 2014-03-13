/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web;

import data.Conference;
import data.Duration;
import data.dao.ConferenceDAO;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Benjamin
 */
@WebServlet(name = "UpdateConferenceServlet", urlPatterns = {"/UpdateConferenceServlet"})
public class UpdateConferenceServlet extends HttpServlet {

  @Inject
  ConferenceDAO cdao;

  /**
   * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
   * methods.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {

    String cde = request.getParameter("cde");
    Conference cf = cdao.getConference(cde);
    cf.setLoc(request.getParameter("loc"));
    Duration dur = cf.getDur();
    DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT);
    try {
      dur.setStart(df.parse(request.getParameter("start")));
      dur.setFinish(df.parse(request.getParameter("finish")));
    } catch (ParseException ex) {
      Logger.getLogger(RegisterConferenceServlet.class.getName())
              .log(Level.SEVERE, null, ex);
    }
    cf.setDur(dur);
    cdao.flush();
    request.getRequestDispatcher("/ConferenceStatusServlet")
            .forward(request, response);
  }

  // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
  /**
   * Handles the HTTP <code>GET</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Handles the HTTP <code>POST</code> method.
   *
   * @param request servlet request
   * @param response servlet response
   * @throws ServletException if a servlet-specific error occurs
   * @throws IOException if an I/O error occurs
   */
  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
          throws ServletException, IOException {
    processRequest(request, response);
  }

  /**
   * Returns a short description of the servlet.
   *
   * @return a String containing servlet description
   */
  @Override
  public String getServletInfo() {
    return "Short description";
  }// </editor-fold>

}
