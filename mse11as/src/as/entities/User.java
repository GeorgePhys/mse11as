/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Stefan Stefanov
 * @dFeb 18, 2012
 */
@Entity
public class User extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer userID;

    @Column(columnDefinition = "Varchar(100)")
    private String firstName;

    @Column(columnDefinition = "Varchar(100)")
    private String lastName;

    @Column(columnDefinition = "Decimal")
    private BigDecimal egn;

    @Column(columnDefinition = "Varchar(150)")
    private String address;

    @Column(columnDefinition = "Varchar(50)")
    private String phone;

    public Integer getUserID() {
	return userID;
    }

    public void setUserID(Integer userID) {
	this.userID = userID;
    }

    public String getFirstName() {
	return firstName;
    }

    public void setFirstName(String firstName) {
	this.firstName = firstName;
    }

    public String getLastName() {
	return lastName;
    }

    public void setLastName(String lastName) {
	this.lastName = lastName;
    }

    public BigDecimal getEgn() {
	return egn;
    }

    public void setEgn(BigDecimal egn) {
	this.egn = egn;
    }

    public String getAddress() {
	return address;
    }

    public void setAddress(String address) {
	this.address = address;
    }

    public String getPhone() {
	return phone;
    }

    public void setPhone(String phone) {
	this.phone = phone;
    }

    public String getEmail() {
	return email;
    }

    public void setEmail(String email) {
	this.email = email;
    }

    public Set<Group> getGroups() {
	return groups;
    }

    public void setGroups(Set<Group> groups) {
	this.groups = groups;
    }

    public Set<UserProfile> getProfiles() {
	return profiles;
    }

    public void setProfiles(Set<UserProfile> profiles) {
	this.profiles = profiles;
    }

    @Column(columnDefinition = "Varchar(100)")
    private String email;

    @OneToMany(mappedBy = "userID")
    private Set<Group> groups;

    @OneToMany(mappedBy = "userID")
    private Set<UserProfile> profiles;

}
