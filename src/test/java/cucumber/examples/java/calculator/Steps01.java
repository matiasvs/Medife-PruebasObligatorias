package cucumber.examples.java.calculator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.examples.java.calculator.pageobjects.AltaResponsableDePago;
import utils.PropertyManager;

public class Steps01 {
	
	WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();

	@Given("^Obligatorio a Ingreso al sistema Sumes$")
	public void obligatorio_a_Ingreso_al_sistema_Sumes() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe" );		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sumedesa.medife.com/sume"); 
		driver.manage().window().maximize();
	}

	@Given("^Obligatorio a Usuario: (.*)$")
	public void obligatorio_a_Usuario_mveron(String usuario) throws Exception {
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoUser(usuario);
	}

	@Given("^Obligatorio a Pass: (.*)$")
	public void obligatorio_a_Pass_Mv(String password) throws Exception {
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoPass(password);
	}

	@Given("^Obligatorio a Seleccion alta de responsable de pago$")
	public void obligatorio_a_Seleccion_alta_de_responsable_de_pago() throws Exception {
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoConfirmar();
		AltaResDePago.ingresoInicio();
		AltaResDePago.ingresoClientes();
		Thread.sleep(2000);
	}

	@Given("^Obligatorio a la pantalla Alta de responsible de pago desplegada$")
	public void obligatorio_a_la_pantalla_Alta_de_responsible_de_pago_desplegada() throws Exception {
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		Thread.sleep(2000);
		driver.get("http://sumedesa.medife.com/sume/page/plugin/process/external/pg_external_content.jsf");
		Thread.sleep(2000);
		AltaResDePago.ingresoResponsableDePago();			
	}	

	@When("^Obligatorio a seleciona el campo Tipo de Responsable$")
	public void obligatorio_a_seleciona_el_campo_Tipo_de_Responsable() throws Exception {
		System.out.println("Seleccion Tipo de responsables: " + "Valor");
	}

	@When("^Obligatorio a A Selecciono Empresa (.*)$")
	public void obligatorio_a_A_Selecciono_Empresa_Empresa(String tipoResponsable) throws Exception {
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));		
		driver.switchTo().frame(frame);
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoTipoResponsableABC(tipoResponsable);	
		driver.switchTo().defaultContent();
	}
}