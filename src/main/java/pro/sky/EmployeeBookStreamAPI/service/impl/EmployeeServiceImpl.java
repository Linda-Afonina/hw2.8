package pro.sky.EmployeeBookStreamAPI.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pro.sky.EmployeeBookStreamAPI.Employee;
import pro.sky.EmployeeBookStreamAPI.exceptions.IncorrectInputException;
import pro.sky.EmployeeBookStreamAPI.service.EmployeeService;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    List<Employee> employees = new ArrayList<>();

    public EmployeeServiceImpl() {
        employees.add(new Employee("Елена Геннадьевна", "Новикова", 4, 108940));
        employees.add(new Employee("Сергей Иванович", "Голиков", 4, 67520));
        employees.add(new Employee("Олег Петрович", "Кондратьев ", 2, 95080));
        employees.add(new Employee("Инна Ивановна", "Соколова", 2, 72670));
        employees.add(new Employee("Алексей Владимирович", "Петров", 3, 85880));
        employees.add(new Employee("Кирилл Александрович", "Григорьев", 3, 64230));
        employees.add(new Employee("Ольга Михайловна", "Нестерова", 1, 89950));
        employees.add(new Employee("Кирилл Александрович", "Меньшов", 1, 101570));
        employees.add(new Employee("Наталья Юрьевна", "Меньшова", 5, 72290));
        employees.add(new Employee("Светлана Николаевна", "Королькова", 5, 96440));
    }

    @Override
    public Optional<Employee> getMaxSalary(int department) {

        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .max(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public Optional<Employee> getMinSalary(int department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .min(Comparator.comparingInt(employee -> employee.getSalary()));
    }

    @Override
    public List<Employee> printEmployeesInDepartment(int department) {
        return employees.stream()
                .filter(employee -> employee.getDepartment() == department)
                .collect(Collectors.toList());
    }

    @Override
    public Map<Integer, List<Employee>> printAllEmployees() {
        Map<Integer, List<Employee>> collect = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return collect;

    }

    @Override
    public Employee checkCorrectInput(String firstName, String lastName, int department, int salary) {
        Employee employee = new Employee(firstName, lastName, department, salary);
        if (StringUtils.isAlpha(firstName) && StringUtils.isAlpha(lastName)) {
            employees.add(employee);
        } else
            throw new IncorrectInputException("ФИО должно содержать только буквы!");

        return employee;
    }
}
