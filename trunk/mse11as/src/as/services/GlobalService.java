package as.services;

import java.util.ArrayList;

import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import as.entities.Role;
import as.entities.Tests;


@Stateless
public class GlobalService {
    @PersistenceContext
    private EntityManager em;

	public <E> E save(E entity) {
		return em.merge(entity);
	}

	public <E> void remove(E e) {
		em.remove(e);
	}

	public <E> void update(E todo) {
		em.merge(todo);
	}
	
	public ArrayList<Role> allRoles() {
			ArrayList<Role> om = (ArrayList) em.createQuery(
				"SELECT r FROM Role r").getResultList();
			return om;
    }
	public Role findRole(String id) {
		return (Role) em.find(Role.class, Integer.parseInt(id));
	}
}
