package com.sdj.rent.controllers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.jfinal.core.Controller;
import com.jfinal.json.FastJson;

public class DbController extends Controller {

	public void index() {
		renderText("db页面");
	}

	public void List() {
		renderText("list页面");
	}
	
	public DbController()
	{
//		System.out.println("调用了一次构造函数");
	}

	static String url = "jdbc:mysql://127.0.0.1/information_schema";
	static String driverstr = "com.mysql.jdbc.Driver";
	PreparedStatement propareStatement;
	static Connection con = null;
	static String username = "";
	static String password = "";

	public void Connect() {
		try {
			username = this.getPara("username");
			password = this.getPara("password");
			if (username == null || username.trim() == "") {
				renderText("username为空");
				return;
			}
			if (username == null || username.trim() == "") {
				renderText("password为空");
				return;
			}
			
			Class.forName(driverstr);
			con = DriverManager.getConnection(url, username, password);
			if(con.isClosed())
			{
			  System.out.println("当前数据库连接已经关闭");
			}
			propareStatement = con.prepareStatement("SELECT `SCHEMA_NAME` FROM `information_schema`.`SCHEMATA`");
			if (propareStatement != null) {
				ResultSet resultSet = propareStatement.executeQuery();
				
				ArrayList<String> lst=new ArrayList<String>();
						
				while (resultSet.next()) {
					String s = resultSet.getString(1);
					lst.add(s);
				}
//				con.close();
//				if(con.isClosed())
//				{
//				  System.out.println("当前数据库连接已经关闭");
//				}
				String str=FastJson.getJson().toJson(lst);
				renderJson(str);
			}
		} catch (Exception ex) {
			this.renderText(ex.toString());
		}
	}

	public void CreateDb() {
		if (username == null || username.trim() == "") {
			renderText("username为空");
			return;
		}
		if (username == null || username.trim() == "") {
			renderText("password为空");
			return;
		}
		String dbname = this.getPara("dbname");
		if (dbname == null || dbname.trim() == "") {
			renderText("dbname为空");
			return;
		}
		if (con != null) {
			String sql = String.format("create database %s", dbname);
			try {
				if(con.isClosed())
				{
				  System.out.println("当前数据库连接已经关闭");
				}
				propareStatement = con.prepareStatement(sql);
				int result = propareStatement.executeUpdate();
				this.renderText(result+"");
			} catch (Exception ex) {
				this.renderText(ex.toString());
			}

		}
	}
}
