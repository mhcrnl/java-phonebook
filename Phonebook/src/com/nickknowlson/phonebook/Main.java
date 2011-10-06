package com.nickknowlson.phonebook;


public class Main {

	public static void main(String[] args) {
		
		Phonebook phonebook = new Phonebook(Phonebook.generateRandomizedListOfPeople(5000));
		
		int i = 1;
		for(Person person : phonebook) {
			System.out.println("#" + i + " - " + person);
		}
		
		//Person mysteryJones = phonebook.findPersonWithLastName("Jones");
		//Person unknownPhoneNumber = phonebook.findPersonWithPhoneNumber(new PhoneNumber("12503342345"));
		//List<PhoneNumber> janeDoesDigits = phonebook.findPhoneNumbersOfPerson(new Person("Jane", "Doe"));
		
		//

	}

	

}
