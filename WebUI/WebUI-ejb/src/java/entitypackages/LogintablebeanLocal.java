/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entitypackages;

import javax.ejb.EJBLocalObject;

/**
 *
 * @author Uche
 */
public interface LogintablebeanLocal extends EJBLocalObject {

    String getEmail();

    void setEmail(String email);

    String getName();

    void setName(String name);

    String getPassword();

    void setPassword(String password);


}
