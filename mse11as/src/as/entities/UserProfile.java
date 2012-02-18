/**
 * 
 */
package as.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * @author Stefan Stefanov
 * @dFeb 18, 2012
 */
@Entity
public class UserProfile extends as.entities.Entity implements Serializable {
    public User getUserID() {
	return userID;
    }

    public void setUserID(User userID) {
	this.userID = userID;
    }

    public Role getRoleID() {
	return roleID;
    }

    public void setRoleID(Role roleID) {
	this.roleID = roleID;
    }

    public Long getId() {
	return id;
    }

    public void setId(Long id) {
	this.id = id;
    }

    public Rank getRankID() {
	return rankID;
    }

    public void setRankID(Rank rankID) {
	this.rankID = rankID;
    }

    @ManyToOne
    private User userID;

    @ManyToOne
    private Role roleID;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    private Rank rankID;
}
