package as.actions;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import as.entities.User;
import as.services.ChangePasswordService;

@ManagedBean(name = "changePass")
@RequestScoped
public class ChangePasswordAction implements Serializable{
	
	private String oldPass;
	private String pass;
	private String rePass;
	private User user = new User();
	
	//temporary user id (that is logged)
	private final String idTemp="1";
	
	@EJB
	private ChangePasswordService changePassService;

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRePass() {
		return rePass;
	}

	public void setRePass(String rePass) {
		this.rePass = rePass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public String getOldPass() {
		return oldPass;
	}

	public void setOldPass(String oldPass) {
		this.oldPass = oldPass;
	}

	public void change(String p1, String p2, String oldPass){
		user = changePassService.findUser(this.idTemp);
		if(p1.equalsIgnoreCase(p2) && oldPass.equalsIgnoreCase(user.getPassword())){
			user.setPassword(p1);
			changePassService.save(user);
			System.out.println("Correct");
		}else{
			System.out.println("incorect");
		}
		
	}
	
}
