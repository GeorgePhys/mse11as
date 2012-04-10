package as.services;

import java.util.ArrayList;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import as.entities.Group;
import as.entities.Tests;

@Stateful
public class GroupOperationService {
    
	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public <E> E save(E entity) {
		return em.merge(entity);
	}

	public <E> void remove(E e) {
		em.remove(e);
	}

	public void update(Group todo) {
		em.merge(todo);
	}
	
    @SuppressWarnings("unchecked")
	public ArrayList<Group> getAllGroups() {
		ArrayList<Group> listGroups = (ArrayList<Group>) em.createQuery(
			"SELECT g FROM Group g").getResultList();
		return listGroups;
    }
    
    public Group extract(int id) {
    	return (Group) em.find(Group.class,id);
    }

}
