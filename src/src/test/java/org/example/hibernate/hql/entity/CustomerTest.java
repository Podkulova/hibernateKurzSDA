package org.example.hibernate.hql.entity;

import org.example.hibernate.hql.HibernateUtil;
import org.example.hibernate.hql.dao.CustomerDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CustomerTest {
    @BeforeAll
    static void init() {
        HibernateUtil.setIsTest(true);
    }
    private CustomerDao dao = new CustomerDao();

    @Test
    public void testCreateUser() {
        Customer customer = new Customer();
        customer.setName("Pavel");
        customer.setAdress(new Adress("Ostrava", "Opálová", 333));

        Customer saveCustomer = dao.saveEntity(customer);

        assertTrue(saveCustomer.getId() != 0);
    }



}