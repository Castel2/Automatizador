package com.choucair.test.Automatizador.steps;


import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.project.pom.Category;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CategoryStepDefinition {

	private WebDriver driver;
	Category category;
	
	@Given("I want to create a new category")
    public void givenNewCategory(){
		category = new Category(driver);
    	driver = category.ConnectionChrome();
    	category.web("https://www.phptravels.net/admin");
    	category.login("admin@phptravels.com", "demoadmin");
    }
	
	@When("I create the category")
    public void whenRegister() {
    	category.data();
    }

    @Then("a new category is created")
    public void thenRegistered() throws InterruptedException {
    	assertEquals("Testing", category.confirmRegistration());
    	driver.quit();
    }
	
}
