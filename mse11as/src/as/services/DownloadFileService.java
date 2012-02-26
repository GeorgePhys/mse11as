/**
 * 
 */
package as.services;

import java.io.IOException;
import java.util.ArrayList;

import javax.ejb.Stateless;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import as.entities.File;

/**
 * @author Stefan Stefanov
 * @dFeb 26, 2012
 */
@Stateless
public class DownloadFileService {
    @PersistenceContext
    private EntityManager em;

    public ArrayList<File> GetAllFiles() {
	ArrayList<File> listFiles = (ArrayList) em.createQuery(
		"SELECT f FROM File f").getResultList();
	return listFiles;
    }

    public ArrayList<File> Search(String str) {
	System.out.println(str + "AAAAA");
	ArrayList<File> listFiles = (ArrayList) em
		.createQuery(
			"SELECT f FROM File f WHERE f.id LIKE '%:id%' OR f.Name LIKE '%:name%'",
			File.class).setParameter("id", str)
		.setParameter("name", str).getResultList();
	return listFiles;
    }

    public void Download(File file) {
	FacesContext facesContext = FacesContext.getCurrentInstance();
	ExternalContext externalContext = facesContext.getExternalContext();
	// externalContext
	// .setResponseHeader("Content-Type", file.getContentType());
	externalContext.setResponseHeader("Content-Length",
		file.getData().length + "");
	externalContext.setResponseHeader("Content-Disposition",
		"attachment;filename=\"" + file.getName() + "\"");
	try {
	    externalContext.getResponseOutputStream().write(file.getData());
	} catch (IOException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	facesContext.responseComplete();
    }

    public void Delete(File file) {
	em.remove(em.merge(file));
    }
}
