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
    private Integer groupTrainingSchID;

    public Integer getGroupTrainingSchID() {
	return groupTrainingSchID;
    }

    public void setGroupTrainingSchID(Integer groupTrainingSchID) {
	this.groupTrainingSchID = groupTrainingSchID;
    }

    @ManyToOne
    private Group groupID;

    public Group getGroupID() {
	return groupID;
    }

    public void setGroupID(Group groupID) {
	this.groupID = groupID;
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

    @OneToMany(mappedBy = "groupID")
    private Set<Trainings> trainings;

    public Set<Trainings> getTrainings() {
	return trainings;
    }

    public void setTrainings(Set<Trainings> trainings) {
	this.trainings = trainings;
    }

    @Temporal(TemporalType.TIMESTAMP)
    private Date bDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eDate;
}
