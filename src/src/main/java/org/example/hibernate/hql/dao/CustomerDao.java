package org.example.hibernate.hql.dao;

import org.example.hibernate.hql.entity.Adress;
import org.example.hibernate.hql.entity.Customer;

public class CustomerDao extends BaseDao<Customer>{

    public Customer saveCustomer(String name, String city, String street, int bn) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setAdress(new Adress(city, street, bn));

        return saveEntity(customer);
    }
}
