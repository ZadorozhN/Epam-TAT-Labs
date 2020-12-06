package test;

import model.Item;
import org.testng.annotations.Test;
import page.CalvinKleinHomePage;
import service.ItemCreator;
import service.PromoCodeCreator;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static util.Resolver.resolveDiscount;

public class CalvinKleinCartTest extends CommonConditions {

    @Test
    public void addToCartTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");

        Item item = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .addToCart()
                .openCart()
                .getItem(1);

        assertThat(item, equalTo(expectedItem));
    }

    @Test
    public void addManyItemsToCartTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        expectedItem.changeAmount(3);
        String uri = ItemCreator.getUri("first");

        Item item = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .setCountOfItems(expectedItem.getAmount())
                .addToCart()
                .openCart()
                .getItem(1);

        assertThat(item, equalTo(expectedItem));
    }

    @Test
    public void addTwoDifferentItemsToCartTest(){
        Item firstExpectedItem = ItemCreator.withCredentialsFromProperty("first");
        String firstUri = ItemCreator.getUri("first");

        Item secondExpectedItem = ItemCreator.withCredentialsFromProperty("second");
        String secondUri = ItemCreator.getUri("second");

        CalvinKleinHomePage page = new CalvinKleinHomePage(driver);

        Item firstItem = page.openPage()
                .search(firstUri)
                .setSize(firstExpectedItem.getSize())
                .setCountOfItems(firstExpectedItem.getAmount())
                .addToCart()
                .openCart()
                .getItem(1);


        Item secondItem = page.search(secondUri)
                .setSize(secondExpectedItem.getSize())
                .setCountOfItems(secondExpectedItem.getAmount())
                .addToCart()
                .openCart()
                .getItem(1);

        assertThat(firstItem, equalTo(firstExpectedItem));
        assertThat(secondItem, equalTo(secondExpectedItem));
    }

    @Test
    public void removeItemFromCartTest() {
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");

        boolean isEmpty = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .setCountOfItems(expectedItem.getAmount())
                .addToCart()
                .openCart()
                .removeItem(1)
                .isEmpty();

        assertThat(isEmpty, equalTo(true));
    }

    @Test
    public void changeItemCountTest() {
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        int expectedAmount = 2;

        Item item = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .setCountOfItems(expectedItem.getAmount())
                .addToCart()
                .openCart()
                .changeAmountOfItem(1, expectedAmount)
                .getItem(1);

        expectedItem.changeAmount(expectedAmount);

        assertThat(item, equalTo(expectedItem));
    }

    @Test
    public void getSubtotalCostTest() {
        Item expectedItem = ItemCreator.withCredentialsFromProperty("first");
        String uri = ItemCreator.getUri("first");
        Item secondExpectedItem = ItemCreator.withCredentialsFromProperty("second");
        String secondUri = ItemCreator.getUri("second");

        int expectedSubtotalCost = expectedItem.getCentPrice() + secondExpectedItem.getCentPrice();

        int subtotalCost = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .setCountOfItems(expectedItem.getAmount())
                .addToCart()
                .search(secondUri)
                .setSize(secondExpectedItem.getSize())
                .setCountOfItems(secondExpectedItem.getAmount())
                .addToCart()
                .openCart()
                .getSubtotalCost();

        assertThat(expectedSubtotalCost, equalTo(subtotalCost));
    }

    @Test
    public void addPromoCodeTest(){
        Item expectedItem = ItemCreator.withCredentialsFromProperty("promoitem");
        String uri = ItemCreator.getUri("promoitem");
        String promoCode = PromoCodeCreator.withCredentialsFromProperty();
        int discount = PromoCodeCreator.getDiscount();

        Item item = new CalvinKleinHomePage(driver)
                .openPage()
                .search(uri)
                .setSize(expectedItem.getSize())
                .addToCart()
                .openCart()
                .enterPromoCode(promoCode, 1)
                .getItem(1);

        int costWithDiscount = resolveDiscount(expectedItem.getCentPrice(), discount);

        assertThat(item.getCentPrice(), equalTo(costWithDiscount));
    }
}