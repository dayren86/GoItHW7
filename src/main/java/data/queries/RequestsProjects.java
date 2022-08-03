package data.queries;

import data.connection.HibernateUtil;
import data.entity.Projects;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class RequestsProjects {
    private Session openSession() {
        return HibernateUtil.getINSTANCE().getSessionFactory().openSession();
    }

    public void create(Projects projects) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(projects);
            transaction.commit();
        }
    }

    public Projects getById(int id) {
        try (Session session = openSession()) {
            return session.get(Projects.class, id);
        }
    }

    public List<Projects> listAll() {
        try (Session session = openSession()) {
            return session.createQuery("from Projects", Projects.class).list();
        }
    }

    public void deleteById(int id) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.remove(getById(id));
            transaction.commit();
        }
    }

    public void update(Projects projects) {
        try (Session session = openSession()) {
            Transaction transaction = session.beginTransaction();
            session.merge(projects);
            transaction.commit();
        }
    }
}
