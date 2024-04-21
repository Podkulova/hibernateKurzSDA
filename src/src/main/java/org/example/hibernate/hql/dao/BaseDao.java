package org.example.hibernate.hql.dao;

import org.example.hibernate.hql.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.*;

public abstract class BaseDao<T> {
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

    protected T load(int id, Class<T> tClass) {
        Session session = HibernateUtil.getInstance().openSession();
        T o = session.get(tClass, id);
        session.close();;
        return o;
    }

    public List<T> load(Class<T> customerClass, Integer ... listOfIds){
        Session session = HibernateUtil.getInstance().openSession();
        String hql = "FROM " + customerClass.getSimpleName() + " e WHERE e.id IN (:listIds) ";
        List<T> list = session
                .createQuery(hql, customerClass)
                .setParameterList("listIds", Arrays.asList(listOfIds))
                .list();
        session.close();
        return list;
    }
}
