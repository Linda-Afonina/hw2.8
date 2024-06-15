package pro.sky.EmployeeBookStreamAPI.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.EmployeeBookStreamAPI.Employee;
import pro.sky.EmployeeBookStreamAPI.service.EmployeeService;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("departments")
public class EmployeeController {
    public final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("max-salary")
    public Optional<Employee> getMaxSalary(@RequestParam("departmentId") int department) {
        return employeeService.getMaxSalary(department);
    }

    @GetMapping("min-salary")
    public Optional<Employee> getMinSalary(@RequestParam("departmentId") int department) {
        return employeeService.getMinSalary(department);
    }

    @GetMapping(value = "/all", params = "departmentId")
    public List<Employee> printEmployeesInDepartment(@RequestParam("departmentId") int department) {
        return employeeService.printEmployeesInDepartment(department);
    }

    @GetMapping("all")
    public Map<Integer, List<Employee>> printAllEmployees() {
        return employeeService.printAllEmployees();
    }

    @GetMapping("check")
    public Employee checkCorrectInput(
            @RequestParam("firstName") String firstName,
            @RequestParam("lastName") String lastName,
            @RequestParam("departmentId") int department,
            @RequestParam("salary") int salary) {
        return employeeService.checkCorrectInput(firstName, lastName, department, salary);
    }
}
