/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.employeeDAOtask.dao;

import com.rokin.employeeDAOtask.entity.Employee;
import java.util.List;

/**
 *
 * @author rokin
 */
public interface EmployeeDAO {
    int insert(Employee e);
    List<Employee> getAll();
    Employee getByID(String id); 
    int delete(Employee e);
}
