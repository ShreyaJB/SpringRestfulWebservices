package com.cognizant.ormlearnpayroll.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearnpayroll.model.Employee;
/**
 * 
 * @author Danish
 *
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	
	//@Query("select e from Employee e where e.permanent=1")
	@Query(value="SELECT e FROM Employee e left join fetch e.department d left join e.skillList WHERE e.permanent = 1") 
	public List<Employee> getAllPermanentEmployee();
	
//	@Query(value="delete from Employee e where e.id=:id")
//	public void deleteEmp(@Param("id") int id);

}
