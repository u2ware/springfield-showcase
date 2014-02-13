package com.yourcompany.yourproject.sample.views;

import com.u2ware.springfield.config.Springfield;
import com.yourcompany.yourproject.sample.person.Person;

@Springfield(
		entity=Person.class,
		topLevelMapping="/sample/views", 
		methodLevelMapping="find.json"
)
public class JsonSample {

}
