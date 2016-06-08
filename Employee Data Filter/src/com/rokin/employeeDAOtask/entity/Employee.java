/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rokin.employeeDAOtask.entity;

/**
 *
 * @author rokin
 */
public class Employee {
    
    private String id, firstName, lastName, email, phone, salary, status;

    public Employee() {
    }

    public Employee(String id, String firstName, String lastName, String email, String phone, String salary, String status) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" + "id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", phone=" + phone + ", salary=" + salary + ", status=" + status + '}';
    }

    
    
    public String toCSV()
    {
        return id + "," + firstName + "," + lastName + "," + email + "," + phone + "," + salary + "," + status + "\r\n";
    }
}
