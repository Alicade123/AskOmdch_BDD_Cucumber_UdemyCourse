package step.definitions;

import io.cucumber.java.PendingException;
import io.cucumber.java.en.*;

public class Dummy{
    @Given ("I am dummy")
    public void d(){

    }
    @When("I do dummy things")
    public void du(){

    }
    @Then("dummy things happens")
    public void dum(){

    }

    @Given("I am dummy account balance is ${int}")
    public void openingBalance(int initial) {

    }

    @When("I withdraw ${int}")
    public void withdrawBalance(int charge) {

    }

    @Then("the account balance should be ${int}")
    public void closingBalance(int remaining) {

    }
    @But ("It's ok")
        public void itsOk(){

    }
}