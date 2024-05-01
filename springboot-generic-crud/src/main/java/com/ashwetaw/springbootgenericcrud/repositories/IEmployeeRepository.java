package com.ashwetaw.springbootgenericcrud.repositories;

import com.ashwetaw.springbootgenericcrud.entities.Employee;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

/**
 * @author koheincs
 * @created at 26/04/2024
 **/
@EnableScan
public interface IEmployeeRepository extends CrudRepository<Employee,String> {
}
