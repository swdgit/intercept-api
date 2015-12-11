package com.protolounge.intercept.domain;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the mvp_printer database table.
 * 
 */
@Entity
@Table(name="mvp_printer")
@NamedQuery(name="MVPPrinter.findAll", query="SELECT m FROM MVPPrinter m")
public class MVPPrinter implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mvp_printer_id")
	private int mvpPrinterId;

	@Lob
	private String description;

	@Column(name="manufacturer_url")
	private String manufacturerUrl;

	private String name;

	//bi-directional many-to-one association to MVPPrintSpecification
	@OneToMany(mappedBy="mvpPrinter")
	private List<MVPPrintSpecification> mvpPrintSpecifications;

	public MVPPrinter() {
	}

	public int getMvpPrinterId() {
		return this.mvpPrinterId;
	}

	public void setMvpPrinterId(int mvpPrinterId) {
		this.mvpPrinterId = mvpPrinterId;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getManufacturerUrl() {
		return this.manufacturerUrl;
	}

	public void setManufacturerUrl(String manufacturerUrl) {
		this.manufacturerUrl = manufacturerUrl;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<MVPPrintSpecification> getMvpPrintSpecifications() {
		return this.mvpPrintSpecifications;
	}

	public void setMvpPrintSpecifications(List<MVPPrintSpecification> mvpPrintSpecifications) {
		this.mvpPrintSpecifications = mvpPrintSpecifications;
	}

	public MVPPrintSpecification addMvpPrintSpecification(MVPPrintSpecification mvpPrintSpecification) {
		getMvpPrintSpecifications().add(mvpPrintSpecification);
		mvpPrintSpecification.setMvpPrinter(this);

		return mvpPrintSpecification;
	}

	public MVPPrintSpecification removeMvpPrintSpecification(MVPPrintSpecification mvpPrintSpecification) {
		getMvpPrintSpecifications().remove(mvpPrintSpecification);
		mvpPrintSpecification.setMvpPrinter(null);

		return mvpPrintSpecification;
	}

}