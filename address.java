package com;

import java.util.*;
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
		addressBookDict add_dict = new addressBookDict();
		System.out.println("Welcome to Address Book System");
		boolean bookLoop = true, innerLoop = true,findBook;
		int choice1, choice2;
		AddressBook book;
		String name;
		while (bookLoop) {
			System.out.println("1. Add new Address Book\n" + "2. Edit an Address Book\n" + "Enter 0 to exit");
			choice1 = scanner.nextInt();
			switch (choice1) {
			case 1:
				System.out.println("Enter the name of Address Book");
				add_dict.addAddressBook(getAddressBook(scanner.nextLine()));
				break;
			case 2:
				System.out.println("Enter the name of Address Book");
				name = scanner.nextLine();
				findBook = add_dict.isPresentAddressBook(name);
				if (findBook == false)
					System.out.println("Address Book not found");
				else {

					book = add_dict.returnAddressBook(name);
					innerLoop=true;
					while (innerLoop) {
						System.out.println("1. Add contact\n" + "2. View Contacts\n"
								+ "3. Edit a contact\n" + "4. Delete a contact\n" + "Enter 0 to exit");
						choice2 =scanner.nextInt();
						switch (choice2) {
						case 1:
							book.addDetails(getContact());
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
						default:
							innerLoop=false;
							break;
						}
					}
				
				}
				break;
			default:
				bookLoop = false;
				break;

			}
		}
	}
}