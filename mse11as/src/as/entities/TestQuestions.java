/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class TestQuestions extends as.entities.Entity implements Serializable {

    @ManyToOne
    @JoinColumn(name = "TestID", referencedColumnName = "testID")
    private Tests testID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long questionID;
    
    @Column(columnDefinition = "Varchar(250)")
    private String question;

    @OneToMany(cascade = CascadeType.ALL,mappedBy="testQuestions")
    private List<TestAnswers> testAnswers = new ArrayList<TestAnswers>();


	public List<TestAnswers> getTestAnswers() {
		return testAnswers;
	}

	public void setTestAnswers(List<TestAnswers> testAnswers) {
		this.testAnswers = testAnswers;
	}

	public Tests getTestID() {
	return testID;
    }
	
    public void setTestID(Tests testID) {
	this.testID = testID;
    }

    public Long getQuestionID() {
	return questionID;
    }

    public void setQuestionID(Long questionID) {
	this.questionID = questionID;
    }

    public String getQuestion() {
	return question;
    }

    public void setQuestion(String question) {
	this.question = question;
    }



}
