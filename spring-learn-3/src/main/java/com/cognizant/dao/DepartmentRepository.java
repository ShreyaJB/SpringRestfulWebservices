package com.cognizant.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.cognizant.model.Department;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
