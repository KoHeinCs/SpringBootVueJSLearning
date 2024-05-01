package com.ashwetaw.springbootgenericcrud.service;

import com.ashwetaw.springbootgenericcrud.dto.EmployeeDTO;
import com.ashwetaw.springbootgenericcrud.entities.Employee;
import com.ashwetaw.springbootgenericcrud.generic.BaseService;
import com.ashwetaw.springbootgenericcrud.mapper.IEmployeeMapper;
import com.ashwetaw.springbootgenericcrud.repositories.IEmployeeRepository;
import org.springframework.stereotype.Service;

/**
 * @author koheincs
 * @created at 26/04/2024
 **/
@Service
public class EmployeeService extends BaseService<EmployeeDTO, Employee,String> {
    public EmployeeService(IEmployeeRepository employeeRepository, IEmployeeMapper employeeMapper) {
        super(employeeRepository, employeeMapper);
    }
}
