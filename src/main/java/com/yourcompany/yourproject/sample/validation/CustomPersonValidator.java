package com.yourcompany.yourproject.sample.validation;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import com.u2ware.springfield.validation.EntityValidatorImpl;
import com.yourcompany.yourproject.sample.person.Person;


@Component
public class CustomPersonValidator extends EntityValidatorImpl<Person, CustomPerson>{

	@Override
	public void create(Person target, Errors errors) {
		logger.debug("Overide create ");
		super.create(target, errors); //JSR-303
		
		ValidationUtils.rejectIfEmpty(errors, "name", "customError");
	}

	@Override
	public void update(Person target, Errors errors) {
		super.update(target, errors);
		ValidationUtils.rejectIfEmpty(errors, "name", "customError");
	}

}