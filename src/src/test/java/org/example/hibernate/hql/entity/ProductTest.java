package org.example.hibernate.hql.entity;

import org.example.hibernate.hql.HibernateUtil;
import org.example.hibernate.hql.dao.ProductDao;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ProductTest {
    @BeforeAll
    static void init() {
        HibernateUtil.setIsTest(true);
    }
    ProductDao dao = new ProductDao();
    @Test
    public  void createProduct() {
        Product product = dao.saveProduct("MacBook", 50000, 10);
        assertTrue(product.getId() != 0);
    }

    @Test
    public void testLoadByIds(){
        List<Product> load = dao.load(Product.class, 3, 4, 5);
        assertTrue(load.isEmpty());
    }

}