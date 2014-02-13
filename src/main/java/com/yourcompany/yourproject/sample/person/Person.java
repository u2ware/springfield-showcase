package com.yourcompany.yourproject.sample.person;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import org.joda.time.DateTime;
import org.springframework.format.annotation.DateTimeFormat;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.view.multipart.DownloadBean;


@Springfield
@Entity
public @ToString @NoArgsConstructor @AllArgsConstructor class Person implements DownloadBean{

	@Id
	private @Getter @Setter String id;
	
	private @Getter @Setter String name;

	private @Getter @Setter Integer age;

	@DateTimeFormat(pattern="yyyy-MM-dd")
	@org.hibernate.annotations.Type(type="org.joda.time.contrib.hibernate.PersistentDateTime")
	private @Getter @Setter DateTime birthday;	
	
	private @Getter @Setter Boolean sex;

	@Override
	public String getContentName() {
		return "엑셀 다운로드 파일명";
	}
}