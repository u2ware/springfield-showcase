package com.yourcompany.yourproject.security.admin.member;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;
import com.u2ware.springfield.repository.QueryMethod;
import com.yourcompany.yourproject.security.Users;

@Springfield(
	strategy=Strategy.JPA,
	entity=Users.class,
	methodLevelMapping={"*.html"}
)
@QueryMethod("findByUsername")
public class AdminMember {

	@Getter @Setter private String username;

}
