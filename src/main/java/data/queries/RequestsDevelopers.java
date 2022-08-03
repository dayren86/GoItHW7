package data.queries;

import data.connection.HibernateUtil;
import data.entity.Developers;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RequestsDevelopers {
    private Session openSession() {
        return HibernateUtil.getINSTANCE().getSessionFactory().openSession();
    }

    public void create(Developers developers) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(developers);
            transaction.commit();
        }
    }

    public Developers getById(int id) {
        try (Session session = openSession()) {
            return session.get(Developers.class, id);
        }
    }

    public List<Developers> listAll() {
        try (Session session = openSession()) {
            return session.createQuery("from Developers", Developers.class).list();
        }
    }

    public void deleteById(int id) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(getById(id));
            transaction.commit();
        }
    }

    public void update(Developers developers) {
        try(Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(developers);
            transaction.commit();
        }
    }
}
