package com.sdj.rent.controllers;

import com.jfinal.core.Controller;


/*
 * 主页的控制器
 * 
 */
public class HomeController extends Controller {

	public void index()
	{
		render("home.jsp");
	}
	
}
