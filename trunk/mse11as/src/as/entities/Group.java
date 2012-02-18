/**
 * 
 */
package as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Stefan Stefanov
 * @dFeb 18, 2012
 */
@Entity
public class Group extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer groupID;

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

    public User getUserID() {
	return userID;
    }

    public void setUserID(User userID) {
	this.userID = userID;
    }

    @Column(columnDefinition = "Varchar(50)")
    private String groupName;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

    @ManyToOne
    private User userID;
}
