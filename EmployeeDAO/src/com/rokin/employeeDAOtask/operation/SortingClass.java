/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.employeeDAOtask.operation;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import com.rokin.employeeDAOtask.dao.EmployeeDAO;
import com.rokin.employeeDAOtask.entity.Employee;
import java.util.Date;


/**
 *
 * @author rokin
 */
public class SortingClass {
    
    public void sortRecords(EmployeeDAO employeeDAOimpl, FileWriter brokenWriter) throws IOException
    {
        BufferedReader reader = new BufferedReader(new FileReader(new File("/home/rokin/NetBeansProjects/EmployeeDAOTask/test data.csv")));
        String line = "";

        while((line = reader.readLine()) != null)
        {
            String[] tokens = line.split(",");
            int count = 0;
            
            for (Employee e : employeeDAOimpl.getAll())
            {
                
                if (e.getFirstName().equals(tokens[1]) && e.getLastName().equals(tokens[2])
                        && e.getEmail().equals(tokens[3])) 
                {
                    count++;
                    if (count > 1) 
                    {
                        brokenWriter.append(e.toCSV());
                        employeeDAOimpl.delete(e);
                        break;
                    }
                }
                
            }
            
        }  
        
        FileWriter semiSortedWriter = new FileWriter("/home/rokin/NetBeansProjects/EmployeeDAOTask/Semi Sorted.csv");
        for(Employee e : employeeDAOimpl.getAll())
        {
            semiSortedWriter.append(e.toCSV());
            
        }
        semiSortedWriter.close();
       
        sortEmail( employeeDAOimpl, brokenWriter);
    }
    
    
    
    public void sortEmail(EmployeeDAO employeeDAOimpl, FileWriter brokenWriter) throws IOException
    {
        
        Date date = new Date();
        BufferedReader reader = new BufferedReader(new FileReader("/home/rokin/NetBeansProjects/EmployeeDAOTask/Semi Sorted.csv"));
        FileWriter okayWriter = new FileWriter("/home/rokin/NetBeansProjects/EmployeeDAOTask/okay_");
        String line = "";
        
        while ((line = reader.readLine()) != null) 
        {
            int count = 0;
            String[] tokens = line.split(",");
            
            for (Employee e : employeeDAOimpl.getAll()) 
            {
                if (e.getEmail().endsWith("@gmail.com") || e.getEmail().endsWith("@hotmail.com")
                        || e.getEmail().endsWith("@yahoo.com")) 
                {
                    
                    if (e.getEmail().equals(tokens[3])) 
                    {
                        count++;
                        
                        if (count > 1) 
                        {
                            brokenWriter.append(line);
                            employeeDAOimpl.delete(e);
                            break;
                        }
                    }
   
                }
                else 
                {
                    brokenWriter.append(e.toCSV());
                    employeeDAOimpl.delete(e);
                    break;
                }
            }
        }
        
        for(Employee e : employeeDAOimpl.getAll())
        {
            e.setStatus(e.getStatus().equals("1") ? "true" : "false");
            okayWriter.append(e.toCSV());
        }
        
      
        brokenWriter.close();
        okayWriter.close();
    }
    
}



    