package Service.Impl;

import Dao.CustomerDao;
import Entity.Customer;
import Service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    @Override
    public boolean addCustomer(Customer customer) {

        if(customerDao.exists(customer.getPhone())){
            return false;
        }

        return customerDao.save(customer);
    }

    private String printName(String name) {
        return name;
    }
}
