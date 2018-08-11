package Dao.Impl;

import Dao.CustomerDao;
import Entity.Customer;

public class CustomerDaoImpl implements CustomerDao {


    @Override
    public boolean exists(String phone) {
        return true;
    }

    @Override
    public boolean save(Customer customer) {
        return true;
    }
}
