package org.example.hibernate.secondary_table_example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {
            SessionFactory sessionFactory = new Configuration()
                    .configure("hibernate.cfg.xml")
                    .addAnnotatedClass(Teacher.class)
                    .addAnnotatedClass(Specialization.class)
                    .buildSessionFactory();

        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        Teacher teacher = new Teacher();
        teacher.setId(1);
        teacher.setType("Math");
        teacher.setPerson(new Person("Václav", "Malý"));
        session.persist(teacher); // uložení místo merge

        transaction.commit();

        session.close();

        session = sessionFactory.openSession();
        session.get(Teacher.class, 1);
        session.close();
    }
}
