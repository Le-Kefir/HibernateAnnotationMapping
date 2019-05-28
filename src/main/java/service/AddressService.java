package service;

import bl.SessionUtil;
import dao.AddressDAO;
import entity.Address;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.SQLException;
import java.util.List;

public class AddressService extends SessionUtil implements AddressDAO {

    public void add(Address address) throws SQLException {
        //open session with a transaction
        openTransactionSession();

        Session session =getSession();
        session.save(address);

        //close session on with a transaction
        closeTransactionSession();
    }

    public List<Address> getAll() throws SQLException {
        openTransactionSession();

        String sql = "select * from address";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        List<Address> addressList = query.list();

        closeTransactionSession();

        return addressList;
    }

    public Address getById(Long id) throws SQLException {
        openTransactionSession();

        String sql = "select * from address where id = :id";

        Session session = getSession();
        Query query = session.createNativeQuery(sql).addEntity(Address.class);
        query.setParameter("id", id);

        Address address = (Address) query.getSingleResult();

        closeTransactionSession();

        return address;
    }

    public void update(Address address) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.update(address);

        closeTransactionSession();
    }

    public void remove(Address address) throws SQLException {
        openTransactionSession();

        Session session = getSession();
        session.remove(address);

        closeTransactionSession();
    }
}
