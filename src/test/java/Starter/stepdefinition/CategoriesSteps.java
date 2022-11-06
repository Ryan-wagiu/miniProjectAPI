package Starter.stepdefinition;

import Starter.Project.Categories;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CategoriesSteps {

    @Steps
    Categories categories;

    @Given("I set url get category create")
    public void iSetUrlGetCategoryCreate() {
        categories.setUrl();
    }

    @When("I input {string} and description {string}")
    public void iInputAndDescription(String name, String desc) {
        categories.requestCategoryWithNameAndDesc(name, desc);
    }

    @Then("I get category {string}")
    public void iGetCategory(String status) {
        if (status.equals("200")) {
            categories.verifStatusCode200();
        } else if (status.equals("400")) {
            categories.verifStatusCode400();
        } else if (status.equals("500")) {
            categories.verifStatusCode500();
        }
    }

    @Given("I set url get category")
    public void iSetUrlGetCategory() {
        categories.setUrl();
    }

    @When("I request get all category")
    public void iRequestGetAllCategory() {
        categories.requestGetAll();
    }

    @Then("I get all category")
    public void iGetAllCategory() {
        categories.verifStatusCode200();
    }

    @When("I request get by id category {string}")
    public void iRequestGetByIdCategory(String getid) {
        categories.requestGetById(getid);
    }

    @Then("I get by id code {string}")
    public void iGetByIdCode(String code) {
        if (code.equals("200")) {
            categories.verifStatusCode200();
        } else if (code.equals("400")) {
            categories.verifStatusCode400();
        } else if (code.equals("404")) {
            categories.verifStatusCode404();
        }
    }
}