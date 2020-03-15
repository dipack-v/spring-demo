package com.demo.server;

import java.io.File;
import java.io.IOException;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class TomcatStarter {

	private static final int PORT = 8080;

	public static void start() {
		String appBase = ".";
		Tomcat tomcat = new Tomcat();
		tomcat.setBaseDir(createTempDir());
		tomcat.setPort(PORT);
		tomcat.getHost().setAppBase(appBase);
		try {
			tomcat.addWebapp("", appBase);
		} catch (ServletException e1) {
			e1.printStackTrace();
		}
		try {
			tomcat.start();
		} catch (LifecycleException e) {
			e.printStackTrace();
		}
		tomcat.getServer().await();
	}

	private static String createTempDir() {

		try {

			File tempDir = File.createTempFile("tomcat.", "." + PORT);
			tempDir.delete();
			tempDir.mkdir();
			tempDir.deleteOnExit();
			return tempDir.getAbsolutePath();
		} catch (IOException ex) {
			throw new RuntimeException(
					"Unable to create tempDir. java.io.tmpdir is set to " + System.getProperty("java.io.tmpdir"), ex

			);

		}

	}
}
