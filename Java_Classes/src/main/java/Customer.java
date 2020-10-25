import javax.annotation.processing.SupportedAnnotationTypes;

public class Customer {
    private final int id;
    private final String lastName;
    private final String name;
    private final String patronymic;
    private final String address;
    private final int cardId;
    private final int bankAccountId;

    @Override
    public int hashCode(){
        return id + lastName.length() + name.length() + patronymic.length() + address.length() + cardId + bankAccountId;
    }

    @Override
    public boolean equals(Object obj){
        if(obj instanceof Customer){
            Customer cust = (Customer) obj;
            return  id == cust.id &&
                    lastName.equals(cust.lastName) &&
                    name.equals(cust.name) &&
                    patronymic.equals(cust.patronymic) &&
                    address.equals(cust.address) &&
                    cardId == cust.cardId &&
                    bankAccountId == cust.bankAccountId;
        }
        return false;
    }

    public Customer(){
        this.id = 0;
        this.bankAccountId = 0;
        this.cardId = 0;
        this.name = "without name";
        this.lastName = "without last name";
        this.patronymic = "without patronymic";
        this.address = "homeless";
    }

    public Customer(int id){
        this.id = id;
        this.bankAccountId = 0;
        this.cardId = 0;
        this.name = "without name";
        this.lastName = "without last name";
        this.patronymic = "without patronymic";
        this.address = "homeless";
    }

    public Customer(int id, String lastName, String name, String patronymic, String address, int cardId, int bankAccountId){
        this.id = id;
        this.lastName = lastName;
        this.name = name;
        this.patronymic = patronymic;
        this.address = address;
        this.cardId = cardId;
        this.bankAccountId = bankAccountId;
    }

    @Override
    public String toString(){
        return "Customer " + name + " " + lastName + " " + patronymic + " has id " + id + " live at " + address + "; his card id is " +
        cardId + " and his bank account id is " + bankAccountId;
    }

    public int getId() {
        return id;
    }

    public String getLastName() {
        return lastName;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getCardId() {
        return cardId;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }
}
