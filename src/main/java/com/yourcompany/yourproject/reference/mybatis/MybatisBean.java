package com.yourcompany.yourproject.reference.mybatis;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.config.Springfield.Strategy;

@Springfield(
	strategy=Strategy.SQLSESSION,
	identity={"id"}
)
public @ToString @NoArgsConstructor @AllArgsConstructor class MybatisBean {

	@Getter @Setter private String id;
	@Getter @Setter private String password;
}
