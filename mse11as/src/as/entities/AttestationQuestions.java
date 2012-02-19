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
public class AttestationQuestions extends as.entities.Entity implements
	Serializable {
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionID;

    @ManyToOne
    private Attestation attestationID;

    public Integer getQuestionID() {
	return questionID;
    }

    public void setQuestionID(Integer questionID) {
	this.questionID = questionID;
    }

    public Attestation getAttestationID() {
	return attestationID;
    }

    public void setAttestationID(Attestation attestationID) {
	this.attestationID = attestationID;
    }

    public String getQuestion() {
	return question;
    }

    public void setQuestion(String question) {
	this.question = question;
    }

    @Column(columnDefinition = "Varchar(250)")
    private String question;
}
