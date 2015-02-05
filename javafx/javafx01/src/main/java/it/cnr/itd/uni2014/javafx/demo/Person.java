package it.cnr.itd.uni2014.javafx.demo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class Person {
	private StringProperty firstName;
	private StringProperty lastName;
	private IntegerProperty age;
	private BooleanProperty english;

	public Person() {
		super();
		firstName = new SimpleStringProperty();
		lastName = new SimpleStringProperty();
		age = new SimpleIntegerProperty();
		english = new SimpleBooleanProperty();
	}

	public String getFirstName() {
		return firstName.get();
	}

	public void setFirstName(String firstName) {
		this.firstName.set(firstName);
	}

	public String getLastName() {
		return lastName.get();
	}

	public void setLastName(String lastName) {
		this.lastName.set(lastName);
	}

	public Integer getAge() {
		return age.get();
	}

	public void setAge(Integer age) {
		this.age.set(age);
	}

	public Boolean getEnglish() {
		return english.getValue();
	}

	public void setEnglish(Boolean english) {
		this.english.set(english);
	}

	public StringProperty lastNameProperty() {
		return this.lastName;
	}

	public StringProperty firstNameProperty() {
		return this.firstName;
	}

	public IntegerProperty ageProperty() {
		return this.age;
	}

	public BooleanProperty englishProperty() {
		return this.english;
	}

	@Override
	public String toString() {
		return "Person [getFirstName()=" + getFirstName() + ", getLastName()="
				+ getLastName() + ", getAge()=" + getAge() + ", getEnglish()="
				+ getEnglish() + "]";
	}
}
