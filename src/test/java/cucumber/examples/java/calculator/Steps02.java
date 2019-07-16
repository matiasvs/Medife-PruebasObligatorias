package cucumber.examples.java.calculator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.examples.java.calculator.pageobject.AltaResponsableDePago;
//import util.PropertyManager;
import utils.PropertyManager;

public class Steps02 {
	
	WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();
	String userLogin = PropertyManager.getInstance().getUser();
	String passwordLogin = PropertyManager.getInstance().getPass();

//	@Given("^Ingreso al sitio Sume$")
//	public void ingreso_al_sitio_Sume() throws Exception {
//		System.out.println("ss");
//		System.setProperty(pathChrome,browser);		
//		driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
//		driver.get("http://sumedesa.medife.com/sume"); 
//		driver.manage().window().maximize();
//	}
//
//	@Given("^Ingreso de usuario$")
//	public void ingreso_de_usuario() throws Exception {
//	    AltaResponsableDePago resp = new AltaResponsableDePago(driver);
//	    resp.ingresoUser();
//	    resp.ingresoPass();
//	}
//
//	@Given("^Ingreso de password$")
//	public void ingreso_de_password() throws Exception {
//		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
//	    resp.ingresoPass();
//	}
	
}
