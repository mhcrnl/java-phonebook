package com.nickknowlson.phonebook.tests;

import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import com.nickknowlson.phonebook.Person;
import com.nickknowlson.phonebook.Phonebook;

public class PhonebookTest {
	
	// should be able to return multiple people with the same last name
	@Test
	public void shouldFindAllPeopleWithSameLastName() {
		List<Person> peopleWithSameLastNames = new ArrayList<Person>();
		peopleWithSameLastNames.add(new Person("Jane", "Doe"));
		peopleWithSameLastNames.add(new Person("John", "Doe"));
		peopleWithSameLastNames.add(new Person("Joshua", "Bloch"));
		peopleWithSameLastNames.add(new Person("James", "Gosling"));
		
		Phonebook examplePhonebook = new Phonebook(peopleWithSameLastNames);
		
		List<Person> peopleWithLastNameDoe = examplePhonebook.findPeopleWithLastName("Doe");
		
		assert(peopleWithLastNameDoe.size() == 2);
	}
	
	// should be able to return multiple people with the same first + last names
	@Test
	public void shouldFindAllPeopleWithSameFirstAndLastNames() {
		List<Person> peopleWithSameFullNames = new ArrayList<Person>();
		peopleWithSameFullNames.add(new Person("Jane", "Doe"));
		peopleWithSameFullNames.add(new Person("Jane", "Doe"));
		peopleWithSameFullNames.add(new Person("Joshua", "Bloch"));
		peopleWithSameFullNames.add(new Person("James", "Gosling"));
		
		Phonebook examplePhonebook = new Phonebook(peopleWithSameFullNames);
		
		List<Person> janeDoes = examplePhonebook.findPhoneNumbersOfPerson(new Person("Jane", "Doe"));
		
		assert(janeDoes.size() == 2);
	}
	
	// should not let duplicate phone numbers be added
	@Test
	public void shouldNotAllowDuplicatePhoneNumbers() {
		assert false;
		/*
		List<Person> peopleWithDuplicatePhoneNumbers = new ArrayList<Person>();
		peopleWithDuplicatePhoneNumbers.add(new Person("Jane", "Doe"));
		peopleWithDuplicatePhoneNumbers.add(new Person("John", "Doe"));
		peopleWithDuplicatePhoneNumbers.add(new Person("Joshua", "Bloch"));
		peopleWithDuplicatePhoneNumbers.add(new Person("James", "Gosling"));
		
		Phonebook examplePhonebook = new Phonebook(peopleWithDuplicatePhoneNumbers);
		*/
	}
}
