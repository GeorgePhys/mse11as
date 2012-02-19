/**
 * 
 */
package as.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class AttestationResults extends as.entities.Entity implements
	Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @OneToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "attAssignmentID", nullable = false)
    private AssignedAttestations attAssignmentID;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    @Column(columnDefinition = "Integer")
    private Integer questionID;

    public AssignedAttestations getAttAssignmentID() {
	return attAssignmentID;
    }

    public void setAttAssignmentID(AssignedAttestations attAssignmentID) {
	this.attAssignmentID = attAssignmentID;
    }

    public Integer getQuestionID() {
	return questionID;
    }

    public void setQuestionID(Integer questionID) {
	this.questionID = questionID;
    }

    public Double getAssessment() {
	return assessment;
    }

    public void setAssessment(Double assessment) {
	this.assessment = assessment;
    }

    private Double assessment;

}
