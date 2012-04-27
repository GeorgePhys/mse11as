/**
 * 
 */
package as.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import as.entities.File;
import as.entities.User;

/**
 * @author nataliya
 *
 * @Apr 02, 2012
 */

@Stateless
public class SearchUsersSolvedTestsService {
    @PersistenceContext
    private EntityManager em;
        
    public ArrayList<User> GetAllUsers() {
    	ArrayList<User> listUsers = (ArrayList) em.createQuery(
		"SELECT us FROM " + User.class.getName() + " us").getResultList();
    	return listUsers;
    }

    public ArrayList<User> search(String str, String usersType) {
    	ArrayList<User> listUsers = null;
    	
		if (usersType.equals("Номер")) {
			listUsers = (ArrayList) em.createQuery(
					"SELECT us FROM " + User.class.getName() + " us WHERE us.userID LIKE '%" + str
						+ "%'", User.class)
					.getResultList();
		} else {
			if (usersType.equals("Име")){
				listUsers = (ArrayList) em.createQuery(
						"SELECT us FROM " + User.class.getName() + " us WHERE us.firstName LIKE '%" + str
							+ "%'", User.class).getResultList();
			} else {
				if (usersType.equals("Фамилия")){
					listUsers = (ArrayList) em.createQuery(
							"SELECT us FROM " + User.class.getName() + " us WHERE us.lastName LIKE '%" + str
								+ "%'", User.class).getResultList();
				} else {
					if (usersType.equals("Имейл")){
						listUsers = (ArrayList) em.createQuery(
								"SELECT us FROM " + User.class.getName() + " us WHERE us.email LIKE '%" + str
									+ "%'", User.class).getResultList();
					}
				}
			}
		}
		return listUsers;
    }

}
