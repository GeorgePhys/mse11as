/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class UserAssignedTests extends as.entities.Entity implements
	Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    private User userID;

    @ManyToOne
    private Tests testID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date assignedDate;

    private Boolean solved;

    @Temporal(TemporalType.TIMESTAMP)
    private Date solveDate;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean checked;

    @Temporal(TemporalType.TIMESTAMP)
    private Date checkDate;

    @Column(columnDefinition = "Integer")
    private Integer Assessment;

    @Column(columnDefinition = "BOOLEAN")
    private Boolean passedThrough;

}
