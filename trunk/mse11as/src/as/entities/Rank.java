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
public class Rank extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer rankID;

    public Integer getRankID() {
	return rankID;
    }

    public void setRankID(Integer rankID) {
	this.rankID = rankID;
    }

    public String getRankName() {
	return rankName;
    }

    public void setRankName(String rankName) {
	this.rankName = rankName;
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
    private String rankName;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

    @OneToMany(mappedBy = "rankID")
    private Set<UserProfile> profiles;
}
