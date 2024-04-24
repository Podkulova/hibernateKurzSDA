package org.example.hibernate.benefits_of_abstract;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class DbStorage extends Storage{
    @Override
    public User2 findUser(String name) {
        Session session = HibernateUtil.getInstance().openSession();
        User2 user = session.get(User2.class, name);
        session.close();
        return user;
    }

    @Override
    public void addUser(User2 user) {
        Session session = HibernateUtil.getInstance().openSession();
        Transaction transaction = session.beginTransaction();
        session.persist(user);
        transaction.commit();
        session.close();
    }

    @Override
    public void setDeposit(User2 user, int amount) {
        Session session = HibernateUtil.getInstance().openSession();
        user.setDeposit(amount);

        Transaction transaction = session.beginTransaction();
        session.merge(user);
        transaction.commit();

        session.close();

    }
}
