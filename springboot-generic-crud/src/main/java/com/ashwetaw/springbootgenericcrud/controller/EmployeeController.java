package com.ashwetaw.springbootgenericcrud.controller;

import com.ashwetaw.springbootgenericcrud.dto.EmployeeDTO;
import com.ashwetaw.springbootgenericcrud.generic.BaseController;
import com.ashwetaw.springbootgenericcrud.service.EmployeeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static com.ashwetaw.springbootgenericcrud.common.ApiConstant.employee;

/**
 * @author koheincs
 * @created at 26/04/2024
 **/
@RestController
@RequestMapping(employee)
public class EmployeeController extends BaseController<EmployeeDTO,String> {
    public EmployeeController(EmployeeService employeeService) {
        super(employeeService);
    }
}
