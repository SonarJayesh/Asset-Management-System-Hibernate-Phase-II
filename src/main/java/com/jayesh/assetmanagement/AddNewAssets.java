package com.jayesh.assetmanagement;


import java.text.ParseException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.jayesh.assetmanagement.util.Assets;
import com.jayesh.assetmanagement.util.ComponentDetails;
import com.jayesh.assetmanagement.util.HibernateUtil;

import jakarta.validation.ConstraintViolationException;


public class AddNewAssets {
	
	
	public AddNewAssets() {
		
		try {
			
			//Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
	        
	        Assets assets = new Assets();
			
	        Session session = HibernateUtil.getSessionFactoryInstatce().openSession();
	        
	        
	        System.out.println("Enter the Asset Name :=");
	        assets.setAssetName(HibernateUtil.getScanner().next());
	        System.out.println("Enter the Asset Type :=");
	        assets.setAssetType(HibernateUtil.getScanner().next());
	        
	        int b=0;
		        do {
		        	
		        	System.out.println("Enter the Serial Number:=");
				    String a = HibernateUtil.getScanner().next(); 
				     if(a.length() >= 3 && a.length() <=10 ) {
				    	  
				    	  assets.setSerialNumber(a);
				    	  b=1;
				    	  break;
				      }else {
						
				    	  System.out.println("Serial Number always star with alphabet and contain 3-10 Characters:");
				      }
				     
				} while (b==0);
		      
			        
			System.out.println("Enter the Purchase Date (dd-MM-yyyy) :=");
			assets.setPurchaseDate(HibernateUtil.getSimpleDateFormat().parse(HibernateUtil.getScanner().next()));
			        
			 
				ComponentDetails component1 = new ComponentDetails();
			       
				try {
					
			    	   System.out.println("Enter the Assets Component Details");
				        
				        System.out.println("Enter the Asset Ram: ");
				        component1.setRam(HibernateUtil.getScanner().next());
				        System.out.println("Enter the Asset Processor: ");
				        component1.setProcessor(HibernateUtil.getScanner().next());
				        System.out.println("Enter the Asset Storage");
				        component1.setStorage(HibernateUtil.getScanner().next());
				        System.out.println("Enter the Asset Operating System: ");
				        component1.setOperatingSystem(HibernateUtil.getScanner().next());
				        
				        assets.setComponentDetails(component1);
				        component1.setAssets(assets);
				        
				} catch (Exception e) {
						
						System.out.println("Asset Record is Not Inserted !!!" + e.getMessage() );
				} 
			       
			        
			        
//			        Set<ConstraintViolation<Assets>> violations = validator.validate(assets);
//			        Iterator<ConstraintViolation<Assets>> iterator = violations.iterator();
//			       
//			        while (iterator.hasNext()) {
//			        	
//						ConstraintViolation<Assets> obj = iterator.next();
//						System.out.println("Error:"+ obj.getPropertyPath()+" - "+obj.getMessage()+" - "+ obj.getInvalidValue());
//						
//					}
			       
	        
	        
			     Transaction transaction = session.beginTransaction();
	        
		        try {
		        	session.persist(assets);;
				} catch (ConstraintViolationException e) {
					
					e.getConstraintViolations()
				.forEach(v -> System.out.println("Error: "+ v.getPropertyPath() +" - " + v.getMessage()+" - "+ v.getInvalidValue()));
				
				
				transaction.rollback();
				}
	        
		        
		        try {
					
		        	 //session.save(assets);
		        	
		        	  transaction.commit();
		        	  
		        	  System.out.println("Asset Record Inserted Successfully !!!");
		        	  
				} catch (Exception e) {
					
					transaction.rollback();
					
					System.out.println("Error While Save Assets: "+e.getMessage());
					System.out.println("Record is not saved!!");
				}
		       
		        finally {
		        	
		        	session.close();
				}
	       
		
		}catch (ParseException ex) {
			
			System.out.println("Parsing Error: "+ ex.getMessage());
		} 
		
		
		catch (Exception e) {
			
			
			System.out.println("Asset Record is Not Inserted !!!" + e.getMessage() );
			
		}
		
	}

}