package as.actions;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import as.entities.Group;
import as.services.TestsService;

@ManagedBean(name = "groupActions")
@SessionScoped
public class GroupActions {
	
	private Group currentGroup = new Group();
	@EJB
	private TestsService ts;
	
	public Group getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(Group currentGroup) {
		this.currentGroup = currentGroup;
	}
	
	public String save(Group g){
		
		ts.save(g);
		return "GroupComplete";
	}
	
	
}
