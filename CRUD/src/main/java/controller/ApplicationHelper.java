package controller;

import java.util.List;

import model.Application;
import model.Software;

public class ApplicationHelper {

	
	Application application;
	DaoManager db = DaoManager.getInstance();

	public ApplicationHelper(Application application) {
		this.application = application;
		loadSoft();
	}

	public void loadSoft() {
		application.clear();
		for(Software soft : db.getAllSoft()) {
			application.addLoadSoft(soft);
		}
	}
	
	public void addSoft(Software soft) {
		if(!db.getAllSoft().contains(soft)) {
			db.addSoftware(soft);
		}
	}

	public void deleteSoft(Software soft) {
		db.deleteSoft(soft);
	}
	

	public List<Software> getLesSoft() {
		return db.getAllSoft();
	}

}
