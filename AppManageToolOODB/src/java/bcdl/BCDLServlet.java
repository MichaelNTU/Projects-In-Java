/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcdl;

import java.io.IOException;
//import java.io.PrintWriter;
import java.util.List;
//import javax.persistence.EntityManager;
//import javax.persistence.EntityManagerFactory;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.*;
import javax.persistence.*;

/**
 *
 * @author mikeo
 */
@WebServlet(name = "BCDLServlet", urlPatterns = {"/BCDLServlet"})
public class BCDLServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    String branchName;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Obtain a database connection:
        EntityManagerFactory emf = (EntityManagerFactory)getServletContext().getAttribute("emf");
        EntityManager em = emf.createEntityManager();

        try {
            // Handle a new guest (if any):
            String branchname = request.getParameter("branchname");
            int assets= Integer.valueOf(0);
            String branchcity = request.getParameter("branchcity");
            Branch branch = new  Branch();
            if (branchname != null) {
                em.getTransaction().begin();
                em.persist(branch);
                em.persist(new Branch(branchname,assets,branchcity));
                em.getTransaction().commit();
           }

            // Display the list of guests:
            List<Branch> query1 = em.createQuery("SELECT b FROM Branch b", Branch.class).getResultList();
            request.setAttribute("branch", query1);
            request.getRequestDispatcher("/branch.jsp")
                .forward(request, response);

        } finally {
            // Close the database connection:
            if (em.getTransaction().isActive())
                em.getTransaction().rollback();
            em.close();
        }
    }

    @Override
    protected void doPost(
        HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}
