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
 * @param <T>
 * @dFeb 26, 2012
 */
@ManagedBean
@SessionScoped
public class MaterialsSearchAction<T> implements Serializable {
    private ArrayList<File> materials = new ArrayList<File>();
    private String materialsType;
    private String serachWord;

    public ArrayList<File> getMaterials() {
	return materials;
    }

    public String getSerachWord() {
	return serachWord;
    }

    public void setSerachWord(String serachWord) {
	this.serachWord = serachWord;
    }

    public void setMaterials(ArrayList<File> materials) {
	this.materials = materials;
    }

    public String getMaterialsType() {
	if (materialsType == null)
	    materialsType = "Материали";
	return materialsType;
    }

    public void setMaterialsType(String materialsType) {
	this.materialsType = materialsType;
    }

    @EJB
    private DownloadFileService service;

    public void Search() {
	if (materialsType == "Материали") {
	    materials = service.Search(serachWord);
	} else {
	    // TO DO
	}

    }

    public int getSize() {
	return materials.size();
    }

}
