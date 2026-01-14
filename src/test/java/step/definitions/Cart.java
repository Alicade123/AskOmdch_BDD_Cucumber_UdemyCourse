package step.definitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;

public class Cart {
    private static WebDriver driver;
    private String websiteUrl = "https://askomdch.com/store";
    private WebDriverWait wait;
    @Given("I'm on the Store Page of AskOmDch")
    public void goToStorePageOfAskOmDch() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(websiteUrl);
    }

    @When("I add a {string} in the cart")
    public void addProductToCart(String productName) {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        By addToCartBtn  = By.cssSelector("a[aria-label=\"Add “"+productName+"” to your cart\"]");
        driver.findElement(addToCartBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By viewCartBtn = By.cssSelector("a[title=\"View cart\"]");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(viewCartBtn,0));
        driver.findElement(viewCartBtn).click();
    }

    @Then("I'm should see {int} {string} in the cart.")
    public void checkCart(int productQuantity, String productName) {
        By productNameField = By.cssSelector("td[class=\"product-name\"]");
        String actualProductName = driver.findElement(productNameField).getText();
        By productQuantityField = By.cssSelector("input[type='number']");
        String actualProductQuantity = driver.findElement(productQuantityField).getAttribute("value");
      Assert.assertEquals(productName, actualProductName) ;
      Assert.assertEquals(productQuantity, Integer.parseInt(actualProductQuantity));

    }

    @Given("I'm a guest customer")
    public void i_m_a_guest_customer() {
        driver.get(websiteUrl);
    }
    @Given("I'm have a product in the cart")
    public void i_m_have_a_product_in_the_cart() {
        JavascriptExecutor js = ((JavascriptExecutor)driver);
        By addToCartBtn  = By.cssSelector("a[aria-label=\"Add “Blue Shoes” to your cart\"]");
        driver.findElement(addToCartBtn).click();
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By viewCartBtn = By.cssSelector("a[title=\"View cart\"]");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(viewCartBtn,0));
        driver.findElement(viewCartBtn).click();
    }
    @Given("I'm on the Checkout Page")
    public void i_m_on_the_checkout_page() {
       By checkoutBtn = By.cssSelector(".checkout-button");
       driver.findElement(checkoutBtn).click();
    }
    @When("I'm provide billing details")
    public void i_m_provide_billing_details(DataTable dataTable) {
        List<Map<String,String>> maps = dataTable.asMaps();

        By billingFirstNameFld = By.id("billing_first_name");
        By billingLastNameFld = By.id("billing_last_name");
        By billingCountryFld = By.id("billing_country");
        By billingAddressOneNameFld = By.id("billing_address_1");
        By billingCityNameFld = By.id("billing_city");
        By billingStateNameFld = By.id("billing_state");
        By billingPostCodeNameFld = By.id("billing_postcode");
        By billingEmailFld = By.id("billing_email");

        driver.findElement(billingFirstNameFld).sendKeys(maps.get(0).get("firstname"));
        driver.findElement(billingLastNameFld).sendKeys(maps.get(0).get("lastname"));
        driver.findElement(billingAddressOneNameFld).sendKeys(maps.get(0).get("address_line1"));
        new Select(driver.findElement(billingCountryFld)).selectByValue(maps.get(0).get("country"));
        driver.findElement(billingCityNameFld).sendKeys(maps.get(0).get("address_line1"));
        new Select(driver.findElement(billingStateNameFld)).selectByValue(maps.get(0).get("state"));
        driver.findElement(billingPostCodeNameFld).sendKeys(maps.get(0).get("zip"));
        driver.findElement(billingEmailFld).sendKeys(maps.get(0).get("email"));
    }
    @When("I place an Order")
    public void i_place_an_order() throws InterruptedException {
       By placeOrderButton = By.id("place_order");
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(placeOrderButton));
       driver.findElement(placeOrderButton).click();
       Thread.sleep(5000);
    }
    @Then("the order should be placed successfully")
    public void the_order_should_be_placed_successfully() {
        wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        By statusMessageField = By.cssSelector(".woocommerce-order p");
        wait.until(ExpectedConditions.visibilityOfElementLocated(statusMessageField));
        String actualResult = driver.findElement(statusMessageField).getText();
        String expectedResult = "Thank you. Your order has been received.";
        Assert.assertEquals(expectedResult,actualResult);
    }
}