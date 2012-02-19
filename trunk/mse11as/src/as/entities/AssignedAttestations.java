/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class AssignedAttestations extends as.entities.Entity implements
	Serializable {
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attAssignmentID;

    @ManyToOne
    private User userID;

    @ManyToOne
    private Attestation attestationID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedDate;

    public Integer getAttAssignmentID() {
	return attAssignmentID;
    }

    public void setAttAssignmentID(Integer attAssignmentID) {
	this.attAssignmentID = attAssignmentID;
    }

    public User getUserID() {
	return userID;
    }

    public void setUserID(User userID) {
	this.userID = userID;
    }

    public Attestation getAttestationID() {
	return attestationID;
    }

    public void setAttestationID(Attestation attestationID) {
	this.attestationID = attestationID;
    }

    public Date getAssignedDate() {
	return assignedDate;
    }

    public void setAssignedDate(Date assignedDate) {
	this.assignedDate = assignedDate;
    }

    public Boolean getCompleted() {
	return completed;
    }

    public void setCompleted(Boolean completed) {
	this.completed = completed;
    }

    public Date getCompleteDate() {
	return completeDate;
    }

    public void setCompleteDate(Date completeDate) {
	this.completeDate = completeDate;
    }

    public Integer getNumAttUsers() {
	return numAttUsers;
    }

    public void setNumAttUsers(Integer numAttUsers) {
	this.numAttUsers = numAttUsers;
    }

    public Set<AssignedAttAnswers> getAssignedAttAnswers() {
	return AssignedAttAnswers;
    }

    public void setAssignedAttAnswers(Set<AssignedAttAnswers> assignedAttAnswers) {
	AssignedAttAnswers = assignedAttAnswers;
    }

    @Column(columnDefinition = "Boolean")
    private Boolean completed;

    @Temporal(TemporalType.TIMESTAMP)
    private Date completeDate;

    @Column(columnDefinition = "Integer")
    private Integer numAttUsers;

    @OneToMany(mappedBy = "attAssignmentID")
    private Set<AssignedAttAnswers> AssignedAttAnswers;

}
