/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package sessionpackages;

import javax.ejb.CreateException;
import javax.ejb.EJBLocalHome;

/**
 *
 * @author Admin
 */
public interface LogicHubLocalHome extends EJBLocalHome {
    
    sessionpackages.LogicHubLocal create()  throws CreateException;

}
