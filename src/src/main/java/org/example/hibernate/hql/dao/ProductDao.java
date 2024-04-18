package org.example.hibernate.hql.dao;

import org.example.hibernate.hql.entity.Product;

public class ProductDao extends BaseDao<Product>{
    public Product saveProduct(String name, int price, int count) {
        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setCountStock(count);
        return saveEntity(product);
    }
}
