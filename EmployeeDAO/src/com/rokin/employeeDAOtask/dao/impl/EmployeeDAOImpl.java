/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.employeeDAOtask.dao.impl;
import com.rokin.employeeDAOtask.dao.EmployeeDAO;
import com.rokin.employeeDAOtask.entity.Employee;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rokin
 */
public class EmployeeDAOImpl implements EmployeeDAO{

    List<Employee> employeeList = new ArrayList<>();
    
    @Override
    public int insert(Employee e) {
        employeeList.add(e);
        return 1;
    }

    @Override
    public List<Employee> getAll() {
        return employeeList;
    }

    @Override
    public Employee getByID(int id) {
        for(Employee e : employeeList)
        {
            if(e.getId() == id)
            {
                return e;
            }
        }
        return null;
    }
    
}
