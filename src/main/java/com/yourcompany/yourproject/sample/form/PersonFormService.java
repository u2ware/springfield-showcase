package com.yourcompany.yourproject.sample.form;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.u2ware.springfield.domain.Pagination;
import com.u2ware.springfield.repository.EntityRepository;
import com.u2ware.springfield.service.EntityService;
import com.yourcompany.yourproject.sample.person.Person;

@Service
@Transactional
public class PersonFormService implements EntityService<PersonForm, PersonForm>{

	@Autowired @Qualifier("personRepository")
	private EntityRepository<Person, String> personRepository;
	
	private ObjectMapper mapper = new ObjectMapper();
	
	private PersonForm convert(Person person) {
		try {
			PersonForm result = new PersonForm();
			result.setId(person.getId());
			result.setDisplay(mapper.writeValueAsString(person));
			return result;
		} catch (JsonProcessingException e) {
			throw new RuntimeException(e);
		}
	}
	private List<PersonForm> convert(List<Person> persons) {
		List<PersonForm> result = new ArrayList<PersonForm>();
		for(Person p : persons){
			result.add(convert(p));
		}
		return result;
	}
	
	
	@Override
	public Iterable<?> find(PersonForm query, Pageable pageable){
		
		Page<Person> personPage =  personRepository.findAll(pageable);
		List<Person> persons = personPage.getContent();
		long total = personPage.getTotalElements();
		List<PersonForm> content = convert(persons);

		Pagination<PersonForm> result = new Pagination<PersonForm>(content, pageable, total);
		return result;
	}

	@Override
	public PersonForm read(PersonForm entity) {
		return entity;
	}

	@Override
	public PersonForm createForm(PersonForm entity) {
		return entity;
	}

	@Override
	public PersonForm create(PersonForm entity) {
		
		Person p = new Person();
		p.setId(entity.getId());
		p.setName("name"+entity.getId());
		p.setAge(new Random().nextInt());
		p.setBirthday(new DateTime());
		p.setSex(new Random().nextBoolean());
		
		personRepository.save(p);
		
		return convert(p);
	}

	@Override
	public PersonForm updateForm(PersonForm entity) {
		return entity;
	}

	@Override
	public PersonForm update(PersonForm entity) {
		return entity;
	}

	@Override
	public PersonForm delete(PersonForm entity) {
		return entity;
	}



}