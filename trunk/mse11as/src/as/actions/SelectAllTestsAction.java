/**
 * 
 */
package as.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import as.entities.File;
import as.entities.Tests;
import as.services.DownloadFileService;
import as.services.SelectAllTestsService;

/**
 * @author Nataliya Yordanova
 * @Mar 01, 2012
 */
@ManagedBean
@SessionScoped
public class SelectAllTestsAction implements Serializable {
	 private ArrayList<Tests> tests = new ArrayList<Tests>();

	    @EJB
	    private SelectAllTestsService service;

	    public ArrayList<Tests> getTests() {
			tests = service.GetAllTests();
			return tests;
	    }

	    public void setTests(ArrayList<Tests> tests) {
	    	this.tests = tests;
	    }

	    public String Delete(Tests test) {
			service.Delete(test);
			tests.remove(test);
			return "del";
	    }
}
