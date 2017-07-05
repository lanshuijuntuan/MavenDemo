package com.sdj.rent.controllers;

import java.io.Console;
import java.io.File;
import java.util.List;

import com.alibaba.fastjson.JSONObject;
import com.jfinal.core.Controller;
import com.jfinal.json.FastJson;
import com.jfinal.json.Json;
import com.jfinal.log.Log;
import com.jfinal.upload.UploadFile;
import com.sdj.rent.models.Users;
import com.sdj.rent.models.VersionInfo;
import com.sdj.rent.models.data.BankOffer;
import com.sdj.rent.services.BankOfferService;
import com.sdj.rent.services.UsersService;

/*
 * 首页Controller
 * 
 */
public class IndexController extends Controller {

	UsersService usersService=enhance(UsersService.class);
	
	BankOfferService bankOfferService=enhance(BankOfferService.class);
	
	public void index() {
		// 设置Sesion过期时间
		this.getSession().setMaxInactiveInterval(60 * 5);
		// String name = this.getCookie(Users.username);
		// String password = this.getCookie(Users.password);

		String name = this.getSessionAttr(Users.username);
		String password = this.getSessionAttr(Users.password);
		Users mUser = Users.dao.getUserByName(name);
		if (mUser != null) {
			if (mUser.getStr(Users.password).equals(password)) {

				this.setSessionAttr(Users.username, mUser.getStr(Users.username));
				this.setSessionAttr(Users.password, mUser.getStr(Users.password));
				// setCookie("username", mUser.getStr(Users.username), 60 * 60);
				// setCookie("password", mUser.getStr(Users.password), 60 * 60);
				redirect("/home.jsp");

				return;
			}
		}

		this.renderJsp("login.jsp");

	}

	private static final Log log = Log.getLog(IndexController.class);

	public void Upload() {
		String versionFile = getPara("fileversion");
		String productVersion = getPara("productversion");
		String zipName = getPara("zipname");
		String zipUrl = getPara("zipurl");

		VersionInfo versionInfo=VersionInfo.dao.GetVersionInfoByNumber(versionFile);
		
		if(versionInfo==null)
		{
			
			versionInfo=new VersionInfo();
			versionInfo.put(VersionInfo.version, versionFile);
			versionInfo.put(VersionInfo.productversion, productVersion);
			versionInfo.put(VersionInfo.filename, zipName);
			versionInfo.put(VersionInfo.fileurl, zipUrl);
			versionInfo.put(VersionInfo.fileversion, versionFile);
			versionInfo.save();
		}
		else
		{
			versionInfo.put(VersionInfo.version, versionFile);
			versionInfo.put(VersionInfo.productversion, productVersion);
			versionInfo.put(VersionInfo.filename, zipName);
			versionInfo.put(VersionInfo.fileurl, zipUrl);
			versionInfo.put(VersionInfo.fileversion, versionFile);
			versionInfo.update();
		}
		System.out.println(
				String.format("上传文件的版本号：%s,\n上传文件的产品版本号：%s,\n上传文件的名称：%s", versionFile, productVersion, zipName));
		System.out.println(String.format("上传文件url：%s", zipUrl));
		renderText("上传成功，等待服务器处理");

	}

	public void GetVersionInfo() {
		String version = getPara("version");
		VersionInfo versionInfo = VersionInfo.dao.GetVersionInfoByNumber(version);
		renderJson(versionInfo.toRecord().toJson());
	}

	public void login() {

		String name = getPara("username");
		String password = getPara("password");

		Users mUser = Users.dao.getUserByName(name);
		if (mUser == null) {
			renderText("用户不存在");
			return;
		}

		if (!mUser.getStr(Users.password).equals(password)) {
			renderText("用户不存在，或者用户名密码错误");
		} else {

			this.setSessionAttr("username", mUser.getStr(Users.username));
			this.setSessionAttr("password", mUser.getStr(Users.password));

			// setCookie("username", mUser.getStr(Users.username), 60 * 60);
			// setCookie("password", mUser.getStr(Users.password), 60 * 60);
			redirect("/home.jsp");
		}
	}
	
	public void list()
	{
		List<BankOffer> bankoffers=bankOfferService.list();
		setAttr("bankoffers", bankoffers);
		render("bankoffer.jsp");
	}
}
