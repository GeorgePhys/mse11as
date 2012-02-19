/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class Tests extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer testID;

    @Column(columnDefinition = "Varchar(150)")
    private String testName;

    @OneToMany(mappedBy = "testID")
    private Set<TestQuestions> testQuestions;

    @OneToMany(mappedBy = "testID")
    private Set<UserAssignedTests> userAssignedTests;

    public Set<TestQuestions> getTestQuestions() {
	return testQuestions;
    }

    public void setTestQuestions(Set<TestQuestions> testQuestions) {
	this.testQuestions = testQuestions;
    }

    public Set<TestAnswers> getTestAnswers() {
	return testAnswers;
    }

    public void setTestAnswers(Set<TestAnswers> testAnswers) {
	this.testAnswers = testAnswers;
    }

    @OneToMany(mappedBy = "testID")
    private Set<TestAnswers> testAnswers;

    public Integer getTestID() {
	return testID;
    }

    public void setTestID(Integer testID) {
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

    @Column(columnDefinition = "Varchar(250)")
    private String description;

}
