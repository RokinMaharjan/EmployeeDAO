/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.employeeDAOtask.operation;

import com.rokin.employeeDAOtask.dao.EmployeeDAO;
import com.rokin.employeeDAOtask.dao.impl.EmployeeDAOImpl;
import com.rokin.employeeDAOtask.entity.Employee;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author rokin
 */
public class OperationClass {
    

    public void initializeList() throws IOException
    {
        EmployeeDAO employeeDAOimpl = new EmployeeDAOImpl();
        FileWriter brokenWriter = new FileWriter("/home/rokin/NetBeansProjects/EmployeeDAOTask/Broken Data.csv");
        BufferedReader reader = new BufferedReader(new FileReader(new File("/home/rokin/NetBeansProjects/EmployeeDAOTask/Test Data.csv")));
        
        String line ="";
        while((line = reader.readLine()) != null)
        {
            String[] tokens = line.split(",");
            if (!tokens[1].equals("") && !tokens[2].equals("") && !tokens[3].equals("") && !tokens[5].equals("") && !tokens[6].equals("")) 
            {
                employeeDAOimpl.insert(new Employee(tokens[0], tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], tokens[6]));
            }
            else
            {
                brokenWriter.write((line + "\n"));
            }
        }   
   
        SortingClass sortingClass = new SortingClass();
        sortingClass.sortRecords(employeeDAOimpl, brokenWriter);
 
    }

}
