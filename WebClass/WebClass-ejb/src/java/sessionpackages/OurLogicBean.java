/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionpackages;

import entitypackages.BiodataLocal;
import entitypackages.BiodataLocalHome;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.CreateException;
import javax.ejb.SessionBean;
import javax.ejb.SessionContext;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

/**
 *
 * @author Uche
 */
public class OurLogicBean implements SessionBean {
    
    private SessionContext context;
    BiodataLocalHome biodatalh = null;
    
    // <editor-fold defaultstate="collapsed" desc="EJB infrastructure methods. Click the + sign on the left to edit the code.">;

    // TODO Add code to acquire and use other enterprise resources (DataSource, JMS, enterprise bean, Web services)
    // TODO Add business methods or web service operations

    /**
     * @see javax.ejb.SessionBean#setSessionContext(javax.ejb.SessionContext)
     */
    public void setSessionContext(SessionContext aContext) {
        context = aContext;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbActivate()
     */
    public void ejbActivate() {
     biodatalh = lookupBiodataBean();
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbPassivate()
     */
    public void ejbPassivate() {
      biodatalh = null;
    }
    
    /**
     * @see javax.ejb.SessionBean#ejbRemove()
     */
    public void ejbRemove() {
      biodatalh = null;
    }
    
    // </editor-fold>;

    /**
     * See section 7.10.3 of the EJB 2.0 specification
     * See section 7.11.3 of the EJB 2.1 specification
     */
    public void ejbCreate() {
        biodatalh = lookupBiodataBean();
        // TODO implement ejbCreate if necessary, acquire resources
        // This method has access to the JNDI context so resource aquisition
        // spanning all methods can be performed here such as home interfaces
        // and data sources.
    }

    private BiodataLocalHome lookupBiodataBean() {
        try {
            Context c = new InitialContext();
            BiodataLocalHome rv = (BiodataLocalHome) c.lookup("java:comp/env/BiodataBean");
            return rv;
        } catch (NamingException ne) {
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, "exception caught", ne);
            throw new RuntimeException(ne);
        }
    }

    public String createBiodata(String firstName, String surName, String sex, int age, String maritalStatus, String dateTime) {
        String result;
        BiodataLocal biodatal = null;
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm");
        dateTime = sdf.format(date);
        String dateStamp = dateTime.substring(2, 4) + dateTime.substring(5, 7) + dateTime.substring(8, 10) + dateTime.substring(11, 13) +
                dateTime.substring(14, 16);
        try {
            biodatal = biodatalh.create(firstName);
            biodatal.setSurName(surName);
            biodatal.setSex(sex);
            biodatal.setAge(age);
            biodatal.setMaritalStatus(maritalStatus);
            biodatal.setDateTime(dateStamp);
            result = "Created successfully";
        } catch (CreateException ex) {
            result ="Creat failed";
            ex.printStackTrace();

        }

        return result;
    }


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method" or "Web Service > Add Operation")
    
}
