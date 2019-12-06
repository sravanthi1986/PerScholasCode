package com.perscholas.qeb_selenium_lesson.runners;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
public class Signup {

    @Given("^the user navigates to the login page$")
    public void the_user_navigates_to_the_login_page() throws Throwable {
        throw new PendingException();
    }

    @When("^the user enters \"([^\"]*)\" and \"([^\"]*)\"$")
    public void the_user_enters_something_and_something(String strArg1, String strArg2) throws Throwable {
        throw new PendingException();
    }

    @Then("^the application forwards to the welcome page$")
    public void the_application_forwards_to_the_welcome_page() throws Throwable {
        throw new PendingException();
    }

}
