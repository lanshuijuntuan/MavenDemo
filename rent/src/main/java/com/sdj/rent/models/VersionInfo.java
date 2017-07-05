package com.sdj.rent.models;

import java.util.List;
import java.util.Map;

import com.jfinal.log.Log;
import com.jfinal.plugin.activerecord.Model;

public class VersionInfo extends Model<VersionInfo>{

	private static final long serialVersionUID = -4609492823070991592L;

	public static final String version="version";
	
	public static final String productversion="productversion";

	public static final String fileversion="fileversion";
	
	public static final String filename="filename";
	
	public static final String id="id";
	
	public static final String fileurl="fileurl";
	
	private static final Log log=Log.getLog(VersionInfo.class);
	
	
	public static final VersionInfo dao=new VersionInfo();
	
	
	
	public VersionInfo GetVersionInfoByNumber(String versionnumber)
	{
		String sql=String.format("select * from versioninfo where version='%s'", versionnumber);
		List<VersionInfo> lst=find(sql);
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
