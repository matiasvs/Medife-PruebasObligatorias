package cucumber.examples.java.calculator.pageobject;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.java.en.Given;
import util.PropertyManager;

public class Base {


	private WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();

//	@Given("^Obligatorio a Ingreso al sistema Sumes$")
//	public void obligatorio_a_Ingreso_al_sistema_Sumes() throws Exception {
//		System.setProperty("pathChrome", "browser" );		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://sumedesa.medife.com/sume"); 
//		driver.manage().window().maximize();
//	}
	
	
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
		WebDriverWait wait2=new WebDriverWait(driver, 300);
		WebElement types;
		types= wait2.until(ExpectedConditions.elementToBeClickable(locator));
		types.click();
		if (isDisplayed(locator)) {
			types.clear();
			types.sendKeys(inputText.trim());
			String value = types.getText();
			if (value == inputText) {
				System.out.println("el valor coincide: " + value);
			}
		}		
	}
//	public void ingresoPass(String password){
//		WebDriverWait wait2=new WebDriverWait(driver, 300);
//		WebElement pass;
//		pass= wait2
//				.until(ExpectedConditions
//						.elementToBeClickable(ByPass));
//		pass.clear();
//		pass.sendKeys(password.trim());
//	}
	
	public void click(By locator) {
		driver.findElement(locator).click();
	}
	
	public Boolean isDisplayed(By locator) {
		try {
			return driver.findElement(locator).isDisplayed();
		}	catch (org.openqa.selenium.NoSuchElementException e) {
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
