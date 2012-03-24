package as.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;

import as.entities.SolvedTest;
import as.entities.TestQuestions;
import as.entities.Tests;
import as.services.SelectAllTestsService;
import as.services.TestsService;

@ManagedBean(name = "testSelect")
@SessionScoped
public class TestSelectActions implements Serializable {
	@EJB
	private TestsService ts;
	private static final long serialVersionUID = 1L;
	
	/**
	 * Mapping with the bean for getting test questions data/actions
	 */
	@ManagedProperty(value = "#{selectAllTestsAction}")
	public SelectAllTestsAction d;

	private ArrayList<TestQuestions> selectedTestQuestions = new ArrayList<TestQuestions>();
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
			for(int j=0;j<this.selectedTestQuestions.get(i).getTestAnswers().size();j++){
			this.selectedTestQuestions.get(i).getTestAnswers().get(j).setAnswerVal(false);
			}
		
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
	
	public String doneTest(ArrayList<TestQuestions> testQuestions){
		for(int i=0;i<testQuestions.size();i++){
			SolvedTest sTest = new SolvedTest();
			sTest.setTestID(testQuestions.get(i).getTestID().getTestID());
			sTest.setQuestionID(testQuestions.get(i).getQuestionID());
			for(int j=0;j<testQuestions.get(i).getTestAnswers().size();j++){
				boolean tempQuestionVal = testQuestions.get(i).getTestAnswers().get(j).getAnswerVal();
				if(tempQuestionVal==true){
					sTest.setAnswer(testQuestions.get(i).getTestAnswers().get(j).getAnswer());
					sTest.setAnswerVal(testQuestions.get(i).getTestAnswers().get(j).getAnswerVal());
				}
			}
			
			this.ts.save(sTest);
		}
		return "ReadyTest";
	}
	
	

}
