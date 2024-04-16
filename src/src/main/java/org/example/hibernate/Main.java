package org.example.hibernate;

import org.example.hibernate.dao.Account;
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
                .addAnnotatedClass(Account.class)
                .buildSessionFactory();

        // used to iteract with db
        Session session = sessionFactory.openSession();

        User honza = new User("Honza", "Novák");

        Transaction transaction = session.beginTransaction();

        // save to db
        session.merge(honza);

        // retrive data
        List<User> fromUser = session.createQuery("FROM User", User.class).list();
        fromUser.forEach(System.out::println);

        // select * from User where id = 1
        User user = session.get(User.class, 1);

        Account account = session.get(Account.class, 1);

        if(account == null) {
            Account account1 = new Account(200, user);
            session.merge(account1);
        }

        transaction.commit();

        session.createQuery("FROM Account", Account.class)
                .list()
                .forEach(System.out::println);

        User user1 = session.get(User.class, 1);
        System.out.println(user1);

        session.close();
        sessionFactory.close();
    }
}
