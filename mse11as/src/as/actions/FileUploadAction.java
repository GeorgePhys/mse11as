/**
 * 
 */
package as.actions;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import org.richfaces.event.FileUploadEvent;
import org.richfaces.model.UploadedFile;

import as.entities.File;
import as.services.DownloadFileService;
import as.services.UploadFileService;

/**
 * @author Stefan Stefanov
 * @dFeb 25, 2012
 */
@ManagedBean
@SessionScoped
public class FileUploadAction implements Serializable {
    private ArrayList<File> files = new ArrayList<File>();

    @EJB
    private UploadFileService service;
    @EJB
    private DownloadFileService download;

    public void paint(OutputStream stream, Object object) throws IOException {
	stream.write(getFiles().get((Integer) object).getData());
	stream.close();
    }

    public void listener(FileUploadEvent event) throws Exception {
	UploadedFile item = event.getUploadedFile();
	File file = new File();
	file.setLength(item.getData().length);
	file.setName(item.getName());
	file.setData(item.getData());
	file = service.Save(file);
	files.add(file);
    }

    public String clearUploadData() {
	service.Clear(files);
	files.clear();
	return null;
    }

    public int getSize() {
	if (getFiles().size() > 0) {
	    return getFiles().size();
	} else {
	    return 0;
	}
    }

    public long getTimeStamp() {
	return System.currentTimeMillis();
    }

    public ArrayList<File> getFiles() {
	return files;
    }

    public void setFiles(ArrayList<File> files) {
	this.files = files;
    }

    public void Remove(File file) {
	files.remove(file);
	service.Remove(file);
    }

    public void Download(File file) {
	download.Download(file);
    }
}
