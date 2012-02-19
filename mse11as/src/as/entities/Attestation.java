/**
 * 
 */
package as.entities;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * @author Stefan Stefanov
 * @dFeb 19, 2012
 */
@Entity
public class Attestation extends as.entities.Entity implements Serializable {

    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer attestationID;

    @Column(columnDefinition = "Varchar(150)")
    private String attestationName;

    @Column(columnDefinition = "Varchar(250)")
    private String description;

    @OneToMany(mappedBy = "attestationID")
    private Set<AttestationQuestions> attestationQuestions;

    @OneToMany(mappedBy = "attestationID")
    private Set<AssignedAttestations> assignedAttestations;
}
