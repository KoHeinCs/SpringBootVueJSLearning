package com.ashwetaw.springbootgenericcrud.mapper;

import com.ashwetaw.springbootgenericcrud.dto.EmployeeDTO;
import com.ashwetaw.springbootgenericcrud.entities.Employee;
import com.ashwetaw.springbootgenericcrud.generic.IBaseMapper;
import org.mapstruct.Mapper;

/**
 * @author koheincs
 * @created at 26/04/2024
 **/
@Mapper(componentModel = "spring")
public interface IEmployeeMapper extends IBaseMapper<EmployeeDTO, Employee> {
}
