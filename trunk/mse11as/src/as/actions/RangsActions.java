package as.actions;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import as.entities.Rank;
import as.entities.Role;
import as.services.GlobalService;

@ManagedBean(name = "rangActions")
@SessionScoped
public class RangsActions {
	@EJB
	private GlobalService globalService;
	
	private String status = new String();
	
	private Rank rank = new Rank();
	
	ArrayList<Role> mRole = new ArrayList<Role>();
	
	 @PostConstruct
     public void init() {
		 this.gimmiRoles();
		 System.out.println(mRole.size());
	 }
	
	public void gimmiRoles(){
		this.mRole = globalService.allRoles();
	}

	public ArrayList<Role> getmRole() {
		return mRole;
	}

	public void setmRole(ArrayList<Role> mRole) {
		this.mRole = mRole;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Rank getRank() {
		return rank;
	}

	public void setRank(Rank rank) {
		this.rank = rank;
	}
	
	public void save(Rank rA , String g){
		Role tempRole = this.globalService.findRole(g);
		rA.setRole(tempRole);
		this.globalService.save(rA);
	}
	
}
