package com.yourcompany.yourproject.reference.hibernate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.HIBERNATE
)
@Entity
public @ToString @NoArgsConstructor @AllArgsConstructor class HibernateBean {

	@Id
	@Getter @Setter private String id;
	@Getter @Setter private String password;

}