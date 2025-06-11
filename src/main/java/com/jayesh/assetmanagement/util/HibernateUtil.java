package com.jayesh.assetmanagement.util;

import java.text.SimpleDateFormat;
import java.util.Scanner;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;



public class HibernateUtil {

	public static SessionFactory sessionFactory;
	
	public static Scanner scanner;
	
	public static SimpleDateFormat simpleDateFormat;
	
	private HibernateUtil() {
		
	}
	
	public static SessionFactory getSessionFactoryInstatce() {
		
		if (sessionFactory == null) {
			Configuration configuration = new Configuration();
			configuration.configure();
			//configuration.addAnnotatedClass(Assets.class);
			sessionFactory = configuration.buildSessionFactory();
		}
		return sessionFactory;
	};
	
	public static SimpleDateFormat getSimpleDateFormat() {
		
		if (simpleDateFormat == null) {
			
			simpleDateFormat = new SimpleDateFormat("dd-MM-yyy");
		}
		return simpleDateFormat;
		
	}
	
	public static Scanner getScanner() {
		
		if (scanner == null) {
			
			scanner = new Scanner(System.in);
		}
		return scanner;
	}
	
}
