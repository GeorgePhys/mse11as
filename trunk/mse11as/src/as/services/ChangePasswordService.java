package as.services;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import as.entities.User;

@Stateless
public class ChangePasswordService {
    
	@PersistenceContext
    private EntityManager em;
    
	public <E> E save(E entity) {
		return em.merge(entity);
	}
	
	public User findUser(String id) {
		return (User) em.find(User.class, Integer.parseInt(id));
	}
}
