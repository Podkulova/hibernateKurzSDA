package org.example.hibernate.hql.dao;

import org.example.hibernate.hql.entity.*;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class OrderDao extends BaseDao<Order>{

    CustomerDao dao = new CustomerDao();
    ProductDao productDao = new ProductDao();
    public Order createOrder(int customerID, Integer ... listOfProductIds) {
        Order order = new Order();

        Customer customer = dao.load(customerID, Customer.class);

        order.setCustomer(customer);

        List<Product> products = productDao.load(Product.class, listOfProductIds);
        List<OrderItem> items = products.stream().map(p -> {
            OrderItem orderItem = new OrderItem();
            orderItem.setCount(1);
            orderItem.setProduct(p);
            return orderItem;
        }).collect(Collectors.toList());

        order.setItems(items);
        order = saveEntity(order);

        return order;
    }


}
