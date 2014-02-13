package com.yourcompany.yourproject.security.member.info;

import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.DTO,
	methodLevelMapping={"updateForm.html","update.html"},
	identity="username"
)
public class MemberInfo {

	@Getter @Setter private @NotNull String username;
	
	@Getter @Setter private @NotNull String description;
	
}
