package com.cognizant.ormlearnpayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearnpayroll.model.Skill;
/**
 * 
 * @author Danish
 *
 */
@Repository
public interface SkillRepository extends JpaRepository<Skill, Integer> {

}
