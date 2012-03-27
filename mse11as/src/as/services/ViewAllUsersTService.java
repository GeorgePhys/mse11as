/**
 * 
 */
package as.services;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import as.entities.File;
import as.entities.TestQuestions;
import as.entities.Tests;
import as.entities.User;
import as.entities.UserAssignedTests;

/**
 * @author Nataliya Yordanova
 * @Mar 06, 2012
 */
@Stateless
public class ViewAllUsersTService {
    @PersistenceContext
    private EntityManager em;

    public ArrayList<Object> GetAllUsers() {
		ArrayList<Object> listUsers = (ArrayList<Object>) em.createQuery("select us from " + User.class.getName() + " us").getResultList();
		return listUsers;
    }

    /*public ArrayList<Tests> Search(String str) {
		System.out.println(str + "AAAAA");
		ArrayList<Tests> listTests = (ArrayList) em.createQuery(
			"SELECT t FROM Tests t WHERE t.id LIKE '%" + str
				+ "%' OR t.Name LIKE '%" + str + "%'", Tests.class)
			.getResultList();
		return listTests;
    }
    
	public ArrayList<TestQuestions> getTestQuestions(Tests t) {
		String g = String.valueOf(t.getTestID());
		ArrayList<TestQuestions> listTestsQuestions 44444444444444444444444444455= (ArrayList) em.createQuery(
			"select t from user left join userassignedtests on user.userID=userassignedtests.userID_userID").getResultList();
		return listTestsQuestions;
	}

    public void Delete(Tests test) {
    	em.remove(em.merge(test));
    }*/
    
}
