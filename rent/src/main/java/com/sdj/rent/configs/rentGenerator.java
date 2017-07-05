package com.sdj.rent.configs;

import javax.sql.DataSource;

import com.jfinal.kit.PathKit;
import com.jfinal.kit.Prop;
import com.jfinal.kit.PropKit;
import com.jfinal.plugin.activerecord.dialect.MysqlDialect;
import com.jfinal.plugin.activerecord.generator.Generator;
import com.jfinal.plugin.c3p0.C3p0Plugin;

public class rentGenerator {

	
	public static DataSource getDataSource()
	{
		Prop prop=PropKit.use("users.properties");
		C3p0Plugin c3p0Plugin=new C3p0Plugin(prop.get("jdbcurl"),prop.get("username"),prop.get("password"),prop.get("driver"));
		c3p0Plugin.start();
		return c3p0Plugin.getDataSource();
	}
	
	public static void main(String[] args) {
		//base model包的名称
		String baseModelPackageName="com.sdj.rent.models.data.base";
		//base model包的输出路径
		String baseModeloutDir=PathKit.getWebRootPath()+"\\src\\main\\java\\com\\sdj\\rent\\models\\data\\base";
		//model 包的名称
		String modelPackageName="com.sdj.rent.models.data";
		//model 包的输出路径
		String modelPackageoutDir=PathKit.getWebRootPath()+"\\src\\main\\java\\com\\sdj\\rent\\models\\data";
		
		Generator generator=new Generator(getDataSource(),baseModelPackageName,baseModeloutDir,modelPackageName,modelPackageoutDir);
		
		generator.setDialect(new MysqlDialect());
		
		generator.addExcludedTable("test","calendar","sys_rec_menu_copy","sys_rec_menu_copy1");
		
		generator.setGenerateDaoInModel(true);
		
		generator.setGenerateDataDictionary(true);

		generator.generate();
		

	}

}
