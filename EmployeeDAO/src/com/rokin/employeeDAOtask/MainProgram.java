/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.employeeDAOtask;
import com.rokin.employeeDAOtask.operation.OperationClass;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;



/**
 *
 * @author rokin
 */
public class MainProgram {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            OperationClass operation = new OperationClass();
            operation.readFile();
        } catch (IOException ex) {
            System.out.println("Exception: " + ex.getMessage());
        }
    }
    
}
