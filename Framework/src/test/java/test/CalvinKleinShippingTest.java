package test;

import model.Item;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;
import page.CalvinKleinHomePage;
import service.ItemCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class CalvinKleinShippingTest extends CommonConditions{
    @Test
    public void shipFreeTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        expectedItem.changeAmount(2);
        int free = 0;

        int shippingCost = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .setCountOfItems(expectedItem.getAmount())
                .addToCart()
                .openCart()
                .getShippingCost();

        assertThat(shippingCost, equalTo(free));
    }

    @Test
    public void doNotShipFreeTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        int cost = 995;

        int shippingCost = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .addToCart()
                .openCart()
                .getShippingCost();

        assertThat(shippingCost, equalTo(cost));
    }

}
