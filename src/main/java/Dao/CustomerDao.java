package Dao;

import Entity.Customer;

public interface CustomerDao {

    boolean exists(String phone);

    boolean save(Customer customer);
}
