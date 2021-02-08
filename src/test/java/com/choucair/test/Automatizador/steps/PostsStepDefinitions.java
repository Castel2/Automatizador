package com.choucair.test.Automatizador.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.WebDriver;

import com.project.pom.Posts;

public class PostsStepDefinitions {

	private WebDriver driver;
	Posts posts;
	
    @Given("I want to create a new posts")
    public void givenNewCategory(){
    	posts = new Posts(driver);
    	driver = posts.ConnectionChrome();
    	posts.web("https://www.phptravels.net/admin");
    	posts.login("admin@phptravels.com", "demoadmin");
    }

    @When("I create the category")
    public void whenRegister() {
    	posts.data();
    }

    @Then("a new category is created")
    public void thenRegistered() throws InterruptedException {
    	assertEquals("Testing Choucair", posts.confirmRegistration());
    	driver.quit();
    }

}
