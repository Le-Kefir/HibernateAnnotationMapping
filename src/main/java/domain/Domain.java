package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

public class Domain {

    public static void main(String[] args) throws SQLException {

        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("USA");
        address.setCity("NY");
        address.setStreet("Liberty st.");
        address.setPostCode("10032");

        Employee employee = new Employee();
        employee.setFirstName("John");
        employee.setLastName("Doe");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1996, Calendar.MARCH, 7);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("New Life");

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        addressService.add(address);
        employeeService.add(employee);
        projectService.add(project);

//        Address address1 = addressService.getById(1l);
//        System.out.println(address1);

        HibernateUtil.shutdown();

    }


}
