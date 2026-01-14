package step.definitions;

import io.cucumber.java.ParameterType;
import io.cucumber.java.en.*;
import object.Product;

public class AddToCartSD {

    @Given("I'm on the Store Page")
    public void goToStorePage() {
        System.out.println("Here we go");
    }
    @When("I add a {product} to the Cart")
    public void addProductToCart(Product product) {
//        Product product = new Product(productName);
        System.out.println("printlnThe product name is: "+product.getProductName());
    }
    @Then("I see {int} {product} in the Cart")
    public void checkNumberOfProductAdded(Integer int1, Product product) {
        System.out.println("printlnThe product name is: "+product.getProductName());

    }
}
