package com.Store.Library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.boot.test.context.SpringBootTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class LibraryApplicationTests {

	private WebDriver driver;
	@BeforeEach
	public void setUp() {
		//System.setProperty("webdriver.chrome.driver", "/path/to/chromedriver");
		driver = new EdgeDriver();
	}

	@Test
	public void testLogin() throws InterruptedException {
		//1.initially open website
		driver.get("http://localhost:8080/login");
		driver.manage().window().maximize();
		//2.Entering login credentials
		driver.findElement(By.name("username")).sendKeys("saisatwikr15@gmail.com");
		driver.findElement(By.name("password")).sendKeys("123456");
		driver.findElement(By.xpath("/html/body/div/form/button")).click();
		//3.Entering into view list of website
		driver.findElement(By.xpath("/html/body/div/div/div/a")).click();
		//4.Entering into create product page and adding product details
		driver	.findElement(By.xpath("/html/body/div/div[1]/a[1]")).click();
		driver.findElement(By.name("bookname")).sendKeys("Do it today");
		driver.findElement(By.name("sellername")).sendKeys("Tom");
		driver.findElement(By.id("sellerphno")).sendKeys("9989877656");
		driver.findElement(By.id("selleremail")).sendKeys("Tom@gmail.com");
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[5]/div/input")).sendKeys("20");
		driver.findElement(By.id("imageFile")).sendKeys("C:\\Users\\RamaKrishnaSaiSatwik\\Desktop\\bookstore\\Book-Store\\Library\\src\\main\\resources\\static\\images\\do it today.jpg");
		driver.findElement(By.xpath("//button[@type='submit']")).click();

		//5.edit button
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[1]/td[8]/a[1]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("/html/body/div/div/div/form/div[7]/div[2]/a")).click();

		//to scroll down screen
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0, 1000);");

		//6.delete on product
		driver.findElement(By.xpath("/html/body/div/div[2]/table/tbody/tr[3]/td[8]/a[2]")).click();


	}

}
