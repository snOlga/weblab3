import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class DataBaseModule
{
    public static void writeToDB(Response item)
    {
        //HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        Session session = sessionFactory.openSession();

        try {
            session.beginTransaction();

            Response entity = item;

            session.save(entity);

            session.getTransaction().commit();
        } catch (Exception e) {
            if (session.getTransaction() != null) {
                session.getTransaction().rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        //sessionFactory.close();
    }

    public static List<Response> getFromDBList() {
        List<Response> entityList = new ArrayList<Response>();
        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Response> query = session.createQuery("FROM Response", Response.class);
            entityList = query.list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return entityList;
    }
}
