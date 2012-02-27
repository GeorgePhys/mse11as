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
public class MaterialsSearchAction implements Serializable {
    private ArrayList<File> materials = new ArrayList<File>();
    private String materialsType;
    private String serachWord;
    private String[] types = new String[] { "Тестове", "Материали" };

    // @PostConstruct
    // public void init() {
    // types.add(new SelectItem("Тестове"));
    // types.add(new SelectItem("Материали"));
    // }

    public String[] getTypes() {
	return types;
    }

    public void setTypes(String[] types) {
	this.types = types;
    }

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
	if (materialsType.equals("Материали")) {
	    materials = service.Search(serachWord);
	} else {
	    // TO DO for Natalia!!!!!!
	}
    }

    public int getSize() {
	return materials.size();
    }

}
