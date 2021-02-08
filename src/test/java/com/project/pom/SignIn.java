package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByClassName;
import org.openqa.selenium.WebDriver;

public class SignIn extends POM {
	
	By signIn =  By.xpath("//button[@type='submit']");
	By mail = By.xpath("//input[@type='text' and @name='email']");
	By password = By.xpath("//input[@type='password' and @name='password']");
	
	private String[] information = new String[] { "Hi Admin!", "Dashboard"};

	public SignIn(WebDriver driver) {
		super(driver);
	}

	public void login(String email, String pass) {
		if (isDisplayed(mail) && isDisplayed(password)) {
			write(email, mail);
			write(pass, password);
			click(signIn);
		} else {
			System.err.println("No se encuentra la sección de Iniciar Sesión");
		}
	}

	public void checkInfo() {
		wait(7, By.xpath("//i[@class='fa fa-cube']"));
		for (int i = 0; i < information.length; i++) {
			if (!(isDisplayed(By.xpath("//strong[text()='" + information[i] + "']")))) {
				System.err.println("NO Encontro el area de información " + information[i]);
			}
		}
	}
	
	public String chechMyInformation(String info) throws InterruptedException {
		click(By.id("account"));
		return getValue(By.xpath("//input[@value='" + info + "']"));
	}
	
	
}
