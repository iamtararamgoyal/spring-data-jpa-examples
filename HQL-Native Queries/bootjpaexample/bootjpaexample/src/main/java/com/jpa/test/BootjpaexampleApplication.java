package com.jpa.test;

import com.jpa.test.dao.EmployeeRepository;
import com.jpa.test.model.Employee;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.EnumMap;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableJpaRepositories({"com.jpa.test.dao"})
public class BootjpaexampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(BootjpaexampleApplication.class, args);

        EmployeeRepository employeeRepository = context.getBean(EmployeeRepository.class);

        /*
         * Create Employee
         * */

        /*
        Employee employee = new Employee();
        employee.seteId(1);
        employee.seteName("Tararam Goyal");
        employee.seteCity("Jodhpur");
        employee.seteSalary(55000);

        // Save Single record into database
        Employee emp = employeeRepository.save(employee);
        */

        /*// Create multiple employee records
        Employee emp1 = new Employee();
        emp1.seteName("Yogesh Sharma");
        emp1.seteCity("Odisha");
        emp1.seteSalary(35000);

        Employee emp2 = new Employee();
        emp2.seteName("Jogesh");
        emp2.seteCity("Karela");
        emp2.seteSalary(24000);

        Employee emp3 = new Employee();
        emp3.seteName("Arjun");
        emp3.seteCity("Jaipur");
        emp3.seteSalary(27000);


        List<Employee> emp = List.of(emp1, emp2, emp3);
        // Saving multiple records into database
        Iterable<Employee> employees = employeeRepository.saveAll(emp);

        System.out.println("All the employees are saved successfully");*/
//
//        employees.forEach(employee -> {
//            System.out.println(employee);
//        });

        /*//update the employee of id 7
        Optional<Employee> optional = employeeRepository.findById(10);
        Employee employee = optional.get();
        System.out.println("Employee: - " + employee);
        employee.seteName("Amit");
        Employee result = employeeRepository.save(employee);
        System.out.println("Employee Records Updated Successfully " + result);*/

        /*get data from database
         * Approch 1. findById
         * Approch 2. finaAllById
         * Approch 3. findAll
         * */

       /* //find particular record of employee from data
        Optional<Employee> emp = employeeRepository.findById(6);
        System.out.println("Employee (findById)" + emp);


        //find all the recods of employee from employee
        Iterable<Employee> employees = employeeRepository.findAll();
        employees.forEach(employee -> {System.out.println(employee);});*/


        // deteting the employee element from database
        /*delete element from database
         * Approch 1. delete
         * Approch 2. deleteAllById
         * Approch 3. deleteById
         * Approch 4. deleteAll
         * */

        /*//delete the employee id of 5
        employeeRepository.deleteById(5);
        System.out.println("Record Deleted Successfully");*/


        /*Iterable<Employee> employees = employeeRepository.findAll();

        System.out.println("Employees ");
        employees.forEach(emp -> {
            System.out.println(emp);
        });

        employeeRepository.deleteAll(employees);

        System.out.println("All Records Deleted !!");*/


        //custom finder methods

        // custom find by name method
        /*List<Employee> employeesName = employeeRepository.findByeName("Yogesh Sharma");
        employeesName.forEach(empName -> System.out.println(empName));
        */
        //custom find by name startwith
       /* List<Employee> employeesName = employeeRepository.findByeNameStartingWith("Ar");
        employeesName.forEach(empName -> System.out.println(employeesName));*/

        //custom find by name endingwith
        /*List<Employee> employeesName = employeeRepository.findByeNameEndingWith("t");
        employeesName.forEach(empName-> System.out.println(empName));*/

        //custom find by name containing
       /* List<Employee> employeesName = employeeRepository.findByeNameContaining("u");
        employeesName.forEach(empName-> System.out.println(empName));*/

        //custom find by salary less than
        /*List<Employee> employeesSalary = employeeRepository.findByeSalaryLessThan(30000);
        employeesSalary.forEach(empSalary -> System.out.println(empSalary));*/

        //custom find by salary greater than equal
       /* List<Employee> employeesSalary = employeeRepository.findByeSalaryGreaterThanEqual(30000);
        employeesSalary.forEach(empSalary -> System.out.println(empSalary));*/

        //Custom find by name or city
        /*List<Employee> byeNameAndeCity = employeeRepository.findByEmpNameOrEmpCity("Sumit", "Jaipur");
        byeNameAndeCity.forEach(employee -> System.out.println(employee));*/

        //Custom find by name and city
        /*List<Employee> employeesName = employeeRepository.findByEmpNameAndEmpCity("Sumit", "Jaipur");
        employeesName.forEach(empName -> System.out.println(empName));*/

       /* List<Employee> employees = employeeRepository.findByEmpNameAndEmpSalaryLessThan("Sumit", 25000);
        employees.forEach(empName -> System.out.println(empName));*/

        //JPQL
        /*List<Employee> allEMployee = employeeRepository.getAllEMployee();
        allEMployee.forEach(emp -> System.out.println(emp));*/

        /*List<Employee>empByName = employeeRepository.getByName("Jogesh");
        empByName.forEach(empName-> System.out.println(empName));*/

       /* List<Employee> byNameAndCity = employeeRepository.getByNameAndCity("Jogesh", "Jodhpur");
        byNameAndCity.forEach(employee -> System.out.println(employee));*/

        //Native Query
       /* List<Employee> employees = employeeRepository.getEmployees();
        employees.forEach(employee -> System.out.println(employee));*/

        /*List<Employee> employeeName = employeeRepository.getEmployeeByName("Jogesh");
        employeeName.forEach(employee ->System.out.println(employee) );*/

       /* List<Employee> employeesNameAndCity = employeeRepository.getEmployeeByNameAndCity("Jogesh", "Jodhpur");
        employeesNameAndCity.forEach(employee -> System.out.println(employee));*/

      /*  List<Employee> empUpdate = employeeRepository.updateSalary(45000, 8);
        empUpdate.forEach(empupdt -> System.out.println(empupdt));*/


    }

}
