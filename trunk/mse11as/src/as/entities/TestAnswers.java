/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class TestAnswers extends as.entities.Entity implements Serializable {
	
	

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer answerID;

    
    @Column(columnDefinition = "tinyint(0)")
    private Boolean answerVal;
    
    
    public Boolean getAnswerVal() {
		return answerVal;
	}

	public void setAnswerVal(Boolean answerVal) {
		this.answerVal = answerVal;
	}
	

	@ManyToOne
	private TestQuestions testQuestions;
	
	public TestQuestions getTestQuestions() {
		return testQuestions;
	}

	public void setTestQuestions(TestQuestions testQuestions) {
		this.testQuestions = testQuestions;
	}

	public Integer getAnswerID() {
	return answerID;
    }
    
    public void setAnswerID(Integer answerID) {
	this.answerID = answerID;
    }

    public String getAnswer() {
	return answer;
    }

    public void setAnswer(String answer) {
	this.answer = answer;
    }

    @Column(columnDefinition = "Varchar(250)")
    private String answer;
}
