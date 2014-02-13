package com.yourcompany.yourproject.sample.search;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.yourcompany.yourproject.sample.person.Person;

@Springfield(
		entity=Person.class,
		topLevelMapping="/sample/search2", 
		methodLevelMapping="find"
)
public class FindByNameOrderByAgeDesc {
	
	@Getter @Setter private String name;
}
