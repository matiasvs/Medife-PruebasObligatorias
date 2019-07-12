package cucumber.examples.java.calculator.pageobjects;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import utils.PropertyManager;

public class Helpers {
	
	private WebDriver driver;
	
	public Helpers (WebDriver driver) {
		this.driver = driver;
	}
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();
	
	public void browserStart() {
		 System.out.println("Inicio de conexcion");
		 System.setProperty(pathChrome, browser );		
	     driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		 driver.get(baseURL); driver.manage().window().maximize();
	}
	
	public void waits(int tiempo) throws InterruptedException {
		Thread.sleep(tiempo*1000);
	}
	
	public void closed() {
		driver.close();
		driver.quit();
		System.out.println("---Closed browser---");
	}

}
