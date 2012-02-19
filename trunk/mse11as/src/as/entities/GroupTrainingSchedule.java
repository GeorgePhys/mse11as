package as.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 */

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class GroupTrainingSchedule extends as.entities.Entity implements
	Serializable {
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private Group groupID;

    @ManyToOne
    private Trainings trainingID;

    public Group getGroupID() {
	return groupID;
    }

    public void setGroupID(Group groupID) {
	this.groupID = groupID;
    }

    public Trainings getTrainingID() {
	return trainingID;
    }

    public void setTrainingID(Trainings trainingID) {
	this.trainingID = trainingID;
    }

    public Date getbDate() {
	return bDate;
    }

    public void setbDate(Date bDate) {
	this.bDate = bDate;
    }

    public Date geteDate() {
	return eDate;
    }

    public void seteDate(Date eDate) {
	this.eDate = eDate;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date bDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eDate;
}
