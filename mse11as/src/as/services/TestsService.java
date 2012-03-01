package as.services;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;

import as.entities.File;
import as.entities.Tests;

@Stateful
public class TestsService {

	@PersistenceContext(type = PersistenceContextType.EXTENDED)
	private EntityManager em;

	public <E> E save(E entity) {
		return em.merge(entity);
	}

	public <E> void remove(E e) {
		em.remove(e);
	}

	public void update(Tests todo) {
		em.merge(todo);
	}

	@SuppressWarnings("unchecked")
	public ArrayList<Tests> findTests() {
		return (ArrayList<Tests>) em.createQuery("select * from tests").getResultList();
	}

	public Tests findTest(String id) {
		return (Tests) em.find(Tests.class, Long.parseLong(id));
	}
}
