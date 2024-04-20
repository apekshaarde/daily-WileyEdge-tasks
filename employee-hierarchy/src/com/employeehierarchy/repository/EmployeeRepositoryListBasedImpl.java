package com.employeehierarchy.repository;

import com.employeehierarchy.exception.InvalidEmployeeInfoException;
import com.employeehierarchy.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRepositoryListBasedImpl implements EmployeeRepository {


    List<Employee> employees;

    public EmployeeRepositoryListBasedImpl(){
        employees = new ArrayList<>();
    }

    public void saveEmployee(Employee employee) throws InvalidEmployeeInfoException {
        validateEmployee(employee);
       // validateEmployeeSecond(employee);
        employees.add(employee);
    }

    private void validateEmployee(Employee employee) throws InvalidEmployeeInfoException{
        if(employee.getId() < 0){
            throw new InvalidEmployeeInfoException("employee id must be positive");
        }
        if(employee.getName() == null){
            throw new InvalidEmployeeInfoException("employee name cannot be null");
        }
        if(employee.getEmail() == null){
            throw new InvalidEmployeeInfoException("employee email cannot be null, please enter your email");
        }
        if(employee.getSalary() <0){
            throw new InvalidEmployeeInfoException("salary cannot be negative, enter valid salary");
        }
    }

//    private void validateEmployeeSecond(Employee employee){
//        if(employee.getId() < 0){
//            throw new RuntimeException("employee id must be positive");
//        }
//        if(employee.getName() == null){
//            throw new RuntimeException("employee name cannot be null");
//        }
//        if(employee.getEmail() == null){
//            throw new RuntimeException("employee email cannot be null, please enter your email");
//        }
//        if(employee.getSalary() <0){
//            throw new RuntimeException("salary cannot be negative, enter valid salary");
//        }
//    }


    public Employee findEmployee(int id) {
        return employees.stream().filter(e->e.getId()==id).findFirst().get();
    }


    public void deleteEmployee(int id) {
        Employee employee = findEmployee(id);
        employees.remove(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }
}
