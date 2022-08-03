package data.queries;

import data.connection.HibernateUtil;
import data.entity.Skills;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RequestsSkills {
    private Session openSession() {
        return HibernateUtil.getINSTANCE().getSessionFactory().openSession();
    }

    public void create(Skills skills) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(skills);
            transaction.commit();
        }
    }

    public Skills getById(int id) {
        try (Session session = openSession()) {
            return session.get(Skills.class, id);
        }
    }

    public List<Skills> listAll() {
        try (Session session = openSession()) {
            return session.createQuery("from Skills", Skills.class).list();
        }
    }

    public void deleteById(int id) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(getById(id));
            transaction.commit();
        }
    }

    public void update(Skills skills) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(skills);
            transaction.commit();
        }
    }
}
