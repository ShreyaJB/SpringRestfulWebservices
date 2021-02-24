package com.cognizant.ormlearnpayroll.service;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.cognizant.ormlearnpayroll.model.Employee;
import com.cognizant.ormlearnpayroll.model.Skill;
import com.cognizant.ormlearnpayroll.repository.SkillRepository;

/**
 * 
 * @author Danish
 *
 */

@Service
public class SkillService {

	@Autowired
	private SkillRepository repository;
	private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);
	@Transactional
	public void saveSkill(Skill skill)
	{
		LOGGER.info("Start");
		repository.save(skill);
		LOGGER.info("End");
	}
	
	@Transactional
	public Skill get(int id)
	{
		LOGGER.info("Start");
		return repository.findById(id).get();
	}
	
	
}
