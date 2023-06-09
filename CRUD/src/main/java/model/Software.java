package model;

import java.util.Objects;

public class Software {
	
	private String name;
	private String version;
	private String licence;
	private int id;

	public Software(String name, String version, String licence, int id) {
		this.name = name;
		this.version = version;
		this.licence = licence;
		this.id = id;
	}


	public Software(String name, String version, String licence) {
		this.name = name;
		this.version = version;
		this.licence = licence;
	}


	public Software(String name) {
		this.name = name;
		this.version = "not defined";
		this.licence = "not referenced";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getVersion() {
		return version;
	}


	public void setVersion(String version) {
		this.version = version;
	}


	public String getLicence() {
		return licence;
	}


	public void setLicence(String licence) {
		this.licence = licence;
	}


	@Override
	public int hashCode() {
		return Objects.hash(licence, name, version);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Software other = (Software) obj;
		return Objects.equals(licence, other.licence) && Objects.equals(name, other.name)
				&& Objects.equals(version, other.version);
	}


	public void setId(int autoGeneratedIdFromDatabase) {
		this.id = id;
		
	}


	public int getId() {
		return id;
	}
	
	
	
	
	
	
}
