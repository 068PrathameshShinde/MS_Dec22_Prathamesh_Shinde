package com.morningstar.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.morningstar.entity.Employee;

@Repository
public interface EmpRepository extends JpaRepository<Employee, Integer> {

	@Query(value = "select * from emp_table e  where e.email = ?1 and e.password = ?2",nativeQuery = true)
	Employee findEmployee(String email,String password);
}
