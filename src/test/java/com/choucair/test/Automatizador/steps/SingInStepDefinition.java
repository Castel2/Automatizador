package com.choucair.test.Automatizador.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.project.pom.SignIn;

public class SingInStepDefinition {

	private WebDriver driver;
	SignIn signIn;
	
	@Given("I want to log in with {} {}")
    public void givenNewUser(String mail, String pass)  {
		signIn = new SignIn(driver);
    	driver = signIn.ConnectionChrome();
    	signIn.web("https://www.phptravels.net/admin");
    	signIn.login(mail, pass);
    }

    @When("I enter my account")
    public void whenRegister() {
    	signIn.checkInfo();
    }

    @Then("I find my information")
    public void thenRegistered() throws InterruptedException {
    	assertEquals("Super Admin", signIn.chechMyInformation("Super Admin"));
    	assertEquals("Admin", signIn.chechMyInformation("Admin"));
    	assertEquals("admin@phptravels.com", signIn.chechMyInformation("admin@phptravels.com"));
    	driver.close();
    }

}
