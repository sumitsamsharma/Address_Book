package com;

public class address 
{
	String first_name;
	String last_name;
	int age;
	String address;
	String city;
	int zip;
	String phone_no;
	String email;
	
	address (String start_name,String lst_name, int years,String add,String ct,int zip_code,String number, String mail)
	{
		first_name = start_name;
		last_name=lst_name;
		age = years;
		address=add;
		city=ct;
		zip=zip_code;
		phone_no=number;
		email=mail;
	}
	
	public void display() 
    { 
		System.out.println("Emplyee details are: ");
		System.out.println("Name: "+first_name+" "+last_name+"   Age:"+age+"  Address:"+address+" "+city+" "+zip+"  Contact: "+phone_no+" "+email);	
    }
	
	public static void main(String[] args)
	{
		address obj1=new address("Kevin","Pietersen",35,"B-2 Shivalik Heights","Mumbai",256191,"9889988998","kp@gmail.com");
		obj1.display();
		
	}
}
