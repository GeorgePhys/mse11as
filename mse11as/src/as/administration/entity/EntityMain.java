package as.administration.entity;

import java.awt.List;

public interface EntityMain {
	  public void persist (Administration todo);
	  public void delete (Administration todo);
	  public void update (Administration todo);
	  public List findTodos ();
	  public Administration findTodo (String id);
}
