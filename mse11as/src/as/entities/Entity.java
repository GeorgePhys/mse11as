package as.entities;

import java.io.Serializable;

import javax.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Entity implements Serializable {

    private static final long serialVersionUID = 1L;
}
