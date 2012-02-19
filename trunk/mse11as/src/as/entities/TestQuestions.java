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
public class TestQuestions extends as.entities.Entity implements Serializable {

    @ManyToOne
    private Tests testID;

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer questionID;

    @Column(columnDefinition = "Varchar(250)")
    private String question;

    @Column(columnDefinition = "Integer")
    private Integer correctAnswer;

    public Tests getTestID() {
	return testID;
    }

    public void setTestID(Tests testID) {
	this.testID = testID;
    }

    public Integer getQuestionID() {
	return questionID;
    }

    public void setQuestionID(Integer questionID) {
	this.questionID = questionID;
    }

    public String getQuestion() {
	return question;
    }

    public void setQuestion(String question) {
	this.question = question;
    }

    public Integer getCorrectAnswer() {
	return correctAnswer;
    }

    public void setCorrectAnswer(Integer correctAnswer) {
	this.correctAnswer = correctAnswer;
    }

}
