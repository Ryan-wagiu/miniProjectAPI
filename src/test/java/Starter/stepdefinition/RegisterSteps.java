package Starter.stepdefinition;

import Starter.Project.Register;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class RegisterSteps {

    @Steps
    Register register;
    @Given("I set url register")
    public void iSetUrlRegister() {
        register.setUrlRegister();
    }

    @Then("I get register code {string}")
    public void iGetRegisterCode(String arg0) {
        if (arg0.equals("200")){
            register.verifyStatusCode200();
        } else if (arg0.equals("400")) {
            register.verifyStatusCode400();
        }
    }

    @When("I input email {string} password {string} and fullname {string}")
    public void iInputEmailPasswordAndFullname(String email, String password, String fullname) {
        register.requestWithEmailPasswordAndFullname(email, password, fullname);
    }
}
