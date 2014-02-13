package com.yourcompany.yourproject.sample.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.yourcompany.yourproject.sample.person.Person;


@Springfield(
		entity=Person.class,
		topLevelMapping="/sample/search1", 
		methodLevelMapping="find"
)
public @ToString @NoArgsConstructor @AllArgsConstructor class FindByAgeBetween {

	private @Getter @Setter Integer[] age;
}
