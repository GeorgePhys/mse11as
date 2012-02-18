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
 * @dFeb 18, 2012
 */
@Entity
public class Role extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer roleID;

    public Integer getRoleID() {
	return roleID;
    }

    public void setRoleID(Integer roleID) {
	this.roleID = roleID;
    }

    public String getRoleName() {
	return roleName;
    }

    public void setRoleName(String roleName) {
	this.roleName = roleName;
    }

    public String getDescription() {
	return description;
    }

    public void setDescription(String description) {
	this.description = description;
    }

    public Set<UserProfile> getProfiles() {
	return profiles;
    }

    public void setProfiles(Set<UserProfile> profiles) {
	this.profiles = profiles;
    }

    @Column(columnDefinition = "Varchar(50)")
    private String roleName;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

    @OneToMany(mappedBy = "roleID")
    private Set<UserProfile> profiles;
}
