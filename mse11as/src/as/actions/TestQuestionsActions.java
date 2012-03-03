package as.actions;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import as.entities.File;
import as.entities.TestQuestions;
import as.entities.Tests;
import as.services.TestsService;

@ManagedBean(name = "tq")
@RequestScoped
public class TestQuestionsActions implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * Mapping el elment from t session bean
	 */
	@ManagedProperty(value = "#{t.test}")
	public Tests t;

	// questions for the specific test
	private ArrayList<TestQuestions> questions = new ArrayList<TestQuestions>();

	// converted test questions for table inport
	private Set<TestQuestions> set = new HashSet<TestQuestions>();

	@EJB
	private TestsService ts;

	/**
	 * Generate pool with test questions (objects)
	 */
	@PostConstruct
	public void init() {
		for (int i = 0; i < this.t.getNumQuestions(); i++) {
			this.questions.add(new TestQuestions());
		}
	}

	public ArrayList<TestQuestions> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<TestQuestions> questions) {
		this.questions = questions;
	}

	public Tests getT() {
		return t;
	}

	public void setT(Tests t) {
		this.t = t;
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

		return "ok";
	}
}
