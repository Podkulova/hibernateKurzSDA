package org.example.hibernate.extends_example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class Main {
    public static void main(String[] args) {
        SessionFactory sessionFactory = new Configuration()
                .configure("test/hibernate.cfg.xml")
                .addAnnotatedClass(ComputerGame.class)
                .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        ComputerGame computerGame = new ComputerGame();
        computerGame.setName("CoD");
        computerGame.setDescription("war");
        computerGame.setType("first person");

        transaction.commit();

        session.close();


    }
}
