package org.example.hibernate.hql.entity;

import org.example.hibernate.hql.HibernateUtil;
import org.example.hibernate.hql.dao.ProductDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {
    @BeforeAll
    static void init() {
        HibernateUtil.setIsTest(true);
    }
    OrderDao dao = new OrderDao();
    @Test
    public  void createOrder() {
        Product product = dao.saveProduct("MacBook", 50000, 10);
        assertTrue(product.getId() != 0);
    }
}