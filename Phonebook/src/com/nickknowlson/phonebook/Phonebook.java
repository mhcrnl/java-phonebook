package com.nickknowlson.phonebook;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.io.Serializable;

public class Phonebook extends ArrayList<Person> implements Serializable {
	
	private static final long serialVersionUID = -6824316704912481869L;

	// constructor
	public Phonebook(Collection<Person> listOfPeople) {
		super(listOfPeople);
	}
	
	// public methods
	public void save(String filename) {
		FileOutputStream fos = null;
		ObjectOutputStream out = null;
		//BufferedWriter bufferedWriter = null;
		try {
			fos = new FileOutputStream(filename);
			out = new ObjectOutputStream(fos);
			out.writeObject(this);
			out.close();
		} catch (Exception e) {
			System.err.println("Error: phonebook could not be saved to " + filename + ". Message: " + e.getMessage());
		}
	}

	public Person findPersonWithLastName(String string) {
		// TODO Auto-generated method stub
		return null;
	}

	public Person findPersonWithPhoneNumber(PhoneNumber phoneNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	public List<PhoneNumber> findPhoneNumbersOfPerson(Person person) {
		// TODO Auto-generated method stub
		return null;
	}
	
	// public static methods
	public static List<Person> generateRandomizedListOfPeople(int amountOfPeople) {
		List<Person> randomListOfPeople = new ArrayList<Person>();
		
		for(int i=0; i < 5000; i++) {
			randomListOfPeople.add(generateRandomPerson());
		}
		
		return randomListOfPeople;
	}
	
	public static Phonebook load(String filename) {
		FileInputStream fis = null;
		ObjectInputStream in = null;
		
		List<Person> phonebook = null;
		
		try {
			fis = new FileInputStream(filename);
			in = new ObjectInputStream(fis);
			phonebook = (ArrayList<Person>) in.readObject();
			in.close();
		} catch (IOException ex) {
			System.err.println("Couldn't load " + filename + ". Error: " + ex.getMessage());
			ex.printStackTrace();
		} catch (ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		return new Phonebook(phonebook);
	}
	
	// private methods
	private static Person generateRandomPerson() {
		String firstName = randomName();
		String lastName = randomName();

		List<PhoneNumber> phoneNumbers = randomPhoneNumbers();
		
		return new Person(firstName, lastName, phoneNumbers);
	}
	
	private static List<PhoneNumber> randomPhoneNumbers() {
		
		int numOfPhoneNumbers = new Random().nextInt(4);
		
		List<PhoneNumber> phoneNumbers = new ArrayList<PhoneNumber>();
		
		for(int i=0; i<numOfPhoneNumbers; i++) {
			phoneNumbers.add(randomPhoneNumber());
		}	
		
		return phoneNumbers;
	}

	private static PhoneNumber randomPhoneNumber() {
		return new PhoneNumber(randomDigits(3) + "-" + randomDigits(3) + "-" + randomDigits(4));
	}
	
	private static String randomDigits(int numOfDigits) {
		String digits = "";
		for(int i=0; i< numOfDigits; i++) {
			digits += Integer.toString(new Random().nextInt(9)); 
		}
		return digits;
	}

	private static String randomName() {
		
		int lengthOfName = new Random().nextInt(8) + 3;  // let's generate names between 3 and 11 chars long

		String alphabet = "abcdefghijklmnopqrstuvwxyz";
		
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(lengthOfName);
		for(int i=0; i < lengthOfName; i++ ) {
			sb.append( alphabet.charAt( rnd.nextInt(26) ) );
		}
		return capitalizeWord(sb.toString());
	}
	
	private static String capitalizeWord(String word) {
		return word.substring(0,1).toUpperCase() + word.toLowerCase().substring(1);
	}

	
}
