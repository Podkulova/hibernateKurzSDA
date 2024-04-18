package org.example.hibernate.hql.dao;

import org.example.hibernate.hql.HibernateUtil;
import org.example.hibernate.hql.entity.Customer;
import org.example.hibernate.hql.entity.Product;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BaseDao<T> {
    public T saveEntity(T entity) {
        T ret = null;
        try (Session session = HibernateUtil.getInstance().openSession()) {
            Transaction transaction = session.beginTransaction();
            try {
                ret = session.merge(entity);
                transaction.commit();
            } catch (Exception e) {
                transaction.rollback();
            }
        }
        return ret;
    }

    protected Customer load(int id, Class<T> tClass) {
        Session session = HibernateUtil.getInstance().openSession();
        T o = session.get(tClass, id);
        session.close();;
        return o;
    }
}
