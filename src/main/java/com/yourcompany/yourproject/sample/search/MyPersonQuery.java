package com.yourcompany.yourproject.sample.search;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.repository.QueryMethod;
import com.yourcompany.yourproject.sample.person.Person;

@Springfield(
		entity=Person.class,
		topLevelMapping="/sample/search3", 
		methodLevelMapping="find"
)
@QueryMethod("findByNameAndSexOrderByAgeAsc")
public @ToString @NoArgsConstructor @AllArgsConstructor  class  MyPersonQuery {

	@Getter @Setter public String name;
	@Getter @Setter public Boolean sex;
}
