import javax.annotation.processing.SupportedAnnotationTypes;

public class Customer {
    private int id;
    private String lastName;
    private String name;
    private String patronymic;
    private String address;
    private int cardId;
    private int bankAccountId;

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
        this.name = "without name";
        this.lastName = "without last name";
        this.patronymic = "without patronymic";
        this.address = "homeless";
    }

    public Customer(int id){
        this.id = id;
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

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getCardId() {
        return cardId;
    }

    public void setCardId(int cardId) {
        this.cardId = cardId;
    }

    public int getBankAccountId() {
        return bankAccountId;
    }

    public void setBankAccountId(int bankAccountId) {
        this.bankAccountId = bankAccountId;
    }
}
