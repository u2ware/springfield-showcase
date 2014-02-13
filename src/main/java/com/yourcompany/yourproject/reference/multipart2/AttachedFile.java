package com.yourcompany.yourproject.reference.multipart2;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Transient;

import lombok.Getter;
import lombok.Setter;

import org.springframework.web.multipart.MultipartFile;

import com.u2ware.springfield.config.Springfield;
import com.u2ware.springfield.view.multipart.MultipartFileBean;

@Springfield(
	methodLevelMapping={"*","read.stream","read.download"}
)
@Entity
public class AttachedFile implements MultipartFileBean{
	
	@Transient 
	private @Getter @Setter MultipartFile multipartFile;
	
	@Id @GeneratedValue
	private @Getter @Setter Integer id;
	private @Getter @Setter String contentFile;
	private @Getter @Setter String contentName;
	private @Getter @Setter String contentType;
	private @Getter @Setter Long contentSize;
	

}