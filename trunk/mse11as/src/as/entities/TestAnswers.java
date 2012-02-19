/**
 * 
 */
package as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class TestAnswers extends as.entities.Entity implements Serializable {

    @ManyToOne
    private Tests testID;

    @ManyToOne
    private TestQuestions questionID;

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer answerID;

    public Tests getTestID() {
	return testID;
    }

    public void setTestID(Tests testID) {
	this.testID = testID;
    }

    public TestQuestions getQuestionID() {
	return questionID;
    }

    public void setQuestionID(TestQuestions questionID) {
	this.questionID = questionID;
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
