/**
 * 
 */
package as.actions;


import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import as.entities.File;
import as.entities.User;

import as.services.DownloadFileService;
import as.services.SearchUsersSolvedTestsService;

/**
 * @author nataliya
 *
 * @Mar 27, 2012
 */
@ManagedBean
@SessionScoped
public class SearchUsersSolvedTestsAction implements Serializable {
	private ArrayList<User> users = new ArrayList<User>();

	@EJB
	private SearchUsersSolvedTestsService service;

	
	public ArrayList<User> getUsers() {
		return users;
	}
    
	private String usersType = new String();
    private String searchWord = new String();
    
	@PostConstruct
	public void init() {
		users = service.GetAllUsers();
	}
    
    public void setUsers(ArrayList<User> users) {
    	this.users = users;
    }

    /**
	 * @return the searchWord
	 */
	public String getSearchWord() {
		return searchWord;
	}

	/**
	 * @param searchWord the searchWord to set
	 */
	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}


    /**
	 * @return the usersType
	 */
	public String getUsersType() {
		return usersType;
	}

	/**
	 * @param usersType the usersType to set
	 */
	public void setUsersType(String usersType) {
		this.usersType = usersType;
	}

	public void search(String word) {
    	this.searchWord = word;
    	if (searchWord == null) {
			users = service.GetAllUsers();
		}else{
			users = service.search(searchWord, this.usersType);
		}
    	System.out.println("1 "+usersType);
		
    }

    public int getSize() {
    	return users.size();
    }
}
