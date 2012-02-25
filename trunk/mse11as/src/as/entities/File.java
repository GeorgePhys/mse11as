/**
 * 
 */
package as.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Stefan Stefanov
 * @dFeb 25, 2012
 */
@Entity
public class File extends as.entities.Entity implements Serializable {
    @Id
    @Column(columnDefinition = "Integer", unique = true)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String Name;

    public Integer getId() {
	return id;
    }

    public void setId(Integer id) {
	this.id = id;
    }

    public String getName() {
	return Name;
    }

    public void setName(String name) {
	Name = name;
    }

    public String getMime() {
	return mime;
    }

    public void setMime(String mime) {
	this.mime = mime;
    }

    public long getLength() {
	return length;
    }

    public void setLength(long length) {
	this.length = length;
    }

    public byte[] getData() {
	return data;
    }

    public void setData(byte[] data) {
	this.data = data;
    }

    @Column
    private String mime;
    @Column
    private long length;
    @Column(columnDefinition = "BLOB")
    private byte[] data;
}
