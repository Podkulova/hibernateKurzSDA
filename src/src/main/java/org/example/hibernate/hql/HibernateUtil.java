package org.example.hibernate.hql;

import org.example.hibernate.hql.entity.Customer;
import org.example.hibernate.hql.entity.Order;
import org.example.hibernate.hql.entity.OrderItem;
import org.example.hibernate.hql.entity.Product;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
    SessionFactory sessionFactory;
    private static boolean isTest = false;

    private static HibernateUtil instance;
    public HibernateUtil() {
        sessionFactory = new Configuration()
                .configure(getconfigFile())
                .addAnnotatedClass(Customer.class)
                .addAnnotatedClass(Product.class)
                .addAnnotatedClass(Order.class)
                .addAnnotatedClass(OrderItem.class)
                .buildSessionFactory();
    }

    public static HibernateUtil getInstance() {
        if (instance == null) {
            instance = new HibernateUtil();
        }
        return instance;
    }

    public Session openSession() {
        return sessionFactory.openSession();
    }

    private String getconfigFile() {
        return isTest ? "test/hibernate.cfg.xml" : "test/hibernate.cfg.xml";
    }

    public static void setIsTest(boolean isTest) {
        HibernateUtil.isTest = isTest;
    }
}
