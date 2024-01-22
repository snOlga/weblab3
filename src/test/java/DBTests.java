import org.hibernate.ScrollableResults;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.junit.Test;

public class DBTests
{
    Response nullResponse = new Response();
    Response someResponse = new Response(0,0,3);
    Response maxResponse = new Response(Float.MAX_VALUE, Float.MAX_VALUE, Float.MAX_VALUE);

    @Test
    public void testWriteToDB()
    {
        DataBaseModule.writeToDB(someResponse);

        HibernateUtil hibernateUtil = new HibernateUtil();
        SessionFactory sessionFactory = hibernateUtil.getSessionFactory();
        try (Session session = sessionFactory.openSession()) {
            Query<Response> query = session.createQuery("FROM Response", Response.class);

            ScrollableResults<Response> scroll = query.scroll();
            scroll.last();
            Response lastEmployee = (Response) scroll.get();

            if(lastEmployee.equals(someResponse))
            {
                System.out.println("ok");
            }else
            {
                System.err.println("notok");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testCalculateNormal()
    {
        //someResponse.setR(3);
        boolean check = someResponse.calculate();
        if(check)
        {
            System.out.println("ok");
        } else System.err.println("notok");
    }

    @Test
    public void testCalculateMax()
    {
        boolean check = maxResponse.calculate();
        if(!check)
        {
            System.out.println("ok");
        } else System.err.println("notok");
    }
}
