package com;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

import com.AddressBook.cityWiseSearch;  
public class AddressBook extends Contact_details 
{
	private HashSet<Contact_details> address_book=new HashSet<Contact_details>();  
	
	ArrayList<cityWiseSearch> cityNameList=new ArrayList<cityWiseSearch>(); 
	
	private String name;
	static Scanner scanner=new Scanner(System.in);
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	class cityWiseSearch
	{  	  
		  String city;
		  String name;
		  String l;
		  cityWiseSearch(String name,String city,String l)
		  {  
		     this.city=city;  
		     this.name=name;   
		     this.l=l;
		  }  
		}  
	
	public void addDetails(Contact_details contact) 
	{
		address_book.add(contact);
		String name,city,l;
		city=contact.getCity();
		name=contact.getFirstName();
		l=contact.getLast();
		cityWiseSearch s=new cityWiseSearch(city,name,l); 
		cityNameList.add(s);
	}
	
	public void searchByCity(String city) 
	{
		  Iterator itr=cityNameList.iterator(); 
		  System.out.println("Checking if city exists");
		  System.out.println("Details are"+cityNameList);
		  while(itr.hasNext())
		  {  
			  cityWiseSearch st=(cityWiseSearch)itr.next();
			  System.out.println("Details are"+st.city);
		      if(st.city==city)
		      {
		    	  System.out.println("City: "+st.city+"  Name: "+st.name+" "+st.l);
		      }
		  }    
	}
	
	public void seeContacts() {
		for (Contact_details c : address_book) {
			System.out.println(c);
		}
	}
	
	public boolean checkContacts(String f,String l) 
	{
		return address_book.stream().anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(f) &&
				contact.getLast().equalsIgnoreCase(l));
	}
	
	

	public void deleteContact() {
		System.out.println("Enter first name");
		String first_name = scanner.nextLine();
		System.out.println("Enter last name");
		String last_name = scanner.nextLine();
		boolean found = false;
		for (Contact_details contact : address_book) 
		{
			if ((contact.getFirstName()==first_name) && (contact.getLast()==last_name)) {
				found=true;
				address_book.remove(contact);
				System.out.println("Contact has been deleted");
				break;
			}
		}
		if (found == false)
			System.out.println("Contact not found");
	}

	public void editContact() {
		
		System.out.println("Enter First name");
		String first_name = scanner.nextLine();
		System.out.println("Enter Last name");
		String last_name = scanner.nextLine();
		boolean check = false;
		for (Contact_details contact : address_book) {
			if ((contact.getFirstName().equalsIgnoreCase(first_name)) && (contact.getLast().equalsIgnoreCase(last_name))) 
			{
				System.out.println("Enter Address");
				contact.setAddress(scanner.nextLine());
				System.out.println("Enter City");
				contact.setCity(scanner.nextLine());
				System.out.println("Enter State");
				contact.setState(scanner.nextLine());
				System.out.println("Enter ZIP");
				contact.setZip(scanner.nextLine());
				System.out.println("Enter Phone Number");
				contact.setPhone(scanner.nextLine());
				System.out.println("Enter Email Id");
				contact.setEmail(scanner.nextLine());
				check = true;
				System.out.println("Contact edited");
				break;
			}
		}
		if (check == false)
			System.out.println("Contact not found");
			
	}

	
}

class addressBookDict extends AddressBook 
{
	private ArrayList<AddressBook> address_book = new ArrayList<AddressBook>();

	public void addAddressBook(AddressBook addr_book) {
		address_book.add(addr_book);
	}

	public boolean isPresentAddressBook(String name) {
		boolean found = false;
		for (AddressBook ab : address_book) {
			if (ab.getName().equalsIgnoreCase(name)) {
				found = true;
				break;
			}
		}
		return found;
	}
	
	public AddressBook returnAddressBook(String name) {
		AddressBook addrBookPlace = address_book.get(0);
		for (AddressBook ab : address_book) {
			if (ab.getName().equals(name)) {
				addrBookPlace = ab;
				break;
			}
		}
		return addrBookPlace;
	}

}


