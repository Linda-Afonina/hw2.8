package pro.sky.EmployeeBookStreamAPI.service;

import pro.sky.EmployeeBookStreamAPI.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> employees = new ArrayList<>();

    Optional<Employee> getMaxSalary(int department);

    Optional<Employee> getMinSalary(int department);

    List<Employee> printEmployeesInDepartment(int department);

    Map<Integer, List<Employee>> printAllEmployees();

    public Employee checkCorrectInput(String firstName, String lastName, int department, int salary);
}
