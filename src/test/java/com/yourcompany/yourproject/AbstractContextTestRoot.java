package com.yourcompany.yourproject;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.servlet.Filter;
import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.mock.web.MockFilterConfig;
import org.springframework.mock.web.MockHttpSession;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.context.HttpSessionSecurityContextRepository;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.u2ware.springfield.support.i18n.LocaleChangeFilter;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:com/yourcompany/yourproject/root-context.xml")
@WebAppConfiguration
public class AbstractContextTestRoot {

	protected final Logger logger = LoggerFactory.getLogger(getClass());

	@Autowired @Qualifier("springSecurityFilterChain")
	protected Filter springSecurityFilterChain;
	
	@Autowired
	protected WebApplicationContext applicationContext;

	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		if(mockMvc == null){
			this.mockMvc = MockMvcBuilders.webAppContextSetup(applicationContext)
					.addFilters(createLocaleChangeFilter())
					.addFilters(springSecurityFilterChain)
					.build();
		}
	}
	
	protected Filter createLocaleChangeFilter() {
	    try{
	        LocaleChangeFilter localeChangeFilter = new LocaleChangeFilter();
	        localeChangeFilter.init(new MockFilterConfig(applicationContext.getServletContext()));
	        return localeChangeFilter;
	    }catch(ServletException e){
	        e.printStackTrace();
	        return null;
	    }
	}	 
	
	
	@Test
	public void printBeans() throws Exception {
		logger.warn("===================================================");
		String[] beanNames = applicationContext.getBeanDefinitionNames();
		Arrays.sort(beanNames, 0, beanNames.length);
		for(String name : beanNames){
			logger.warn(name+"="+applicationContext.getBean(name).getClass());
		}
		logger.warn("===================================================");
	}
	 
	
	protected MockHttpSession login() throws Exception {
		MockHttpSession httpSession = new MockHttpSession(); 
		
 		String principal = "a";
		String credentials = "a";
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority("ROLE_ANONYMOUS"));
		authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
		authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
		
		
		UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(principal, credentials, authorities);
		httpSession.setAttribute(HttpSessionSecurityContextRepository.SPRING_SECURITY_CONTEXT_KEY,  SecurityContextHolder.getContext());
		SecurityContextHolder.getContext().setAuthentication(authentication);
		logger.debug("===========================================================");
		logger.debug(""+SecurityContextHolder.getContext().getAuthentication());
		logger.debug("===========================================================");
		
		return httpSession;
	}
}
