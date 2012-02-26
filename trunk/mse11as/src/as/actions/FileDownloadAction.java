/**
 * 
 */
package as.actions;

import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import as.entities.File;
import as.services.DownloadFileService;

/**
 * @author Stefan Stefanov
 * @dFeb 26, 2012
 */
@ManagedBean
@SessionScoped
public class FileDownloadAction implements Serializable {

    private ArrayList<File> files = new ArrayList<File>();

    @EJB
    private DownloadFileService service;

    public ArrayList<File> getFiles() {
	files = service.GetAllFiles();
	return files;
    }

    public void setFiles(ArrayList<File> files) {
	this.files = files;
    }

    public void Download(File file) {
	service.Download(file);
    }

    public void Delete(File file) {
	service.Delete(file);
	files.remove(file);
    }
}
