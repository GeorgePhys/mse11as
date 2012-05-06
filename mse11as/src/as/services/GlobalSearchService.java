package as.services;

import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import as.entities.Group;
import as.entities.Rank;
import as.entities.Role;
import as.entities.User;

@Stateless
public class GlobalSearchService {
	@PersistenceContext
	private EntityManager em;

	public ArrayList<Role> findRole(String str) {
		ArrayList<Role> listRoles = (ArrayList<Role>) em.createQuery(
				"SELECT r FROM Role r WHERE r.roleName LIKE '%" + str + "%'",Role.class).getResultList();
		return listRoles;
	}
	public ArrayList<Group> findGroup(String str) {
		ArrayList<Group> listGroups = (ArrayList<Group>) em.createQuery(
				"SELECT g FROM Group g WHERE g.groupName LIKE '%" + str + "%'",Group.class).getResultList();
		return listGroups;
	}
	public ArrayList<Rank> findRank(String str) {
		ArrayList<Rank> listRanks = (ArrayList<Rank>) em.createQuery(
				"SELECT rk FROM Rank rk WHERE rk.rankName LIKE '%" + str + "%'",Rank.class).getResultList();
		return listRanks;
	}
	public ArrayList<User> findUser(String str) {
		ArrayList<User> listGroups = (ArrayList<User>) em.createQuery(
				"SELECT u FROM User u WHERE u.firstName LIKE '%" + str + "%'",User.class).getResultList();
		return listGroups;
	}
}
