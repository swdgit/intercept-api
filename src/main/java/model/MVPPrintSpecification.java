package model;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the mvp_print_specification database table.
 * 
 */
@Entity
@Table(name="mvp_print_specification")
@NamedQuery(name="MVPPrintSpecification.findAll", query="SELECT m FROM MVPPrintSpecification m")
public class MVPPrintSpecification implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mvp_print_specification_id")
	private int mvpPrintSpecificationId;

	private String notes;

	@Lob
	@Column(name="profile_file")
	private String profileFile;

	@Column(name="profile_file_url")
	private String profileFileUrl;

	@Column(name="submitter_name")
	private String submitterName;

	private String title;

	//bi-directional many-to-one association to MVPMaterial
	@ManyToOne
	@JoinColumn(name="mvp_material_id")
	private MVPMaterial mvpMaterial;

	//bi-directional many-to-one association to MVPPrinter
	@ManyToOne
	@JoinColumn(name="mvp_printer_id")
	private MVPPrinter mvpPrinter;

	//bi-directional many-to-one association to MVPSoftware
	@ManyToOne
	@JoinColumn(name="mvp_software_id")
	private MVPSoftware mvpSoftware;

	public MVPPrintSpecification() {
	}

	public int getMvpPrintSpecificationId() {
		return this.mvpPrintSpecificationId;
	}

	public void setMvpPrintSpecificationId(int mvpPrintSpecificationId) {
		this.mvpPrintSpecificationId = mvpPrintSpecificationId;
	}

	public String getNotes() {
		return this.notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
	}

	public String getProfileFile() {
		return this.profileFile;
	}

	public void setProfileFile(String profileFile) {
		this.profileFile = profileFile;
	}

	public String getProfileFileUrl() {
		return this.profileFileUrl;
	}

	public void setProfileFileUrl(String profileFileUrl) {
		this.profileFileUrl = profileFileUrl;
	}

	public String getSubmitterName() {
		return this.submitterName;
	}

	public void setSubmitterName(String submitterName) {
		this.submitterName = submitterName;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MVPMaterial getMvpMaterial() {
		return this.mvpMaterial;
	}

	public void setMvpMaterial(MVPMaterial mvpMaterial) {
		this.mvpMaterial = mvpMaterial;
	}

	public MVPPrinter getMvpPrinter() {
		return this.mvpPrinter;
	}

	public void setMvpPrinter(MVPPrinter mvpPrinter) {
		this.mvpPrinter = mvpPrinter;
	}

	public MVPSoftware getMvpSoftware() {
		return this.mvpSoftware;
	}

	public void setMvpSoftware(MVPSoftware mvpSoftware) {
		this.mvpSoftware = mvpSoftware;
	}

}