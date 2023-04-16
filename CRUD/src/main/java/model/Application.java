package model;

import java.util.ArrayList;
import java.util.List;

import controller.ApplicationHelper;

public class Application {
	private static Application instance = null;
	private List<Software> softwareList = null;	
	private ApplicationHelper applicationHelper = null;

	
	public static Application getInstance() {
		if(instance == null) {
			instance = new Application();
		}
		return instance;
	}
	
	public Application() {
		this.softwareList = new ArrayList<Software>();
		applicationHelper = new ApplicationHelper(this);
	}
	
	public List<Software> getListSoftware(){
		return softwareList;
	}
	
	public void clear() {
		softwareList.clear();
	}
	
	public void addSoftware(String name, String  version, String licence) {
		if(!softwareList.contains(new Software(name, version, licence))) {
			softwareList.add(new Software(name, version, licence));
		}
	}
	
	public void deleteSoftware(Software software) {
		softwareList.remove(software);
	}
	
	public void deleteSoftware(String name) {
		softwareList.remove(getSoftware(name));
	}
	
	public Software getSoftware(String name) {
		for(Software sw : softwareList) {
			if(sw.getName().equals(name)) {
				return (Software) sw;
			}
		}
		return null;
	}
	
	public void updateSoftware(String name, String version, String licence) {
		if(softwareList.contains(getSoftware(name))) {
			getSoftware(name).setVersion(version);
			getSoftware(name).setLicence(licence);;
		}
	}

	public void addLoadSoft(Software soft) {
		if(!softwareList.contains(getSoftware(soft.getName()))) {
			softwareList.add(soft);
		}
		
	}
	
	
	
	
}
