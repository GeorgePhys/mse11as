package as.actions;

import java.io.Serializable;
import java.util.ArrayList;

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

@ManagedBean(name="tq")
@RequestScoped
public class TestQuestionsActions implements Serializable {
	
	@ManagedProperty(value="#{t.test}")
	public Tests t;
	private ArrayList<TestQuestions> questions = new ArrayList<TestQuestions>();
	
	
	
	
	public ArrayList<TestQuestions> getQuestions() {
		for(int i=0; i<=t.getNumQuestions();i++){
		this.questions.add(new TestQuestions());
		}
		return this.questions;
	}


	public void setQuestions(ArrayList<TestQuestions> questions) {
		this.questions = questions;
	}



	@EJB
	private  TestsService ts;


	public Tests getT() {
		return t;
	}


	public void setT(Tests t) {
		this.t = t;
	}






	
}
