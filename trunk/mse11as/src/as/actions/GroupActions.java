package as.actions;

import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import as.entities.Group;
import as.entities.Tests;
import as.services.GroupOperationService;
import as.services.TestsService;

@ManagedBean(name = "groupActions")
@SessionScoped
public class GroupActions {
	
	private Group currentGroup = new Group();
	private ArrayList<Group> allGroups = new ArrayList<Group>();
	
	@EJB
	private GroupOperationService groupService;
	
	public Group getCurrentGroup() {
		return currentGroup;
	}

	public void setCurrentGroup(Group currentGroup) {
		this.currentGroup = currentGroup;
	}
	
	public String save(Group g){
		groupService.save(g);
		return "GroupComplete";
	}
	
	public ArrayList<Group> getAvailableGroups(){
		this.allGroups = groupService.getAllGroups();
		return  this.allGroups;
	}
	public String deleteGroup (Group selectedGroup){
		this.groupService.remove(selectedGroup);
		return "GroupDeleted";
	}
	
	public String editGroup(Group selectedGroup){
		this.currentGroup  = this.groupService.extract(selectedGroup.getGroupID());
		return "GroupForEdit";
	}
	
	
}
