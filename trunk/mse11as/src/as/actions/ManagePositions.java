package as.actions;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

import as.entities.Role;
import as.services.GlobalService;

@ManagedBean(name = "personPosition")
@RequestScoped
public class ManagePositions {
	
	@EJB
	private GlobalService globalService;
	
	private Role currentRole = new Role();
	
	
	private ArrayList<Role> availableRoles = new ArrayList<Role>();


	public Role getCurrentRole() {
		return currentRole;
	}

	public void setCurrentRole(Role currentRole) {
		this.currentRole = currentRole;
	}

	public ArrayList<Role> getAvailableRoles() {
		return availableRoles;
	}

	public void setAvailableRoles(ArrayList<Role> availableRoles) {
		this.availableRoles = availableRoles;
	}

	public <E> String save(E entity){
		this.globalService.save(entity);
		HttpSession session = (HttpSession) FacesContext.getCurrentInstance()
				.getExternalContext().getSession(true);
		session.removeAttribute("personPosition");
		return "RoleDone";
	}


}
