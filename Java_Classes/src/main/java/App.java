import java.util.ArrayList;
import java.util.function.Predicate;

public class App {
    public static void main(String[] args){
        ArrayList<Customer> customers = new ArrayList<Customer>();

        customers.add(new Customer(1,"Nick", "Nick", "Nick", "Nick", 1,1));
        customers.add(new Customer(2,"Smith", "Smith", "Smith", "Smith", 2,2));
        customers.add(new Customer(3,"John", "John", "John", "John", 3,3));
        customers.add(new Customer(4,"Mike", "Mike", "Mike", "Mike", 4,4));
        customers.add(new Customer(5,"Andrew", "Andrew", "Andrew", "Andrew", 5,5));
        customers.add(new Customer(6,"Dale", "Dale", "Dale", "Dale", 6,6));

        CustomerRepository repository = new CustomerRepository(customers);

        repository.printAll();

        repository.printIfCardIdInInterval(3,6);

        repository.orderByLastName();

        repository.printAll();
    }
}
