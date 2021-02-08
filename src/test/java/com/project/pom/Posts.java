package com.project.pom;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.File;

public class Posts extends POM{
	
	File file1 = new File("resources/descarga.jpg");

	By blog = By.xpath("//a[@href='#Blog']");
	By posts = By.xpath("//a[text()='Posts']");
	By buttonAdd = By.xpath("//button[@type='submit' and @class='btn btn-success']");
	By signIn =  By.xpath("//button[@type='submit']");
	By mail = By.xpath("//input[@type='text' and @name='email']");
	By password = By.xpath("//input[@type='password' and @name='password']");
	
	By postsTitle = By.xpath("//input[@name='title' and @placeholder='Post Title']");
	By permalink = By.xpath("//input[@name='slug' and @placeholder='Permalink']");
	By text = By.id("cke_1_contents");
	By content = By.xpath("//html/body/p");
	By keywords = By.xpath("//input[@name='keywords']");
	By description = By.xpath("//input[@name='metadesc' and @placeholder='Description']");
	By status = By.xpath("//select[@name='status']");
	By category = By.xpath("//select[@name='category']");
	By related = By.xpath("//input[@type='text' and @class='select2-input']");
	By file = By.id("image_default");
	By save = By.xpath("//button[@type='submit']");
	By newPost = By.xpath("//td[text()='Testing Choucair']");
	
	public Posts(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	public void login(String email, String pass) {
		if (isDisplayed(mail) && isDisplayed(password)) {
			write(email, mail);
			write(pass, password);
			click(signIn);
			newposts();
		} else {
			System.err.println("No se encuentra la sección de Iniciar Sesión");
		}
	}
	
	public void newposts() {
		wait(7, By.xpath("//i[@class='fa fa-cube']"));
		if(isDisplayed(blog)) {
			click(blog);
			wait(7, posts);
			if(isDisplayed(posts)) {
				click(posts);
			}else {
				System.err.println("No se encuentra la sección posts");
			}
		}else {
			System.err.println("No se encuentra la blog");
		}
		data();
	}
	
	public void data() {
		String path = file1.getAbsolutePath();
		wait(7, buttonAdd);
		click(buttonAdd);
		wait(7, postsTitle);
		click(postsTitle);
		write("Testing Choucair", postsTitle);
		click(permalink);
		write("https://www.choucairtesting.com/", permalink);
		click(keywords);
		write("Testing Choucair", keywords);
		click(description);
		write("Testing Choucair", description);
		/**click(text);
		switchTo("cke_wysiwyg_frame cke_reset");
		write("Testing Choucair", content);*/
		select("No", status);
		select("16", category);
		//click(related);
		//click(By.xpath("//div[text()='Hotel Review: DOM Hotel In Rome']"));
		//write(path, file);
		//click(file);
		click(save);
	}
	
	public String confirmRegistration() {
		wait(7, buttonAdd);
		return getText(newPost);
	}
	
}
