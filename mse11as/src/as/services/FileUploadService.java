/**
 * 
 */
package as.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * @author Stefan Stefanov
 * @dFeb 25, 2012
 */
// @Stateful
@Stateless
public class FileUploadService {
    // @PersistenceContext(type = PersistenceContextType.EXTENDED)
    @PersistenceContext
    private EntityManager em;

    public <E> E Save(E file) {
	return em.merge(file);
    }

}
