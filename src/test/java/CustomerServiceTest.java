import Dao.CustomerDao;
import Entity.Customer;
import Service.CustomerService;
import Service.Impl.CustomerServiceImpl;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.reflect.internal.WhiteboxImpl;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.mockito.Mockito.*;
import static org.testng.Assert.assertTrue;

@PrepareForTest(CustomerServiceImpl.class)
public class CustomerServiceTest {


    @Mock
    private CustomerDao daoMock;

    @InjectMocks
    private CustomerServiceImpl service;


    @BeforeClass
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testAddCustomer() {

        when(daoMock.save(any(Customer.class))).thenReturn(true);

        Customer customer = new Customer();

        assertTrue(service.addCustomer(customer));
    }

    //Throwing an exception from the mocked method
    @Test(expectedExceptions = RuntimeException.class)
    public void testAddCustomerException() {

        when(daoMock.save(any(Customer.class))).thenThrow(RuntimeException.class);

        Customer customer = new Customer();

        service.addCustomer(customer);//
    }


    @Test
    public void voidFunction() {

        CustomerServiceImpl myClass = new CustomerServiceImpl();
        Object[] objects = new Object[] {"name"};


        Object msg = null;
        try {
            msg = WhiteboxImpl.invokeMethod(myClass, "printName", objects);
        } catch (Exception e) {
            e.printStackTrace();
        }

        Assert.assertEquals(msg, "name");
    }
}
