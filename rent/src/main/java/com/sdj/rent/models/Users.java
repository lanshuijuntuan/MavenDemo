package com.sdj.rent.models;

import java.util.List;

import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Model;


public class Users extends Model<Users> {

	private static final long serialVersionUID = 2171887541124413081L;

	public static final String username="username";
	
	public static final String password="password";
	
	public static final String id="id";
	
	private static final Log log=Log.getLog(Users.class);
	
	public static final Users dao = new Users();
	
	public Users getUserByName(String name)
	{
		if(name==null||name=="")
		{
			return null;
		}
		
		String sql=String.format("select * from users where username='%s'",name);
		List<Users> lst=find(sql);
		if(lst.size()==0)
		{
			return null;
		}
		else
		{
			return lst.get(0);
		}
	}

	
}
