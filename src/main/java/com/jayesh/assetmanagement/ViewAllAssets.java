package com.jayesh.assetmanagement;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.HibernateUtil;


public class ViewAllAssets {
	
	public ViewAllAssets() {
		
		try {
			
				Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
			
			
				String hql = "FROM Assets a JOIN FETCH a.componentDetails";
			 
				List<Assets> assets = session.createQuery(hql, Assets.class).getResultList();
			
				try {
					
					if (assets.isEmpty()) {
						
						System.out.println("Assets and Component Details is Not Available");
						return;
					}
					
					for (Assets asset : assets) {
						System.out.println(asset.toString());
						System.out.println(asset.getComponentDetails().toString());
						System.out.println("-----------------------------------------------");
					}
				
				} catch (Exception e) {
					
					System.out.println("Assets and Component Details is Not View"+ e.getMessage());
					
				}
			 
				 Transaction transaction = session.beginTransaction();
				
					 
				 	try {
						 
						 transaction.commit();
						 System.out.println("View All Assets & Component Details Succesfully");
						 
					} catch (Exception e) {
						
						transaction.rollback();
						
						System.out.println("Error While View All Assets & Component Details: "+e.getMessage());
						System.out.println("Record is not View!!!");
					
					
					}  finally {
						
						 session.close(); 
					} 
		
		
		} catch (HibernateException hibernateException) {
			
			System.out.println("Hibernate Exception: "+hibernateException.getMessage());
		}
		catch (Exception e) {
			
			System.out.println("Asset Details And Component Details is not View "+e.getMessage());
		}
	}
}
