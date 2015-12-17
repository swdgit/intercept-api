package com.protolounge.intercept.domain;

import java.io.Serializable;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.math.BigDecimal;
import java.util.List;


/**
 * The persistent class for the mvp_material database table.
 * 
 */
@Entity
@Table(name="mvp_material")
@NamedQuery(name="MVPMaterial.findAll", query="SELECT m FROM MVPMaterial m")
public class MVPMaterial implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="mvp_material_id")
	private int mvpMaterialId;

	@Lob
	private String description;

	@Column(name="manufacturer_url")
	private String manufacturerUrl;

	@Column(name="material_form")
	private String materialForm;

	@Column(name="material_type")
	private String materialType;

	private String name;

	private BigDecimal size;

	//bi-directional many-to-one association to MVPPrintSpecification
	@OneToMany(mappedBy="mvpMaterial")
    @JsonManagedReference
	private List<MVPPrintSpecification> mvpPrintSpecifications;

	public MVPMaterial() {
	}

	public int getMvpMaterialId() {
		return this.mvpMaterialId;
	}

	public void setMvpMaterialId(int mvpMaterialId) {
		this.mvpMaterialId = mvpMaterialId;
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

	public String getMaterialForm() {
		return this.materialForm;
	}

	public void setMaterialForm(String materialForm) {
		this.materialForm = materialForm;
	}

	public String getMaterialType() {
		return this.materialType;
	}

	public void setMaterialType(String materialType) {
		this.materialType = materialType;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSize() {
		return this.size;
	}

	public void setSize(BigDecimal size) {
		this.size = size;
	}

	public List<MVPPrintSpecification> getMvpPrintSpecifications() {
		return this.mvpPrintSpecifications;
	}

	public void setMvpPrintSpecifications(List<MVPPrintSpecification> mvpPrintSpecifications) {
		this.mvpPrintSpecifications = mvpPrintSpecifications;
	}

	public MVPPrintSpecification addMvpPrintSpecification(MVPPrintSpecification mvpPrintSpecification) {
		getMvpPrintSpecifications().add(mvpPrintSpecification);
		mvpPrintSpecification.setMvpMaterial(this);

		return mvpPrintSpecification;
	}

	public MVPPrintSpecification removeMvpPrintSpecification(MVPPrintSpecification mvpPrintSpecification) {
		getMvpPrintSpecifications().remove(mvpPrintSpecification);
		mvpPrintSpecification.setMvpMaterial(null);

		return mvpPrintSpecification;
	}

}