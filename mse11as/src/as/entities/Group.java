/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stefan Stefanov
 * @dFeb 18, 2012
 */
@Entity
@Table(name = "Groups")
public class Group extends as.entities.Entity implements Serializable {


    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer groupID;


    @Column(columnDefinition = "Varchar(50)")
    private String groupName;

    @Column(columnDefinition = "Varchar(250)")
    private String description;
    
    @OneToOne(cascade = { CascadeType.ALL })
    private GroupPrivileges groupPrivileges = new GroupPrivileges();
    
    Date currentDate = new Date();
    
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

	public GroupPrivileges getGroupPrivileges() {
		return groupPrivileges;
	}

	public void setGroupPrivileges(GroupPrivileges groupPrivileges) {
		this.groupPrivileges = groupPrivileges;
	}
	
	@Temporal(TemporalType.TIME)
	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
	}
    

}
