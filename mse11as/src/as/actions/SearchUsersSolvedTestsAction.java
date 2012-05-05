/**
 * 
 */
package as.actions;


import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

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
	private Map<String,String>status = new HashMap<String,String>();
	@EJB
	private SearchUsersSolvedTestsService service;

	
	public ArrayList<User> getUsers() {
		return users;
	}
	
	private String usersType;
    private String searchWord;
    
	@PostConstruct
	public void init() {
		users = service.GetAllUsers();
		status.put("Номер", "n");
		status.put("Име", "i");
		status.put("Фамилия", "f");
		status.put("Имейл", "e");
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

	public void search(String word) throws UnsupportedEncodingException {
    	this.searchWord = word;
    	if (searchWord == null) {
			users = service.GetAllUsers();
		}else{
			users = service.search(searchWord, this.usersType);
			searchWord = "";
		}
    }

    public int getSize() {
    	return users.size();
    }

	public Map<String, String> getStatus() {
		return status;
	}

	public void setStatus(Map<String, String> status) {
		this.status = status;
	}
    
}
