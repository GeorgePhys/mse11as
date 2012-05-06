package as.actions;

import java.util.ArrayList;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import as.entities.Group;
import as.entities.Rank;
import as.entities.Role;
import as.entities.User;
import as.services.GlobalSearchService;

@ManagedBean(name = "globalSearch")
@SessionScoped
public class GlobalSearchAction {
	
	private String searchWord;
	private Boolean roleCritery,rankCritery,groupCritery,userCritery;
	private ArrayList<Role> r;
	private ArrayList<Group> g;
	private ArrayList<Rank> rk;
	private ArrayList<User> u;
	
	
	@PostConstruct
	public void init() {

	}
	
	@EJB
	private GlobalSearchService globalSearchService;

	public Boolean getUserCritery() {
		return userCritery;
	}

	public void setUserCritery(Boolean userCritery) {
		this.userCritery = userCritery;
	}

	public Boolean getRoleCritery() {
		return roleCritery;
	}

	public void setRoleCritery(Boolean roleCritery) {
		this.roleCritery = roleCritery;
	}

	public Boolean getRankCritery() {
		return rankCritery;
	}

	public void setRankCritery(Boolean rankCritery) {
		this.rankCritery = rankCritery;
	}

	public Boolean getGroupCritery() {
		return groupCritery;
	}

	public void setGroupCritery(Boolean groupCritery) {
		this.groupCritery = groupCritery;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public ArrayList<Role> getR() {
		return r;
	}

	public void setR(ArrayList<Role> r) {
		this.r = r;
	}
	
	
	public ArrayList<Group> getG() {
		return g;
	}

	public void setG(ArrayList<Group> g) {
		this.g = g;
	}
	
	public ArrayList<Rank> getRk() {
		return rk;
	}

	public void setRk(ArrayList<Rank> rk) {
		this.rk = rk;
	}

	public ArrayList<User> getU() {
		return u;
	}

	public void setU(ArrayList<User> u) {
		this.u = u;
	}

	public String searchGlobal(String str){
		System.out.println(roleCritery);
		if(roleCritery){
			r = globalSearchService.findRole(str);
		}
		if(groupCritery){
			g = globalSearchService.findGroup(str);
		}
		if(rankCritery){
			rk = globalSearchService.findRank(str);
		}
		if(userCritery){
			u = globalSearchService.findUser(str);
		}
		return null;
	}
	
}
