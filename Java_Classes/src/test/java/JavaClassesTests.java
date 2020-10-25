import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import java.lang.reflect.Array;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class JavaClassesTests {
    @Test
    void trueTest(){
        assertTrue(true);
    }
    @Test
    void customerEqualsTest(){
        Customer firstCustomer = new Customer(6, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);
        Customer secondCustomer = new Customer(6, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);
        assertEquals(firstCustomer,secondCustomer);
    }

    @Test
    void customerNotEqualsTest(){
        Customer firstCustomer = new Customer(6, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);
        Customer secondCustomer = new Customer(1, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);
        Customer thirdCustomer = new Customer(2, "NotDaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);
        Customer fourthCustomer = new Customer(3, "DaleLastName", "NotDale", "DalePatronymic", "DaleAddress", 6, 6);
        Customer fifthCustomer = new Customer(5, "DaleLastName", "Dale", "NotDalePatronymic", "DaleAddress", 6, 6);
        Customer sixthCustomer = new Customer(8, "DaleLastName", "Dale", "DalePatronymic", "NotDaleAddress", 6, 6);
        Customer seventhCustomer = new Customer(10, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 1, 6);
        Customer eighthCustomer = new Customer(12, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 1);

        assertAll(()->assertNotEquals(firstCustomer,secondCustomer),
                ()->assertNotEquals(firstCustomer,thirdCustomer),
                ()->assertNotEquals(firstCustomer,fourthCustomer),
                ()->assertNotEquals(firstCustomer,fifthCustomer),
                ()->assertNotEquals(firstCustomer,sixthCustomer),
                ()->assertNotEquals(firstCustomer,seventhCustomer),
                ()->assertNotEquals(firstCustomer,eighthCustomer));
    }

    @Test
    void customersSortTest(){
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer(6, "B", "Dale", "Sweet", "DaleAddress", 1, 1));
        customers.add(new Customer(1, "C", "Nick", "Smith", "NickAddress", 2, 2));
        customers.add(new Customer(5, "A", "John", "JC", "JohnAddress", 3, 3));

        CustomerRepository repository = new CustomerRepository(customers);
        repository.orderByLastName();

        ArrayList<Customer> sortedCustomers = new ArrayList<>();

        sortedCustomers.add(new Customer(5, "A", "John", "JC", "JohnAddress", 3, 3));
        sortedCustomers.add(new Customer(6, "B", "Dale", "Sweet", "DaleAddress", 1, 1));
        sortedCustomers.add(new Customer(1, "C", "Nick", "Smith", "NickAddress", 2, 2));

        assertArrayEquals(repository.getAllCustomers().toArray(), sortedCustomers.toArray());
    }

    @Test
    void getByIdRepositoryTest(){
        ArrayList<Customer> customers = new ArrayList<>();
        Customer foundCustomer = new Customer(7, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);

        customers.add(new Customer(6, "B", "Dale", "Sweet", "DaleAddress", 1, 1));
        customers.add(new Customer(1, "C", "Nick", "Smith", "NickAddress", 2, 2));
        customers.add(new Customer(5, "A", "John", "JC", "JohnAddress", 3, 3));
        customers.add(foundCustomer);

        CustomerRepository repository = new CustomerRepository(customers);

        assertEquals(foundCustomer, repository.getById(foundCustomer.getId()));
    }

    @Test
    void removeCustomerByIdTest(){
        ArrayList<Customer> customers = new ArrayList<>();

        Customer deletedCustomer = new Customer(7, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);

        customers.add(new Customer(6, "B", "Dale", "Sweet", "DaleAddress", 1, 1));
        customers.add(new Customer(1, "C", "Nick", "Smith", "NickAddress", 2, 2));
        customers.add(new Customer(5, "A", "John", "JC", "JohnAddress", 3, 3));

        CustomerRepository repository = new CustomerRepository(customers);
        repository.removeById(deletedCustomer.getId());
        assertEquals(repository.getById(deletedCustomer.getId()), null);
    }

    @Test
    void removeCustomerTest(){
        ArrayList<Customer> customers = new ArrayList<>();

        Customer deletedCustomer = new Customer(7, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);

        customers.add(new Customer(6, "B", "Dale", "Sweet", "DaleAddress", 1, 1));
        customers.add(new Customer(1, "C", "Nick", "Smith", "NickAddress", 2, 2));
        customers.add(new Customer(5, "A", "John", "JC", "JohnAddress", 3, 3));

        CustomerRepository repository = new CustomerRepository(customers);
        repository.removeCustomer(deletedCustomer);
        assertEquals(repository.getById(deletedCustomer.getId()), null);
    }

    @Test
    void addCustomerTest(){
        ArrayList<Customer> customers = new ArrayList<>();

        Customer addedCustomer = new Customer(7, "DaleLastName", "Dale", "DalePatronymic", "DaleAddress", 6, 6);

        customers.add(new Customer(6, "B", "Dale", "Sweet", "DaleAddress", 1, 1));
        customers.add(new Customer(1, "C", "Nick", "Smith", "NickAddress", 2, 2));
        customers.add(new Customer(5, "A", "John", "JC", "JohnAddress", 3, 3));

        CustomerRepository repository = new CustomerRepository(customers);
        repository.addCustomer(addedCustomer);
        assertEquals(repository.getById(addedCustomer.getId()), addedCustomer);
    }

    @Test
    void randomFillingTest(){
        int numberOfCustomers = 10;
        CustomerRepository repository = new CustomerRepository();
        repository.randomFilling(numberOfCustomers);
        assertEquals(repository.size(), numberOfCustomers);
    }

    @Test
    void getCustomerNameTest(){
        String name = "John";
        Customer customer = new Customer(1, "Sweet", name, "John's patronymic", "Wall street", 1, 1);
        assertEquals(customer.getName(), name);
    }

    @Test
    void getCustomerLastNameTest(){
        String lastName = "Sweet";
        Customer customer = new Customer(1, lastName, "John", "John's patronymic", "Wall street", 1, 1);
        assertEquals(customer.getLastName(), lastName);
    }

    @Test
    void getCustomerIdTest(){
        int id = 777;
        Customer customer = new Customer(id, "Sweet", "John", "John's patronymic", "Wall street", 1, 1);
        assertEquals(customer.getId(), id);
    }

    @Test
    void getCustomerCardIdTest(){
        int cardId = 567;
        Customer customer = new Customer(1, "Sweet", "John", "John's patronymic", "Wall street", cardId, 1);
        assertEquals(customer.getCardId(), cardId);
    }

    @Test
    void getCustomerBankAccountIdTest(){
        int bankAccountId = 321;
        Customer customer = new Customer(1, "Sweet", "John", "John's patronymic", "Wall street", 1, bankAccountId);
        assertEquals(customer.getBankAccountId(), bankAccountId);
    }
}
