/**
 * 
 */
package as.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import as.entities.File;
import as.entities.TestQuestions;
import as.entities.Tests;
import as.entities.User;
import as.entities.UserAssignedTests;
import as.services.DownloadFileService;
import as.services.SelectAllTestsService;
import as.services.ViewAllUsersTService;

/**
 * @author Nataliya Yordanova
 * @Mar 06, 2012
 */
@ManagedBean
@SessionScoped
public class ViewAllUsersTAction implements Serializable {
	private ArrayList<Object> users = null;

	//private ArrayList<TestQuestions> testQuestions;

	@EJB
	private ViewAllUsersTService service;

	public ArrayList<Object> getUsers() {
		users = service.GetAllUsers();
		return users;
	}

	public void setUsers(ArrayList<Object> users) {
		this.users = users;
	}

	/*public String Delete(Tests test) {
		service.Delete(test);
		tests.remove(test);
		return "del";
	}*/

	/**
	 * Get all questions by specific test
	 * 
	 * @param test
	 *            object of selected test
	 * @return string - transfer data to fillquestion page
	 */
	/*public String generateTest(Tests test) {
		this.testQuestions = service.getTestQuestions(test);
		return "GenerateMyTest";
	}

	public ArrayList<TestQuestions> getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(ArrayList<TestQuestions> testQuestions) {
		this.testQuestions = testQuestions;
	}
	*/

}
