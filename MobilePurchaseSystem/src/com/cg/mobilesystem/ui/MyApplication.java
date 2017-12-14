package com.cg.mobilesystem.ui;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import com.cg.mobilesystem.dto.Mobile;
import com.cg.mobilesystem.dto.Purchase;
import com.cg.mobilesystem.exception.PurchaseException;
import com.cg.mobilesystem.service.IPurchaseService;
import com.cg.mobilesystem.service.PurchaseServiceImpl;

public class MyApplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		
		IPurchaseService purSerImpl = new PurchaseServiceImpl();
		int choice;
		do{
			System.out.println("___________________________");
			System.out.println("Enter the choice");
			System.out.println("1. Insert purchase details\n2. View all mobiles\n"
					+ "3. Delete mobile\n4. Search mobiles(by price range)\n5. Exit");
			choice= in.nextInt();
			switch(choice){
			case 1:  //insert
				System.out.println("Enter Customer Name :");
				String name=in.next();
				
				//validate name

				try {
					PurchaseServiceImpl.validateName(name);
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}				
					
				
				System.out.println("Enter Customer EmailId :");
				String email=in.next();	
				//validate email
				try {
					PurchaseServiceImpl.validateEMail(email);
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}
				
				System.out.println("Enter Customer Phone :");
				String contact=in.next();
				//validate Phoneno
				try {
					PurchaseServiceImpl.validatePhone(contact);
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}						
				long phone = Long.parseLong(contact);
				
				//convert java date format to sql date 
				Date purDate =new Date(new java.util.Date().getTime());		
				
				System.out.println("Enter Mobile Id :");
				String mobile = in.next();
				//validate mobileId
				try {
					PurchaseServiceImpl.validateMobileId(mobile);
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
					break;
				}
				
				int mobileId = Integer.parseInt(mobile);
				
				//create Purchase object
				Purchase purchase = new  Purchase();			
				purchase.setCusName(name);
				purchase.seteMail(email);
				purchase.setPhone(phone);
				purchase.setPurDate(purDate);
				purchase.setMobileId(mobileId);
				
				int id=0;
				try {					
					id = purSerImpl.addPurchase(purchase);
					
				} catch (PurchaseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}
				
				if(id==0)
					System.out.println("Data not added.");
				else
					System.out.println("Purchase Id is :" + id);
				
				break;
		
			case 2: //showAll
				List<Mobile> myList=null; 
				try {
					myList = purSerImpl.showAllMobiles();
				} catch (PurchaseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}
				if(myList.isEmpty())
					System.out.println("No Data Found....");
				
				for (Mobile mob : myList) {
					System.out.println("==================");
					System.out.println("Id is "+mob.getId());
					System.out.println("Name is "+mob.getName());
					System.out.println("Price is "+mob.getPrice());
					System.out.println("Quantity is "+mob.getQuantity());
				}
				break;
				
			case 3: //delete
				System.out.println("Enter the mobile id");
				int mobId = in.nextInt();
				
				int status=0;
				
				try {
					status=purSerImpl.deleteMobile(mobId);
				} catch (PurchaseException e1) {
					// TODO Auto-generated catch block
					//e1.printStackTrace();
					System.out.println(e1.getMessage());
				}
				
				if(status == 1)
					System.out.println("Deletion done.");
				else
					System.out.println("Deletion not done.");				
				break;
				
			case 4: //search
				List<Mobile> mySearchList=null;
				int min,max;
				System.out.println("Enter the minimum price");
				min=in.nextInt();
				System.out.println("Enter the maximum price");
				max=in.nextInt();
				
				try {
					mySearchList = purSerImpl.searchMobiles(min,max);
				} catch (PurchaseException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println(e.getMessage());
				}
				if(mySearchList.isEmpty())
					System.out.println("No Data Found....");
				
				for (Mobile mob : mySearchList){
					System.out.println("==================");
					System.out.println("Id is "+mob.getId());
					System.out.println("Name is "+mob.getName());
					System.out.println("Price is "+mob.getPrice());
					System.out.println("Quantity is "+mob.getQuantity());
				}
				break;
								
			case 5: //exit
				in.close();
				System.out.println("Program closed successfully");
				System.exit(0);
				break;		
			}
		}
		while(choice!=5);
	}

}
