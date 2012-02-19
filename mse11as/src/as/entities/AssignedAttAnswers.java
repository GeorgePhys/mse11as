/**
 * 
 */
package as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class AssignedAttAnswers extends as.entities.Entity implements
	Serializable {
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private AssignedAttestations attAssignmentID;

    @Column(columnDefinition = "Integer")
    private Integer questionID;

    @Column(columnDefinition = "Integer")
    private Integer userToPerfAttestation;

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

    public Integer getUserToPerfAttestation() {
	return userToPerfAttestation;
    }

    public void setUserToPerfAttestation(Integer userToPerfAttestation) {
	this.userToPerfAttestation = userToPerfAttestation;
    }

    public Integer getAnswer() {
	return answer;
    }

    public void setAnswer(Integer answer) {
	this.answer = answer;
    }

    @Column(columnDefinition = "Integer")
    private Integer answer;

}
