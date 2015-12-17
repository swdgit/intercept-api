package com.protolounge.intercept.domain;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;


/**
 * The persistent class for the mvp_software database table.
 * 
 */
@Entity
@Table(name="mvp_software")
@NamedQuery(name="MVPSoftware.findAll", query="SELECT m FROM MVPSoftware m")
public class MVPSoftware implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mvp_software_id")
	private int mvpSoftwareId;

	private String title;

	private String url;

	private String version;

	//bi-directional many-to-one association to MVPPrintSpecification
	@OneToMany(mappedBy="mvpSoftware")
	@JsonManagedReference
	private List<MVPPrintSpecification> mvpPrintSpecifications;

	public MVPSoftware() {
	}

	public int getMvpSoftwareId() {
		return this.mvpSoftwareId;
	}

	public void setMvpSoftwareId(int mvpSoftwareId) {
		this.mvpSoftwareId = mvpSoftwareId;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getVersion() {
		return this.version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public List<MVPPrintSpecification> getMvpPrintSpecifications() {
		return this.mvpPrintSpecifications;
	}

	public void setMvpPrintSpecifications(List<MVPPrintSpecification> mvpPrintSpecifications) {
		this.mvpPrintSpecifications = mvpPrintSpecifications;
	}

	public MVPPrintSpecification addMvpPrintSpecification(MVPPrintSpecification mvpPrintSpecification) {
		getMvpPrintSpecifications().add(mvpPrintSpecification);
		mvpPrintSpecification.setMvpSoftware(this);

		return mvpPrintSpecification;
	}

	public MVPPrintSpecification removeMvpPrintSpecification(MVPPrintSpecification mvpPrintSpecification) {
		getMvpPrintSpecifications().remove(mvpPrintSpecification);
		mvpPrintSpecification.setMvpSoftware(null);

		return mvpPrintSpecification;
	}

}