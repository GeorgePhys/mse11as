/**
 * 
 */
package as.services;

import java.util.ArrayList;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import as.entities.File;

/**
 * @author Stefan Stefanov
 * @dFeb 25, 2012
 */
@Stateful
// @Stateless
public class FileUploadService {
    @PersistenceContext(type = PersistenceContextType.EXTENDED)
    // @PersistenceContext
    private EntityManager em;

    public <E> E Save(E entity) {
	return em.merge(entity);
    }

    public void Clear(ArrayList<File> list) {
	for (File f : list) {
	    em.remove(f);
	}
    }

    public void Remove(File file) {
	em.remove(file);
    }

}
