package com.sdj.rent.controllers;

import com.jfinal.core.Controller;
import com.jfinal.plugin.activerecord.Page;
import com.sdj.rent.models.data.ProManagement;
import com.sdj.rent.services.ProManagementService;

public class ProManagementController extends Controller {

	ProManagementService service = enhance(ProManagementService.class);

	public void index() {
		Page<ProManagement> page = service.paginate(getParaToInt(0, 1), 15);
		setAttr("proManagementPage", page);
		render("ProManagement.html");
	}

	public void edit() {
		setAttr("proManagement", service.findById(getParaToInt()));
		render("edit.html");
	}

	public void delete() {
		service.deleteById(getParaToInt());
		redirect("/ProManagement");
	}

	public void add() {
		render("add.html");
	}

	public void update() {
//		ProManagement proManagement = getBean(ProManagement.class,"proManagement");
		ProManagement proManagement=getBean(ProManagement.class);
		proManagement.update();
		redirect("/ProManagement");
	}
	
	public void save()
	{
		ProManagement proManagement=getBean(ProManagement.class);
		proManagement.save();
		redirect("/ProManagement");
	}
}
