package org.example.hibernate.hql.dao;

import org.example.hibernate.hql.entity.Adress;
import org.example.hibernate.hql.entity.Customer;
import org.example.hibernate.hql.entity.Order;

public class OrderDao extends BaseDao<Customer>{

    CustomerDao dao = new CustomerDao();
    public Order createOrder(int customerID) {
        Order order = new Order();
        Customer customer = dao.load(customerID, Customer.class);
        order.setCustomer(customer);
        return order;
    }


}
