package com;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

//import com.AddressBook.cityWiseSearch;  
public class AddressBook  
{
	private HashSet<Contact_details> contactsSet=new HashSet<Contact_details>();  
	Map<String,ArrayList<Contact_details>> city_map = new HashMap<>();
	Map<String,ArrayList<Contact_details>> state_map = new HashMap<>();
	
	
	private String name;
	static Scanner scanner=new Scanner(System.in);
	
	
	
	public HashSet<Contact_details> getAddress_book() {
		return contactsSet;
	}

	public void setAddress_book(HashSet<Contact_details> address_book) {
		this.contactsSet = address_book;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	
	public void seeContacts() {
		for (Contact_details c : contactsSet) {
			System.out.println(c);
		}
	}
	
	public void addDetails(Contact_details contact) 
	{
		contactsSet.add(contact);
		
	}
	
	public boolean checkContacts(String f,String l) 
	{
		return contactsSet.stream().anyMatch(contact -> contact.getFirstName().equalsIgnoreCase(f) &&
				contact.getLast().equalsIgnoreCase(l));
	}
	
	

	public void deleteContact() {
		System.out.println("Enter first name");
		String first_name = scanner.nextLine();
		System.out.println("Enter last name");
		String last_name = scanner.nextLine();
		boolean found = false;
		for (Contact_details contact : contactsSet) 
		{
			if ((contact.getFirstName()==first_name) && (contact.getLast()==last_name)) {
				found=true;
				contactsSet.remove(contact);
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
		for (Contact_details contact : contactsSet) {
			if ((contact.getFirstName().equalsIgnoreCase(first_name)) && (contact.getLast().equalsIgnoreCase(last_name))) 
			{
				System.out.println("Enter Address");
				contact.setAddress(scanner.nextLine());
				System.out.println("Enter City");
				contact.setCity(scanner.nextLine());
				System.out.println("Enter State");
				contact.setState(scanner.nextLine());
				System.out.println("Enter zip");
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
	ArrayList<String> List=new ArrayList<String>(); 
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
	
	public void searchByCity(String city) 
	{
		
		System.out.println("Entered in addressbook: "+address_book);
		address_book.stream().forEach(adb -> {
			HashSet<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(city)).forEach(c -> {
				System.out.println(c.getFirstName() + " "+c.getLast());
			});
		});	
	}
	
	public void searchByState(String state) 
	{
		
		System.out.println("Entered in addressbook: "+address_book);
		address_book.stream().forEach(adb -> {
			HashSet<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getStateName().equalsIgnoreCase(state)).forEach(c -> {
				System.out.println(c.getFirstName() + " "+c.getLast());
			});
		});	
	}
	
	public void countByState(String state) 
	{
		
		System.out.println("Entered in addressbook: "+address_book);
		address_book.stream().forEach(adb -> {
			HashSet<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getStateName().equalsIgnoreCase(state)).forEach(c -> {
				List.add(c.getFirstName());
			});
		});	
		System.out.println("No. of people in state are: "+List.size());
		List.clear();
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


