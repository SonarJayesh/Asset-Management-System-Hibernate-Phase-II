package com.jayesh.assetmanagement.util;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name = "componentDetail")
public class ComponentDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long componentId;
	
	@NotNull
	@Pattern(regexp = "^[0-9A-Za-z]+$", message = "Enter the Valid Ram :[Enter the ALPHA NUMERIC value]")
	private String ram;
	
	@NotNull
	@Pattern(regexp = "^[a-zA-Z0-9]+$", message = "Enter the Valid Processor :[Enter the ALPHA NUMERIC value]")
	private String processor;
	
	@NotNull
	@Pattern(regexp = "^[0-9A-Za-z]+$", message = "Enter the Valid Storage Detail:[Enter the ALPHA NUMERIC value]")
	private String storage;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9]+$", message = "Enter the Valid Operating System:[Enter the ALPHA NUMERIC value]")
	private String operatingSystem;
	

	

	@OneToOne
	@JoinColumn(name = "asset_id")
	Assets assets;
	
	
	
	public Assets getAssets() {
		return assets;
	}
	public void setAssets(Assets assets) {
		this.assets = assets;
	}
	public Long getComponentId() {
		return componentId;
	}
	public void setComponentId(Long componentId) {
		this.componentId = componentId;
	}
	public String getRam() {
		return ram;
	}
	public void setRam(String ram) {
		this.ram = ram;
	}
	public String getProcessor() {
		return processor;
	}
	public void setProcessor(String processor) {
		this.processor = processor;
	}
	public String getStorage() {
		return storage;
	}
	public void setStorage(String storage) {
		this.storage = storage;
	}
	public String getOperatingSystem() {
		return operatingSystem;
	}
	public void setOperatingSystem(String operatingSystem) {
		this.operatingSystem = operatingSystem;
	}
	
	
	@Override
	public String toString() {
		return "Component [assetId=" + componentId + ", ram=" + ram + ", processor=" + processor + ", storage=" + storage
				+ ", operatingSystem =" + operatingSystem + "]";
	}
	
	
	
}
