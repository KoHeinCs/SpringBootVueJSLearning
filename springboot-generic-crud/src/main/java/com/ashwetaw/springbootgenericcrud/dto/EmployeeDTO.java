package com.ashwetaw.springbootgenericcrud.dto;

import lombok.Data;

/**
 * @author koheincs
 * @created at 26/04/2024
 **/
@Data
public class EmployeeDTO {
    private String id;
    private String name;
    private String phone;
    private String email;
    private String position;
    private String bio;
}
