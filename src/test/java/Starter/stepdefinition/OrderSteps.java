package Starter.stepdefinition;

import Starter.Project.Order;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class OrderSteps {

    @Steps
    Order order;

    @Given("I set url order")
    public void iSetUrlOrder() {
        order.setUrlCreateOrder();
    }

    @When("I input product id {int} and qty {int}")
    public void iInputProductidWithQty(int id, int qty) {

        order.requestIdAndQty(id, qty);
    }

    @Then("I get status code {string}")
    public void iGetStatusCode(String code) {
        if(code.equals("200")){
            order.verifyStatusCode200();
        }else if(code.equals("400")) {
            order.verifyStatusCode400();
        }
    }
    @Given("I set url get order")
    public void iSetUrlGetOrder() {
        order.setUrlGetAllOrder();
    }

    @When("I request get all order")
    public void iRequestGetAllOrder() {
        order.requestGetAll();
    }

    @Then("I get status code")
    public void iGetStatusCode() {
        order.verifyStatusCode200();
    }

    @Given("I set url get order by id {string}")
    public void iSetUrlGetOrderById(String id) {
        order.setUrlGetById(id);
    }

    @When("I request by id order")
    public void iRequestGetByIdOrder() {
        order.requestGetById();

    }
    @Then("I get status {string}")
    public void iGetStatus(String code) {
        if (code.equals("200")){
            order.verifyStatusCode200();
        }else if(code.equals("404")){
            order.verifyStatusCode404();
        }
    }
}
