package step.definitions;

import io.cucumber.java.en.*;

public class AddToCartSD {
    @Given("I'm on the Store Page")
    public void goToStorePage() {
        System.out.println("Here we go");
    }
    @When("I add a {string} to the Cart")
    public void addProductToCart(String string) {
    }
    @Then("I see {int} {string} in the Cart")
    public void checkNumberOfProductAdded(Integer int1, String string) {
    }
}
