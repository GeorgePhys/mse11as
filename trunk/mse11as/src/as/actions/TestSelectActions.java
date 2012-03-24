package as.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import as.entities.TestQuestions;
import as.entities.Tests;
import as.services.SelectAllTestsService;
import as.services.TestsService;

@ManagedBean(name = "testSelect")
@RequestScoped
public class TestSelectActions implements Serializable {

	private static final long serialVersionUID = 1L;
	
	/**
	 * Mapping with the bean for getting test questions data/actions
	 */
	@ManagedProperty(value = "#{selectAllTestsAction}")
	public SelectAllTestsAction d;

	private ArrayList<TestQuestions> selectedTestQuestions;
	@SuppressWarnings("unused")
	private ArrayList<TestQuestions> hiddenArchiveTestQuestions;
	
	/**
	 * set test questions by choosen test
	 */
	@PostConstruct
	public void init() {
		this.selectedTestQuestions = d.getTestQuestions();
		this.hiddenArchiveTestQuestions = this.selectedTestQuestions;
		for(int i=0;i<this.selectedTestQuestions.size();i++){
			
		}
	}

	public ArrayList<TestQuestions> getSelectedTestQuestions() {
		return selectedTestQuestions;
	}

	public void setSelectedTestQuestions(
			ArrayList<TestQuestions> selectedTestQuestions) {
		this.selectedTestQuestions = selectedTestQuestions;
	}

	public SelectAllTestsAction getD() {
		return d;
	}

	public void setD(SelectAllTestsAction d) {
		this.d = d;
	}
	

}
