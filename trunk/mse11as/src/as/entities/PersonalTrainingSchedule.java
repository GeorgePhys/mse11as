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
public class PersonalTrainingSchedule extends as.entities.Entity implements
	Serializable {
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer persTrainingSchID;

    @ManyToOne
    private User userID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date bDate;

    public Integer getPersTrainingSchID() {
	return persTrainingSchID;
    }

    public void setPersTrainingSchID(Integer persTrainingSchID) {
	this.persTrainingSchID = persTrainingSchID;
    }

    public User getUserID() {
	return userID;
    }

    public void setUserID(User userID) {
	this.userID = userID;
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

    public Set<Trainings> getTrainings() {
	return trainings;
    }

    public void setTrainings(Set<Trainings> trainings) {
	this.trainings = trainings;
    }

    @OneToMany(mappedBy = "personalID")
    private Set<Trainings> trainings;

    @Temporal(TemporalType.TIMESTAMP)
    private Date eDate;
}
