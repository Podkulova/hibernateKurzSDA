package org.example.hibernate;

import org.example.hibernate.dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .buildSessionFactory();

        // used to iteract with db
        Session session = sessionFactory.openSession();

        User honza = new User("Honza", "Novák");

        Transaction transaction = session.beginTransaction();

        // save to db
        session.merge(honza);
        transaction.commit();

        // retrive data
        List<User> fromUser = session.createQuery("FROM User", User.class).list();
        fromUser.forEach(System.out::println);

        // select * from User where id = 2
        User user = session.get(User.class, 2);
        System.out.println(user);

        session.close();
        sessionFactory.close();
    }
}
