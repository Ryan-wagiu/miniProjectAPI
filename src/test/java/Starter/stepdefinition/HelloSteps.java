package Starter.stepdefinition;

import Starter.Project.Hello;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class HelloSteps {

    @Steps
    Hello hello;
    @Given("I set url helo")
    public void iSetUrlHelo() {
        hello.setUrlHome();
    }

    @When("I want to view hello")
    public void iWantToViewHello() {
        hello.requestHome();
    }

    @Then("I will get Hello")
    public void iWillGetHello() {
        hello.verifyStatusCode200();
    }
}
