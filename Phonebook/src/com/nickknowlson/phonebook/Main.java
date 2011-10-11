package com.nickknowlson.phonebook;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;


public class Main {

	private static final String DEFAULT_PHONEBOOK_NAME = "phonebook.txt";
	
	public static void main(String[] args) {
		 
		int number = 0;
		
		if(!phonebookExists()) {
			System.out.println("No phonebook found, generating default phonebook.");
			generatePhonebook();
		}
		
		Phonebook phonebook = Phonebook.load(DEFAULT_PHONEBOOK_NAME);

		while(number != 3) {
			System.out.println("Pick an option: \n\t1. Generate new phonebook \n\t2. Look up a person\n\t3. Exit");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
			try {
				number = Integer.parseInt(br.readLine());
			} 
			catch (IOException ioe) {
				System.err.println("IO error trying to read your choice!");
				System.exit(1);
			}
			catch(NumberFormatException nfe) {
				number = 0; // will be handled by default case
			}
			
			switch (number) {
			case 1:
				System.out.println("Generating phonebook...");
				generatePhonebook();
				break;
			case 2:
				while(number != 4) {
					System.out.println("Look up by:\n\t1. Last name\n\t2. Phone Number\n\t3. Full Name\n\t4. Back");
					try {
						number = Integer.parseInt(br.readLine());
					} catch (IOException ioe) {
						System.err.println("IO error trying to read your choice!");
						System.exit(1);
					} catch (NumberFormatException nfe) {
						number = 0; // will be handled by default case
					}
					switch (number) {
					case 1:
						//Person mysteryJones = phonebook.findPersonWithLastName("Jones");
						break;
					case 2:
						//Person unknownPhoneNumber = phonebook.findPersonWithPhoneNumber(new PhoneNumber("12503342345"));
						break;
					case 3:
						//List<PhoneNumber> janeDoesDigits = phonebook.findPhoneNumbersOfPerson(new Person("Jane", "Doe"));
						break;
					case 4:	break;
					default:
						System.out.println("Please enter a number between 1 and 4");
						break;
					}
				}
				break;
			case 3:
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a number between 1 and 3");
				break;
			}
		}
	}

	private static boolean phonebookExists() {
		return new File(DEFAULT_PHONEBOOK_NAME).exists();
	}

	private static void generatePhonebook() {
		Phonebook phonebook = new Phonebook(Phonebook.generateRandomizedListOfPeople(5000));

		System.out.println("Sample:");
		for(int i=0; i < 5; i++) {
			System.out.println("#" + (i+1) + " - " + phonebook.get(i));
		}
		System.out.println();
		
		phonebook.save(DEFAULT_PHONEBOOK_NAME);
	}

	

}
