package data.connection;

import data.entity.Companies;
import data.entity.Developers;
import data.entity.Projects;
import data.entity.Skills;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    private static final HibernateUtil INSTANCE;

    private final SessionFactory sessionFactory;

    static {
        INSTANCE = new HibernateUtil();
    }

    private HibernateUtil() {
        sessionFactory = new Configuration()
                .addAnnotatedClass(Companies.class)
                .addAnnotatedClass(Developers.class)
                .addAnnotatedClass(Projects.class)
                .addAnnotatedClass(Skills.class)
                .buildSessionFactory();

    }

    public static HibernateUtil getINSTANCE() {
        return INSTANCE;
    }

    public SessionFactory getSessionFactory() {
        return sessionFactory;
    }

    public void close() {
        sessionFactory.close();
    }
}
