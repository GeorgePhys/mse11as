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
import javax.persistence.Table;

/**
 * @author Stefan Stefanov
 * @dFeb 18, 2012
 */
@Entity
@Table(name = "Groups")
public class Group extends as.entities.Entity implements Serializable {

    public Set<GroupTrainingSchedule> getGroupTrainingSchedule() {
	return groupTrainingSchedule;
    }

    public void setGroupTrainingSchedule(
	    Set<GroupTrainingSchedule> groupTrainingSchedule) {
	this.groupTrainingSchedule = groupTrainingSchedule;
    }

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer groupID;

    @OneToMany(mappedBy = "groupID")
    private Set<GroupTrainingSchedule> groupTrainingSchedule;

    public Integer getGroupID() {
	return groupID;
    }

    public void setGroupID(Integer groupID) {
	this.groupID = groupID;
    }

    public String getGroupName() {
	return groupName;
    }

    public void setGroupName(String groupName) {
	this.groupName = groupName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    @Column(columnDefinition = "Varchar(50)")
    private String groupName;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

}
