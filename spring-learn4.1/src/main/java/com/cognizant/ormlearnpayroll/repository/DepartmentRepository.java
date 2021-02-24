package com.cognizant.ormlearnpayroll.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearnpayroll.model.Department;

/**
 * 
 * @author Danish
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
