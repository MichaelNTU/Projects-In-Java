/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bcdl;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
//import 

/**
 * Web application lifecycle listener.
 *
 * @author mikeo
 */
public class BCDLListener implements ServletContextListener {
     // Prepare the EntityManagerFactory & Enhance:
    public void contextInitialized(ServletContextEvent e) {
        com.objectdb.Enhancer.enhance("bcdl.*");
        EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("$objectdb/db/appmanagetooloodb.odb");
        e.getServletContext().setAttribute("emf", emf);
    }
    
//    public void contextInitialized_Branch(ServletContextEvent branch) {
//        com.objectdb.Enhancer.enhance("bcdl.*");
//        EntityManagerFactory emf =
//            Persistence.createEntityManagerFactory("objectdb/db/appmanagementtooloodb.odb");
//        branch.getServletContext().setAttribute("emf", emf);
//    }

    // Release the EntityManagerFactory:
    public void contextDestroyed(ServletContextEvent e) {
        EntityManagerFactory emf =
            (EntityManagerFactory)e.getServletContext().getAttribute("emf");
        emf.close();
    }


//    @Override
//    public void contextInitialized(ServletContextEvent sce) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
//
//    @Override
//    public void contextDestroyed(ServletContextEvent sce) {
//        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
//    }
}
