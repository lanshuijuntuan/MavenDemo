package com.sdj.rent.configs;

import com.alibaba.druid.filter.stat.StatFilter;
import com.alibaba.druid.wall.WallFilter;
import com.jfinal.config.Constants;
import com.jfinal.config.Handlers;
import com.jfinal.config.Interceptors;
import com.jfinal.config.JFinalConfig;
import com.jfinal.config.Plugins;
import com.jfinal.config.Routes;
import com.jfinal.ext.handler.ContextPathHandler;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.ActiveRecordPlugin;
import com.jfinal.plugin.druid.DruidPlugin;
import com.jfinal.plugin.druid.DruidStatViewHandler;
import com.jfinal.template.Engine;
import com.sdj.rent.controllers.IndexController;
import com.sdj.rent.controllers.ProManagementController;
import com.sdj.rent.models.data._MappingKit;

public class projectConfig extends JFinalConfig {

	@Override
	public void configConstant(Constants me) {

        //me.setViewType(ViewType.VELOCITY);
		// FtpServerFactory ftpServerFactory=new FtpServerFactory();
		//
		//
		// PropertiesUserManagerFactory userManagerFactory=new
		// PropertiesUserManagerFactory();
		// userManagerFactory.setFile(new File("users.properties"));
		//
		// ftpServerFactory.setUserManager(userManagerFactory.createUserManager());
		//
		// FtpServer ftpServer=ftpServerFactory.createServer();
		//
		// try {
		// ftpServer.start();
		// } catch (FtpException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

	}

	@Override
	public void configRoute(Routes me) {
		me.add("/", IndexController.class);
		me.add("/ProManagement", ProManagementController.class);

	}

	@Override
	public void configEngine(Engine me) {
		// TODO Auto-generated method stub

		me.addSharedFunction("/common/_layout.html");
		me.addSharedFunction("/common/_paginate.html");
	}

	@Override
	public void configPlugin(Plugins me) {
		// TODO Auto-generated method stub

		Prop prop = PropKit.use("users.properties");
		DruidPlugin druidPlugin = new DruidPlugin(prop.get("jdbcurl"), prop.get("username"),
				prop.get("password").trim());
		/** 配置druid监控 **/
		druidPlugin.addFilter(new StatFilter());
		WallFilter wall = new WallFilter();
		wall.setDbType("mysql");
		druidPlugin.addFilter(wall);
		me.add(druidPlugin);
		ActiveRecordPlugin arp = new ActiveRecordPlugin(druidPlugin);
		_MappingKit.mapping(arp);
		me.add(arp);

	}

	@Override
	public void configInterceptor(Interceptors me) {
		// me.add(new AuthInterceptor());

	}

	@Override
	public void configHandler(Handlers me) {
		me.add(new ContextPathHandler("ctx"));
		// TODO Auto-generated method stub
		DruidStatViewHandler druidStatViewHandler=new DruidStatViewHandler("/druid");
		me.add(druidStatViewHandler);

	}

}
