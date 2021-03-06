package com;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.*;

import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
public class address {
	static Scanner scanner = new Scanner(System.in);
	public static Contact_details getContact() {
		Contact_details contact = new Contact_details();
		System.out.println("Enter First Name");
		contact.setFirstName(scanner.nextLine());
		System.out.println("Enter Last Name");
		contact.setLast(scanner.nextLine());
		System.out.println("Enter Adddess");
		contact.setAddress(scanner.nextLine());
		System.out.println("Enter City");
		contact.setCity(scanner.nextLine());
		System.out.println("Enter State");
		contact.setState(scanner.nextLine());
		System.out.println("Enter zip code");
		contact.setZip(scanner.nextLine());
		System.out.println("Enter Phone Number");
		contact.setPhone(scanner.nextLine());
		System.out.println("Enter e-mail Id");
		contact.setEmail(scanner.nextLine());
		return contact;
	}

	public static AddressBook getAddressBook(String name) {
		AddressBook ab = new AddressBook();
		ab.setName(name);
		return ab;
	}

	public static void main(String args[]) {
		System.out.println("Welcome to Address Book System");
		boolean book_dict = true,addr_bookFound;
		boolean addr_book = true;
		int choice1, choice2;
		AddressBook book;
		addressBookDict abd = new addressBookDict();
		String name;
		while (book_dict) 
		{
			System.out.println("1. Add new Address Book\n" + "2. Edit an Address Book\n" +"3. Search a person by city\n"+ "4. Search a by state\n"
					+ "5. Total no of people in city\n"+ "6. Total no of people in state\n" +  "\n Enter 0 Exit");
			choice1 = Integer.parseInt(scanner.nextLine());
			switch (choice1) 
			{
			  case 1:
				  System.out.println("Enter the name of Address Book");
				  abd.addAddressBook(getAddressBook(scanner.nextLine()));
				  break;
				  
			  case 3:
				  System.out.println("Enter the name of city");
				  String city = scanner.nextLine();
				  abd.searchByCity(city);
				  break;	
			
			  case 4:
				  System.out.println("Enter the name of state");
				  String state = scanner.nextLine();
				  abd.searchByCity(state);
				  break;
				  
			  case 5:
				  System.out.println("Enter the name of city to calculate no of people");
				  String c = scanner.nextLine();
				  abd.countByCity(c);
				  break;	  
              
			  case 6:
				  System.out.println("Enter the name of state to calculate no of people");
				  String sta = scanner.nextLine();
				  abd.countByState(sta);
				  break;	  
			 
			 
			  case 2:
				  System.out.println("Enter the name of Address Book");
				  name = scanner.nextLine();
				  addr_bookFound = abd.isPresentAddressBook(name);
				  if (addr_bookFound == false)
					  System.out.println("Address Book not found");
				  else 
				  {
					book = abd.returnAddressBook(name);
					addr_book=true;
					while (addr_book) 
					{
						System.out.println("1. Add contact\n" + "2. View Contacts\n"
								+ "3. Edit a contact\n" + "4. Delete a contact\n" +"5. Sort entries by name\n" + "6. Sort entries by zip\n" 
								+"7. Sort entries by city\n" + "8. Sort entries by state\n"+"\n 11. Write in CSV file"+
								"\n 12. Read from CSV file" +"\n 13. Write in GSON file"+
								"\n 14. Read from GSON file" +"\nEnter 0 to exit");
						choice2 = Integer.parseInt(scanner.nextLine());
						switch (choice2) 
						{
					     	case 1:
					     		System.out.println("Enter First Name");
					    		String f_name=scanner.nextLine();
					    		System.out.println("Enter Last Name");
					    		String l_name=scanner.nextLine();
					    		System.out.println("Checking if name exists");
					    		book.seeContacts();
					    		if (book.checkContacts(f_name,l_name)==false)
					    		{	
					    			System.out.println("Enter the details:");
						    	    book.addDetails(getContact());
					    		}    
						    	else
						    		 System.out.println("Contact exists"); 
						    	break;
						    case 2:
							    book.seeContacts();
							    break;
						    case 3:
							    book.editContact();
							    break;
						   case 4:
							    book.deleteContact();
							    break;
						   case 5:
							    book.sortByName();
							    break; 
						   case 6:
							    book.sortByzip();
							    break; 	    
						   case 7:
							    book.sortByCity();
							    break;
						   case 8:
							    book.sortByState();
							    break; 	  
						   case 9:
								try{
									book.readFile();
								}catch (FileNotFoundException e){
									System.out.println("File not found");
								}
								break;
								
							case 10:
								book.writeFile();
								break;
								
							case 11:
								try 
								{
									book.writeCSV();
								} catch (IOException e) {
									e.printStackTrace();
								} catch (CsvDataTypeMismatchException e) {
									e.printStackTrace();
								} catch (CsvRequiredFieldEmptyException e) {
									e.printStackTrace();
								}
								break;
							case 12:
								try {
									book.readCSV();
								} catch (IOException e) {
									e.printStackTrace();
								}
								
								break;	
							case 13:
								book.gsonWrite();
								break;
							case 14:
								book.gsonRead();
								break;	
							  	    
						   default:
							  addr_book=false;
							  break;
						}
					}
				
				}
				break;
			  default:
			    book_dict = false;
				break;

			}
		}
	}
}
