package Starter.stepdefinition;

import Starter.Project.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class ProductSteps {

    @Steps
    Product product;
    @Given("I set url get product")
    public void iSetUrlGetProduct() {
        product.setUrlGetProduct();
    }
    @When("I request get product")
    public void iRequestGetProduct() {
        product.requestGetProduct();
    }

    @Then("I get all product")
    public void iGetGetAllProduct() {
        product.verifedStatusCode200();
    }

    @Given("I set url get product by id")
    public void iSetUrlGetProductById() {
        product.setUrlGetByIdProduct();
    }

    @When("I want to get by id")
    public void iWantToGetById() {
        product.requestById();
    }

    @Then("I get product by id")
    public void iGetProductById() {
        product.verifedStatusCode200();
    }

    @When("I request delete product")
    public void iRequestDeleteProduct() {
        product.requestDeleteProduct();
    }
    @Then("success delete product")
    public void succesDeleteProduct() {
        product.verifedStatusCode200();
    }
    @When("I input product with name {string} desc {string} price {int} and categories {int}")
    public void iInputProductWithNameDescPriceAndCategories(String name, String desc, int price, int cate) {
        product.requestCreate(name, desc, price, cate);
    }
    @Then("I get code {string}")
    public void iWillGetCode(String arg0) {
        if (arg0.equals("200")){
            product.verifedStatusCode200();
        }else if (arg0.equals("400")){
            product.verifedStatusCode400();
        }else if (arg0.equals("500")){
            product.verifedStatusCode500();
        }
    }
}
