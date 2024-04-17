package org.example.hibernate;

import org.example.hibernate.dao.Account;
import org.example.hibernate.dao.Order;
import org.example.hibernate.dao.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class SecondMain {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("hibernate.cfg.xml")
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Account.class)
                .addAnnotatedClass(Order.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();

        User user = new User("Jana", "Nováková");
        Account account = new Account(300, user);

        Transaction transaction = session.beginTransaction();

       // session.merge(user);
        session.merge(account);
        transaction.commit();

        session.close();
        sessionFactory.close();
    }
}
