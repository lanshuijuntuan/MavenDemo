package com.sdj.rent.services;


import com.jfinal.plugin.activerecord.Page;
import com.sdj.rent.models.data.ProManagement;

public class ProManagementService extends BaseService {

	public Page<ProManagement> paginate(int pageNumber, int pageSize) {
		return ProManagement.dao.paginate(pageNumber, pageSize, "select *", "from pro_management order by manage_id asc");
	}
	
	
	public ProManagement findById(int id)
	{
		return ProManagement.dao.findById(id);
	}
	
	public void deleteById(int id)
	{
		ProManagement.dao.deleteById(id);
	}
		
}
