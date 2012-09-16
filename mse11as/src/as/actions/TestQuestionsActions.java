package as.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.model.DataModel;
import javax.servlet.http.HttpSession;

import as.entities.File;
import as.entities.TestAnswers;
import as.entities.TestQuestions;
import as.entities.Tests;
import as.services.TestsService;

@ManagedBean(name = "tq")
@SessionScoped
public class TestQuestionsActions implements Serializable {

	private static final long serialVersionUID = 1L;
	private List<TestAnswers> mp = new ArrayList<TestAnswers>();
	/**
	 * Mapping el elment from t session bean
	 */
	@ManagedProperty(value = "#{t.test}")
	public Tests t;

	// questions for the specific test
	private ArrayList<TestQuestions> questions = new ArrayList<TestQuestions>();
	// converted test questions for table inport
	
	private ArrayList<TestAnswers> tAnswerArr = new ArrayList<TestAnswers>();
	
	private List<TestAnswers> tAnswers;
	private List<TestAnswers> list = new LinkedList<TestAnswers>();
	
	@EJB
	private TestsService ts;
	private Set<TestQuestions> set = new HashSet<TestQuestions>();

	public Set<TestQuestions> getSet() {
		return set;
	}

	public void setSet(Set<TestQuestions> set) {
		this.set = set;
	}

	/**
	 * Generate pool with test questions (objects)
	 */
	@PostConstruct
	public void init() {
		for (int i = 0; i < this.t.getNumQuestions(); i++) {
			TestQuestions testQuestionTemp = new TestQuestions();
			tAnswers = new LinkedList<TestAnswers>();
			for(int j=0;j<this.t.getNumAnswPerQuestion();j++){
				TestAnswers dom = new TestAnswers();
				dom.setTestQuestions(testQuestionTemp);
				tAnswers.add(dom);
			}
			testQuestionTemp.setTestAnswers(tAnswers);
			this.questions.add(testQuestionTemp);
			
		}
		
	}

	public List<TestAnswers> getList() {
		return list;
	}

	public void setList(List<TestAnswers> list) {
		this.list = list;
	}

	public ArrayList<TestAnswers> gettAnswerArr() {
		return tAnswerArr;
	}

	public void settAnswerArr(ArrayList<TestAnswers> tAnswerArr) {
		this.tAnswerArr = tAnswerArr;
	}

	public ArrayList<TestQuestions> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<TestQuestions> questions) {
		this.questions = questions;
	}
	
	public List<TestAnswers> getListFromSet(Set<TestAnswers> set){
		list = new ArrayList<TestAnswers>(set);
		return list;
	}
	
	public List<TestAnswers> getMp() {
		return mp;
	}

	public void setMp(List<TestAnswers> mp) {
		this.mp = mp;
	}

	public Tests getT() {
		return t;
	}
	public void setT(Tests t) {
		this.t = t;
	}

	

	public List<TestAnswers> gettAnswers() {
		return tAnswers;
	}

	public void settAnswers(List<TestAnswers> tAnswers) {
		this.tAnswers = tAnswers;
	}

	/**
	 * Save import test questions in active test then save the data to database
	 * 
	 * @param d
	 *            list with test questions
	 * @return string - transfer to main administration page
	 */
	public String save(ArrayList<TestQuestions> d) {
		for (int i = 0; i < d.size(); i++) {
			TestQuestions tq = d.get(i);
			tq.setTestID(this.t);
			this.set.add(tq);
			
		}
		this.t.setTestQuestions(this.set);
		this.ts.save(t);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
			    .getExternalContext().getSession(true);
			    session.removeAttribute("t");
			    session.removeAttribute("tq");
System.out.println("here");
		return "ok";
	}
	public String cancel(){
		this.ts.remove(this.t);
		this.questions = null;
		this.t = null;
		return "CancelCreateTest";
	}
}
