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
import as.entities.TestQuestions;
import as.entities.Tests;

/**
 * @author Nataliya Yordanova
 * @Mar 01, 2012
 */
@Stateless
public class SelectAllTestsService {
    @PersistenceContext
    private EntityManager em;

    public ArrayList<Tests> GetAllTests() {
		ArrayList<Tests> listTests = (ArrayList) em.createQuery(
			"SELECT t FROM Tests t").getResultList();
		return listTests;
    }

    public ArrayList<Tests> Search(String str) {
		System.out.println(str + "AAAAA");
		ArrayList<Tests> listTests = (ArrayList) em.createQuery(
			"SELECT t FROM Tests t WHERE t.id LIKE '%" + str
				+ "%' OR t.Name LIKE '%" + str + "%'", Tests.class)
			.getResultList();
		return listTests;
    }
    
	public ArrayList<TestQuestions> getTestQuestions(Tests t) {
		String g = String.valueOf(t.getTestID());
		ArrayList<TestQuestions> listTestsQuestions = (ArrayList) em.createQuery(
			"SELECT t FROM TestQuestions t WHERE t.testID='"+g+"'").getResultList();
		return listTestsQuestions;
	}

    public void Delete(Tests test) {
    	em.remove(em.merge(test));
    }
    
}
