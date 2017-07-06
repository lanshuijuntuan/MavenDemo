package com.sdj.mytest;

import java.applet.Applet;
import java.awt.Graphics;

public class HelloApplet extends Applet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public void paint(Graphics e)
	{
		e.drawString("Hello World!", 25, 20);
	}

}