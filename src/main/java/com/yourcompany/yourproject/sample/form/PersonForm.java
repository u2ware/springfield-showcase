package com.yourcompany.yourproject.sample.form;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.DTO,
	identity={"id"}
)
public class PersonForm {

	private @Getter @Setter String id;
	
	private @Getter @Setter String display;
	
}
