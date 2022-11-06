package Starter.stepdefinition;

import Starter.Project.Login;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSteps {

    @Steps
    Login login;
    @Given("I set url login")
    public void iSetUrlLogin() {
        login.setUrlApi();
    }

    @When("I input email {string} and password {string}")
    public void iInputEmailAndPassword(String email, String password) {
        login.requestWithEmailAndPassword(email, password);
    }

    @Then("I get login message {string}")
    public void iGetLoginMessage(String result) {
        if (result.equals("succes")){
            login.verifyStatusCode200();
        }else if (result.equals("failed")) {
            login.verifyStatusCode400();
        }
    }
}
