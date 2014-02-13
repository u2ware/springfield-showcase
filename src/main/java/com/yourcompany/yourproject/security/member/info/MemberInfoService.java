package com.yourcompany.yourproject.security.member.info;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.u2ware.springfield.repository.EntityRepository;
import com.u2ware.springfield.service.EntityServiceImpl;
import com.yourcompany.yourproject.security.AuthenticationContext;
import com.yourcompany.yourproject.security.Users;


@Service
public class MemberInfoService extends EntityServiceImpl<MemberInfo, MemberInfo>{

	@Autowired
	protected AuthenticationContext authenticationContext;
	
	@Autowired @Qualifier("usersRepository")
	private EntityRepository<Users, String> usersRepository;

	////////////////////////////
	//
	////////////////////////////
	@Override
	public MemberInfo updateForm(MemberInfo entity) {
		String username = authenticationContext.getUsername();
		Users user = usersRepository.findOne(username);
		entity.setUsername(username);
		entity.setDescription(user.getDescription());
		return entity;
	}	
	
	@Override
	@Transactional
	public MemberInfo update(MemberInfo entity) {

		String username = authenticationContext.getUsername();
		Users user = usersRepository.findOne(username);
		user.setDescription(entity.getDescription());
		return entity;
	}	
}
