package as.actions;

import java.awt.List;
import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.model.DataModel;

import com.sun.xml.internal.ws.client.RequestContext;

import as.entities.File;
import as.entities.Tests;
import as.services.TestsService;

@ManagedBean(name="t")
@SessionScoped
public class TestsActions implements Serializable {
	
	public Tests test = new Tests();
	
	@EJB
	private  TestsService ts;

	public Tests getTest() {
		return test;
	}

	public void setTest(Tests test) {
		this.test = test;
	}

	public String save(Tests test){
		return "do";
	}

}
