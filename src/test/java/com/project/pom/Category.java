package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByLinkText;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.*;

public class Category extends POM {
	
	
	By blog = By.xpath("//a[@href='#Blog']");
	By blogCategory = By.xpath("//a[text()='Blog Categories']");
	By buttonAdd = By.xpath("//button[@type='button' and @data-toggle='modal']");
	By signIn =  By.xpath("//button[@type='submit']");
	By mail = By.xpath("//input[@type='text' and @name='email']");
	By password = By.xpath("//input[@type='password' and @name='password']");
	
	By nameCategory = By.xpath("//*[@id=\"ADD_BLOG_CAT\"]/div[2]/div/form/div[2]/div[1]/div/input");
	By status = By.xpath("//select[@name='status' and @class='form-control']");
	By buttonAddCategory = By.xpath("//button[@type='submit' and @class='btn btn-primary']");
	By newCategory = By.xpath("//td[text()='Testing']");
	
	
	public Category(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login(String email, String pass) {
		if (isDisplayed(mail) && isDisplayed(password)) {
			write(email, mail);
			write(pass, password);
			click(signIn);
			newCategory();
		} else {
			System.err.println("No se encuentra la sección de Iniciar Sesión");
		}
	}
	
	public void newCategory() {
		wait(7, By.xpath("//i[@class='fa fa-cube']"));
		if(isDisplayed(blog)) {
			click(blog);
			wait(7, blogCategory);
			if(isDisplayed(blogCategory)) {
				click(blogCategory);
			}else {
				System.err.println("No se encuentra la sección blogCategory");
			}
		}else {
			System.err.println("No se encuentra la blog");
		}
	}
	
	public void data() {
		wait(7, buttonAdd);
		click(buttonAdd);
		wait(7, nameCategory);
		click(nameCategory);
		write("Testing", nameCategory);
		select("Yes", status);
		click(buttonAddCategory);
	}
	
	public String confirmRegistration() {
		wait(7, buttonAdd);
		return getText(newCategory);
	}

}
