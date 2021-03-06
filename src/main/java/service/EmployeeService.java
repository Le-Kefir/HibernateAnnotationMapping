package service;

import bl.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class EmployeeService extends SessionUtil implements EmployeeDAO {

    public void add(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.save(employee);

        closeTransactionSession();
    }

    public List<Employee> getAll() throws SQLException {
        openTransactionSession();

        String sql = "select * from employee";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> employeeList = query.list();

        closeTransactionSession();

        return employeeList;

    }

    public Employee getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "select * from employee where id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();

        closeTransactionSession();

        return employee;
    }

    public void update(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(employee);

        closeTransactionSession();
    }

    public void remove(Employee employee) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(employee);

        closeTransactionSession();
    }
}
