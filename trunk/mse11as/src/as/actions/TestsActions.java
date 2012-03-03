package as.actions;

import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import as.entities.Tests;
import as.services.TestsService;

@ManagedBean(name = "t")
@SessionScoped
public class TestsActions implements Serializable {

	private static final long serialVersionUID = 1L;

	public Tests test = new Tests();

	@EJB
	private TestsService ts;

	public Tests getTest() {
		return test;
	}

	public void setTest(Tests test) {
		this.test = test;
	}

	public String save(Tests test) {
		return "do";
	}

	public TestsService getTs() {
		return ts;
	}

	public void setTs(TestsService ts) {
		this.ts = ts;
	}

}
