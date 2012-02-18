package as.administration.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Administration implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 @Id
	 @Column(columnDefinition = "int(11)") 
	 private long id;
	
	  @Column(columnDefinition = "Varchar(100)")
	    private String titleIssue;

	public String getTitleIssue() {
		return titleIssue;
	}

	public void setTitleIssue(String titleIssue) {
		this.titleIssue = titleIssue;
	}
	  

}
