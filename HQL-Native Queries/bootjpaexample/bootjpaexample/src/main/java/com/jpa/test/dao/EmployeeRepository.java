package com.jpa.test.dao;

import com.jpa.test.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.annotation.PreDestroy;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {


    //declare custon finder methods
    public List<Employee> findByEmpName(String name);

    public List<Employee> findByEmpNameStartingWith(String name);

    public List<Employee> findByEmpNameEndingWith(String name);

    public List<Employee> findByEmpNameContaining(String name);

    public List<Employee> findByEmpSalaryLessThan(float salary);

    public List<Employee> findByEmpSalaryGreaterThanEqual(float salary);

    public List<Employee> findByEmpNameOrEmpCity(String name, String city);

    public List<Employee> findByEmpNameAndEmpCity(String name, String city);

    public List<Employee> findByEmpNameAndEmpSalaryLessThan(String name, float salary);


    /**
     * JPQL
     ***/
    @Query("SELECT emp FROM Employee emp")
    public List<Employee> getAllEMployee();

    @Query("SELECT emp FROM Employee emp WHERE emp.empName =:nm")
    public List<Employee> getByName(@Param("nm") String name);

    @Query("SELECT emp FROM Employee emp WHERE emp.empName =:nm and emp.empCity =:cty")
    public List<Employee> getByNameAndCity(@Param("nm") String name, @Param("cty") String city);



    /*@Modifying
    @Query("UPDATE Employee emp SET emp.empSalary =:sal WHERE emp.empId =:nm")
    @Transactional
    public List<Employee> updateSalary(@Param("sal") float salary, @Param("nm") int id);
*/
    //Native Query
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    public List<Employee> getEmployees();

    @Query(value = "SELECT * FROM employee emp WHERE emp.emp_name =:nm", nativeQuery = true)
    public List<Employee> getEmployeeByName(@Param("nm") String name);

    @Query(value = "SELECT * FROM employee emp WHERE emp.emp_name =:nm and emp.emp_city =:cty", nativeQuery = true)
    public List<Employee> getEmployeeByNameAndCity(@Param("nm") String name, @Param("cty") String city);


}
