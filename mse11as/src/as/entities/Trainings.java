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
public class Trainings extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer trainingID;

    @Column(columnDefinition = "Varchar(150)")
    private String training;

    @OneToMany(mappedBy = "trainingID")
    private Set<PersonalTrainingSchedule> personalTrainingSchedule;

    @OneToMany(mappedBy = "trainingID")
    private Set<GroupTrainingSchedule> groupTrainingSchedule;

    public Integer getTrainingID() {
	return trainingID;
    }

    public void setTrainingID(Integer trainingID) {
	this.trainingID = trainingID;
    }

    public String getTraining() {
	return training;
    }

    public void setTraining(String training) {
	this.training = training;
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
