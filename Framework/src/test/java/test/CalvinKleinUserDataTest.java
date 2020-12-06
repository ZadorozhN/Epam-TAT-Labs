package test;

import model.Item;
import model.User;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.CalvinKleinHomePage;
import service.ItemCreator;
import service.UserCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalvinKleinUserDataTest extends CommonConditions{
    @Test
    public void enterUserDataTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        User user = UserCreator.withCredentialsFromProperty();

        boolean isReadyToPay = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .addToCart()
                .openCart()
                .proceedPurchase()
                .enterTheUserData(user)
                .saveAndContinue()
                .continueToPayment()
                .isReadyToPay();

        assertThat(isReadyToPay, equalTo(true));
    }

    @Test
    public void enterInvalidEmailTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        User user = UserCreator.withCredentialsFromProperty();
        String invalidEmail = "invalidEmail";
        user.setEmail(invalidEmail);

        boolean isInvalidEmail = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .addToCart()
                .openCart()
                .proceedPurchase()
                .enterTheUserData(user)
                .isInvalidEmail();

        assertThat(isInvalidEmail, equalTo(true));
    }

    @Test
    public void enterInvalidPhoneTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        User user = UserCreator.withCredentialsFromProperty();
        String invalidPhoneNumber = "12345";
        user.setPhoneNumber(invalidPhoneNumber);

        boolean isInvalidPhoneNumber = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .addToCart()
                .openCart()
                .proceedPurchase()
                .enterTheUserData(user)
                .isInvalidPhoneNumber();

        assertThat(isInvalidPhoneNumber, equalTo(true));
    }
}
