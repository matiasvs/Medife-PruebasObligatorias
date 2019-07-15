package cucumber.examples.java.calculator.pageobjects;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import utils.PropertyManager;

public class Base {


	private WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();

	@Given("^Obligatorio a Ingreso al sistema Sumes$")
	public void obligatorio_a_Ingreso_al_sistema_Sumes() throws Exception {
		System.setProperty("pathChrome", "browser" );		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sumedesa.medife.com/sume"); 
		driver.manage().window().maximize();
	}
	
	
	public Base(WebDriver driver) {
		this.driver = driver;
	}
	
	public WebDriver chromeDdriverConnection() {
		System.setProperty("", "");
		driver = new ChromeDriver();
		return driver;
	}
	
	public WebElement findElement(By locator) {
		return driver.findElement(locator);
	}
	
	public List<WebElement> findElements(By locator) {
		return driver.findElements(locator);
	}
	
	public String getText(WebElement element) {
		return element.getText();
	}
	
	public String getText(By locator) {
		return driver.findElement(locator).getText();
	}
	
	public void type(By locator, String inputText) {
		driver.findElement(locator).sendKeys(inputText);
	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}	catch (org.openqa.selenium.NoSuchElementException exception) {
				return false;
		}
	}
	
	public void visit(String url) {
		driver.get(url);
	}
	
	public void closed() {
		driver.manage().deleteAllCookies();
		driver.close();
		driver.quit();
		System.out.println("---Closed browser---");
	}
}
