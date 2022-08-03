package data.queries;

import data.connection.HibernateUtil;
import data.entity.Companies;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RequestsCompanies {
    private Session openSession() {
        return HibernateUtil.getINSTANCE().getSessionFactory().openSession();
    }

    public void create(Companies companies) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(companies);
            transaction.commit();
        }
    }

    public Companies getById(int id) {
        try (Session session = openSession()) {
            return session.get(Companies.class, id);
        }
    }

    public List<Companies> listAll() {
        try (Session session = openSession()) {
            return session.createQuery("from Companies", Companies.class).list();
        }
    }

    public void deleteById(int id) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(getById(id));
            transaction.commit();
        }
    }

    public void update(Companies companies) {
        try(Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(companies);
            transaction.commit();
        }
    }
}
