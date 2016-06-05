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
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;


/**
 *
 * @author rokin
 */
public class OperationClass {
    
//    public void initializeEmployeeList() throws IOException
//    {
//        BufferedReader reader = new BufferedReader(new FileReader(new File("/home/rokin/NetBeansProjects/EmployeeDAOTask/test data.csv")));
//        EmployeeDAO employeeDAOimpl = new EmployeeDAOImpl();
//        StringBuilder builder = new StringBuilder();
//        String line ="";
//        while((line = reader.readLine()) != null)
//        {
//            
//            employeeDAOimpl.insert(new Employee(token[0], token[1], token[2], token, line, 0, 0))
//        }
//    }
    public void readFile() throws IOException
    {
        EmployeeDAO employeeDAOimpl = new EmployeeDAOImpl();
        FileWriter brokenWriter = new FileWriter("/home/rokin/NetBeansProjects/EmployeeDAOTask/broken.txt");
        BufferedReader reader = new BufferedReader(new FileReader(new File("/home/rokin/NetBeansProjects/EmployeeDAOTask/test data.csv")));
        StringBuilder builder = new StringBuilder();
        String line ="";
        while((line = reader.readLine()) != null)
        {
            String[] tokens = line.split(",");
            
            if(tokens.length>=6)
            {
                
                    if (tokens[1] != null && tokens[2] != null && tokens[3] != null && tokens[5] != null) 
                    {
                        employeeDAOimpl.insert(new Employee(Integer.parseInt(tokens[0]), tokens[1], tokens[2], tokens[3], tokens[4], tokens[5], Integer.parseInt(tokens[6])));
                    }

                    else
                    {
                        
                    }
                
            }
            else
            {
                brokenWriter.write(line);
            }    
        }    
        reader.close();
        
        while((line = reader.readLine()) != null)
        {
            String[] tokens = line.split(",");
        }
    }
    
    
 
}
