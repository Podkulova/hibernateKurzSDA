package org.example.hibernate.hql.entity;

import org.example.hibernate.hql.HibernateUtil;
import org.example.hibernate.hql.dao.CustomerDao;
import org.example.hibernate.hql.dao.OrderDao;
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
    ProductDao productDao = new ProductDao();
    CustomerDao customerDao = new CustomerDao();
    @Test
    public  void createOrder() {
        Customer customer = customerDao.saveCustomer("Lucka", "Brno", "Přímá", 2);

        Product product = productDao.saveProduct("MacBook", 10000, 10);
        Product product2 = productDao.saveProduct("Asus", 1000, 10);

        Order order = dao.createOrder(customer.getId(), product.getId(), product2.getId());

        assertTrue(order.getId() > 0);
    }

    }