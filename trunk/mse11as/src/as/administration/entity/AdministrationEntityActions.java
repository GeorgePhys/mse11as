package as.administration.entity;

import java.awt.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class AdministrationEntityActions implements EntityMain {

	@PersistenceContext
	private EntityManager em;

	@Override
	public void persist(Administration a) {
		em.persist(a);
	}

	@Override
	public void delete(Administration a) {
		Administration t = em.merge(a);
		em.remove(t);

	}
	@Override
	public void update(Administration a) {
		em.merge(a);

	}

	@Override
	public List findTodos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Administration findTodo(String id) {
		// TODO Auto-generated method stub
		return null;
	}


}
