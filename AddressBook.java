
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;




//import com.AddressBook.cityWiseSearch;  

class SortbyName implements Comparator<Contact_details> 
{  
    public int compare(Contact_details a, Contact_details b) 
    { 
    	return a.getFirstName().compareTo(b.getFirstName()); 
    } 
} 

class Sortbyzip implements Comparator<Contact_details> 
{  
    public int compare(Contact_details a, Contact_details b) 
    { 
    	return a.getZip().compareTo(b.getZip()); 
    } 
} 

class SortbyState implements Comparator<Contact_details> 
{  
    public int compare(Contact_details a, Contact_details b) 
    { 
    	return a.getStateName().compareTo(b.getStateName()); 
    } 
} 

class SortbyCity implements Comparator<Contact_details> 
{  
    public int compare(Contact_details a, Contact_details b) 
    { 
    	return a.getCity().compareTo(b.getCity()); 
    } 
} 

public class AddressBook 
{
	private ArrayList<Contact_details> contactsSet=new ArrayList<Contact_details>();  
	//private ArrayList<Contact_details> sorted = new ArrayList<>();
	
	
	private String name;
	static Scanner scanner=new Scanner(System.in);
	
	
	
	public ArrayList<Contact_details> getAddress_book() {
		return contactsSet;
	}

	public void setAddress_book(ArrayList<Contact_details> address_book) {
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
	
	public void sortByName() 
	{
		Collections.sort(contactsSet, new SortbyName()); 
        System.out.println("\nSorted by Name"); 
        contactsSet.stream().forEach(System.out::println);
	}

	public void sortByState() 
	{
		Collections.sort(contactsSet, new SortbyState()); 
        System.out.println("\nSorted by State"); 
        contactsSet.stream().forEach(System.out::println);
        
	}

	public void sortByCity() 
	{
		Collections.sort(contactsSet, new SortbyCity()); 	  
        System.out.println("\nSorted by City"); 
        contactsSet.stream().forEach(System.out::println);
	}
	
	public void sortByzip() 
	{
		Collections.sort(contactsSet, new Sortbyzip()); 
		  
        System.out.println("\nSorted by zipcode");
        contactsSet.stream().forEach(System.out::println);
       // for (int i=0; i<contactsSet.size(); i++) 
         //   System.out.println(contactsSet.get(i)); 
		
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

	public void writeCSV() throws IOException, CsvDataTypeMismatchException, CsvRequiredFieldEmptyException {
		String CSV_write_file = "F:\\AddressBookCSVwrite.txt";
		Writer writer = Files.newBufferedWriter(Paths.get(CSV_write_file));

		StatefulBeanToCsv<Contact_details> beanToCsv=new StatefulBeanToCsvBuilder(writer).withQuotechar(CSVWriter.NO_QUOTE_CHARACTER).build();
		beanToCsv.write(contactsSet);
		writer.close();

	}

	public void readCSV() throws IOException
	{
		String file_read = "D:\\AddressCSVreading.txt";
		Reader reader = Files.newBufferedReader(Paths.get(file_read));

		CSVReader readCSV = new CSVReader(reader);

		String[] adding;
		adding = readCSV.readNext();
		while((adding = readCSV.readNext())!=null) 
		{
			Contact_details c = new Contact_details();
			c.setFirstName(adding[0]);
			c.setLast(adding[1]);
			c.setAddress(adding[2]);
			c.setCity(adding[3]);
			c.setEmail(adding[4]);
			c.setPhone(adding[5]);
			c.setState(adding[6]);
			c.setZip(adding[7]);
			contactsSet.add(c);
		}
	}
	
	public void jsonWrite() throws IOException {
		String file = "D:\\jsonWrite.txt";
		Gson write = new Gson();
		String json = write.toJson(contactsSet);
		FileWriter writer = new FileWriter(file);
		writer.write(json);
		writer.close();
	}

	public void jsonRead() throws FileNotFoundException {
		String file = "D:\\jsonRead.txt";
		Gson gson = new Gson();
		BufferedReader read= new BufferedReader(new FileReader(file));
		Contact_details[] view= gson.fromJson(read, Contact_details[].class);
		List<Contact_details> contactList = Arrays.asList(view);
		for (Contact_details c : contactList){
			contactsSet.add(c);
		}
	}
	
	public void readFile() throws FileNotFoundException {
		File file=new File("D:\\Contact_details.txt");
		Scanner scanner = new Scanner(file);
		while(scanner.hasNextLine()){
			try
			{
				Contact_details c= new Contact_details();
				String data=scanner.nextLine();
				String[] add=data.split(" ");
				c.setFirstName(add[0]);
				c.setLast(add[1]);
				c.setAddress(add[2]);
				c.setCity(add[3]);
				c.setPhone(add[4]);
				c.setEmail(add[5]);
				c.setState(add[6]);
				c.setZip(add[7]);
				addDetails(c);
				
			}
			catch (Exception e)
			{
				System.out.println("It is not a valid contact");
			}
		}

	}

	public void writeFile() {
		try 
		{
			
			FileWriter writer = new FileWriter("D:\\AddressBook.txt",true);			
			for (Contact_details c: contactsSet)
			{
				writer.write(c.getFirstName()+" "+c.getLast()+" "+c.getAddress()+" "+c.getCity()+" "+c.getStateName()+" "+c.getStateName()+" "
						+c.getPhone()+" "+c.getEmail()+"\n");
			}
			writer.close();
		}
		catch (IOException e)
		{
			System.out.println("File does not exist");
		}
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
			ArrayList<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(city)).forEach(c -> {
				System.out.println(c.getFirstName() + " "+c.getLast());
			});
		});	
	}
	
	public void searchByState(String state) 
	{
		
		System.out.println("Entered in addressbook: "+address_book);
		address_book.stream().forEach(adb -> {
			ArrayList<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getStateName().equalsIgnoreCase(state)).forEach(c -> {
				System.out.println(c.getFirstName() + " "+c.getLast());
			});
		});	
	}
	
	public void countByState(String state) 
	{
		
		System.out.println("Entered in addressbook: "+address_book);
		address_book.stream().forEach(adb -> {
			ArrayList<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getStateName().equalsIgnoreCase(state)).forEach(c -> {
				List.add(c.getFirstName());
			});
		});	
		System.out.println("No. of people in state are: "+List.size());
		List.clear();
	}
	
	public void countByCity(String cit) 
	{
		
		System.out.println("Entered in addressbook: "+address_book);
		address_book.stream().forEach(adb -> {
			ArrayList<Contact_details> contacts = adb.getAddress_book();
			contacts.stream().filter(c -> c.getCity().equalsIgnoreCase(cit)).forEach(c -> {
				List.add(c.getFirstName());
			});
		});	
		System.out.println("No. of people in city are: "+List.size());
		List.clear();
	}
	
	
	public AddressBook returnAddressBook(String name) {
		AddressBook addrBookPlace = address_book.get(0);
		for (AddressBook ab : address_book) {
			if (ab.getName().equals(name)) 
			{
				addrBookPlace = ab;
				break;
			}
		}
		return addrBookPlace;
	}

}


