import java.util.ArrayList;
import java.util.Comparator;
import java.util.Random;
import java.util.function.Predicate;

public class CustomerRepository {

    private ArrayList<Customer> customers;

    public CustomerRepository(){
        customers = new ArrayList<Customer>();
    }

    public CustomerRepository(ArrayList<Customer> customers){
        this.customers = customers;
    }

    public void randomFilling(int numberOfCustomers){
        Random rand = new Random();

        for(int i = 0; i < numberOfCustomers; i++){
            customers.add(new Customer(Math.abs(rand.nextInt())));
        }
    }

    public void addCustomer(Customer customer){
        customers.add(customer);
    }

    public void removeCustomer(Customer customer){
        customers.remove(customer);
    }

    public void removeById(int id){
        for(int i = 0; i < customers.size(); i++){
            if(customers.get(i).getId() == id){
                customers.remove(i);
            }
        }
    }

    public void printAll(){
        for(int i = 0; i < customers.size(); i++){
            System.out.println(customers.get(i).toString());
        }
    }

    public void printIf(Predicate<Customer> predicate){
        for(int i = 0; i < customers.size(); i++){
            if(predicate.test(customers.get(i))){
                System.out.println(customers.get(i).toString());
            }
        }
    }

    public void printIfCardIdInInterval(int from, int to){
        printIf(new Predicate<Customer>() {
            @Override
            public boolean test(Customer customer) {
                if(customer.getCardId() >= from && customer.getCardId() <= to)
                    return true;
                return false;
            }
        });
    }

    public void orderByLastName(){
        customers.sort(new Comparator<Customer>() {
            @Override
            public int compare(Customer o1, Customer o2) {
                if(o1.getLastName().compareTo(o2.getLastName()) > 0)
                    return 1;
                if(o1.getLastName().compareTo(o2.getLastName()) < 0)
                    return -1;
                return 0;
            }
        });
    }
}
