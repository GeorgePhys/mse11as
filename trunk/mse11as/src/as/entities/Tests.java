/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class Tests extends as.entities.Entity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long testID;

    @Column(columnDefinition = "Varchar(150)")
    private String testName;
    
    @Column(columnDefinition = "Varchar(150)")
    private String description;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "testID")
    private Set<TestQuestions> testQuestions;

    @Column(columnDefinition = "Integer")
    private int numQuestions;
    
    @Column(columnDefinition = "Integer")
    private int numAnswPerQuestion;
    
    @Column(columnDefinition = "Integer")
    private int pointSystem;
    
    @Column(columnDefinition = "Integer")
    private int level;
    
    @Column(columnDefinition = "Integer")
    private int showResult;
    
    public int getShowResult() {
		return showResult;
	}

	public void setShowResult(int showResult) {
		this.showResult = showResult;
	}

	@Column(columnDefinition = "Varchar(150)")
    private String msg;
    
    
    public Set<TestQuestions> getTestQuestions() {
	return testQuestions;
    }

    public void setTestQuestions(Set<TestQuestions> testQuestions) {
	this.testQuestions = testQuestions;
    }

    public int getNumQuestions() {
		return numQuestions;
	}

	public void setNumQuestions(int numQuestions) {
		this.numQuestions = numQuestions;
	}

	public int getNumAnswPerQuestion() {
		return numAnswPerQuestion;
	}

	public void setNumAnswPerQuestion(int numAnswPerQuestion) {
		this.numAnswPerQuestion = numAnswPerQuestion;
	}

	public int getPointSystem() {
		return pointSystem;
	}

	public void setPointSystem(int pointSystem) {
		this.pointSystem = pointSystem;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

    public Long getTestID() {
	return testID;
    }

    public void setTestID2(Long testID) {
	this.testID = testID;
    }

    public String getTestName() {
	return testName;
    }

    public void setTestName(String testName) {
	this.testName = testName;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
	this.description = description;
    }
}
