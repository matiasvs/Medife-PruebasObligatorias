package cucumber.examples.java.calculator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.examples.java.calculator.pageobjects.AltaResponsableDePago;
import utils.PropertyManager;

public class Steps02 {
	
	WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();//a\\(\\d+)
	
	@Given("^Obligatorio b Ingreso al sistema Sumes$")
	public void obligatorio_b_Ingreso_al_sistema_Sumes() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe" );		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sumedesa.medife.com/sume"); 
		driver.manage().window().maximize();
	}

	@Given("^Obligatorio b Usuario: mveron$")
	public void obligatorio_b_Usuario_mveron() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Obligatorio b Pass: Mv(\\d+)$")
	public void obligatorio_b_Pass_Mv(int arg1) throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Given("^Obligatorio b Desplegado el combo Tipo de responsable$")
	public void obligatorio_b_Desplegado_el_combo_Tipo_de_responsable() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Obligatorio b selecciona el campo Tipo de Responsable Empresa$")
	public void obligatorio_b_selecciona_el_campo_Tipo_de_Responsable_Empresa() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Obligatorio b Entonces se habilita el boton del Buscador que permitira la seleccion de entidades$")
	public void obligatorio_b_Entonces_se_habilita_el_boton_del_Buscador_que_permitira_la_seleccion_de_entidades() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}
}
