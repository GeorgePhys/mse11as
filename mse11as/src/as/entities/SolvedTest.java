package as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class SolvedTest extends as.entities.Entity implements Serializable {

	@Id
	@Column(columnDefinition = "Integer", unique = true)
	@GeneratedValue
	private Integer solvedTestID;

	@Column(columnDefinition = "Integer")
	private Integer userID;

	@Column(columnDefinition = "Long")
	private Long testID;

	@Column(columnDefinition = "Long")
	private Long questionID;

	@Column(columnDefinition = "varchar(255)")
	private String answer;

	@Column(columnDefinition = "tinyint(0)")
	private Boolean answerVal;

	public Integer getSolvedTestID() {
		return solvedTestID;
	}

	public void setSolvedTestID(Integer solvedTestID) {
		this.solvedTestID = solvedTestID;
	}

	public Integer getUserID() {
		return userID;
	}

	public void setUserID(Integer userID) {
		this.userID = userID;
	}

	public Long getTestID() {
		return testID;
	}

	public void setTestID(Long long1) {
		this.testID = long1;
	}

	public Long getQuestionID() {
		return questionID;
	}

	public void setQuestionID(Long questionID) {
		this.questionID = questionID;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Boolean getAnswerVal() {
		return answerVal;
	}

	public void setAnswerVal(Boolean answerVal) {
		this.answerVal = answerVal;
	}

	
}
