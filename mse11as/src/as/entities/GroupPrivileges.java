package as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "groupprivileges")
public class GroupPrivileges extends as.entities.Entity implements Serializable{
	
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue
    private Integer privilegueID;
    
    @Column(columnDefinition = "tinyint(0)")
    private Boolean administration;
    
    @Column(columnDefinition = "tinyint(0)")
    private Boolean testsmaterials;
    
    @Column(columnDefinition = "tinyint(0)")
    private Boolean charts;
    
    @Column(columnDefinition = "tinyint(0)")
    private Boolean plan;
    
    @Column(columnDefinition = "tinyint(0)")
    private Boolean atestation;
    
	public Integer getPrivilegueID() {
		return privilegueID;
	}

	public void setPrivilegueID(Integer privilegueID) {
		this.privilegueID = privilegueID;
	}

	public Boolean getAdministration() {
		return administration;
	}

	public void setAdministration(Boolean administration) {
		this.administration = administration;
	}

	public Boolean getTestsmaterials() {
		return testsmaterials;
	}

	public void setTestsmaterials(Boolean testsmaterials) {
		this.testsmaterials = testsmaterials;
	}

	public Boolean getCharts() {
		return charts;
	}

	public void setCharts(Boolean charts) {
		this.charts = charts;
	}

	public Boolean getPlan() {
		return plan;
	}

	public void setPlan(Boolean plan) {
		this.plan = plan;
	}

	public Boolean getAtestation() {
		return atestation;
	}

	public void setAtestation(Boolean atestation) {
		this.atestation = atestation;
	}

    
}
