package com.jayesh.assetmanagement;

import com.jayesh.assetmanagement.util.HibernateUtil;


public class App {
	
	public App() {
		
		System.out.println("*** Welcome to Assets Management System Phase-II ***");
        
        int a;
        
        do {
			System.out.println("\n1. Add New Asset \n2. View All Assets \n3. Update Asset \n4. Delete Asset \n5. Exit \n Enter Your Choice Option Number:");
        	int option = HibernateUtil.getScanner().nextInt();
        	
        	switch (option) {
			
	        	case 1: 
					new AddNewAssets();
					break;
			
				case 2:
					new ViewAllAssets();
					break;
					
				case 3:
					new UpdateAssets();
					break;
					
				case 4:
					new DeleteAsset();
					break;
					
				case 5:
					System.exit(0);
					break;
	        	
				default:
					
					System.out.println("Your No is Invalid please Enter the Valid No :");
				
				}
			
        	 System.out.println("\n Continue to Operation Enter 1/Yes  and  0/No: ");
             
        	 a=HibernateUtil.getScanner().nextInt();
        
        
        }while (a!=0); 
	}
	
	public static void main(String[] args) {
        
        new App();
        
    }
	
	
}
