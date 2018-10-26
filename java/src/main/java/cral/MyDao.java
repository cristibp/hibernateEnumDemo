package cral;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyDao {

    @Autowired
    private SessionFactory sessionFactory;


    void save(MyEntity myEntity) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(myEntity);
        session.flush();
        transaction.commit();
        String enumValue = (String) session.createNativeQuery("select myEnum from MyEntity").list().get(0);
        System.out.println(enumValue);
        session.close();
    }

}
