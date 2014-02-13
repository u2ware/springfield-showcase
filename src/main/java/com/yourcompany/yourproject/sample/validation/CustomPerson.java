package com.yourcompany.yourproject.sample.validation;

import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.yourcompany.yourproject.sample.person.Person;

@Springfield(
	entity=Person.class
)
public @ToString class CustomPerson {
	
}