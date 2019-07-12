package cucumber.examples.java.calculator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

//import cucumber.examples.java.calculator.PageObjects.BusquedaDeEntidad;
//import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.examples.java.calculator.pageobjects.AltaResponsableDePago;
import cucumber.examples.java.calculator.pageobjects.BusquedaDeEntidad;
import cucumber.examples.java.calculator.pageobjects.CargaDeDatosFiscalesTarea;
//import cucumber.examples.java.calculator.PageObjects.AltaResponsableDePago;
//import cucumber.examples.java.calculator.PageObjects.BusquedaDeEntidad;
//import cucumber.examples.java.calculator.PageObjects.CargaDeDatosFiscalesTarea;
//import util.PropertyManager;
import utils.PropertyManager;

public class Test40 {
	
	WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();

	@Given("^Ingreso al sistema Sume$")
	public void ingreso_al_sistema_Sume() throws Exception {
		System.setProperty("webdriver.chrome.driver", "drivers\\chromedriver.exe" );		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sumedesa.medife.com/sume"); 
		driver.manage().window().maximize();
	}

	@Given("^Usuario: mveron$")
	public void usuario_mveron(String usuario) throws Exception {
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoUser(usuario);
	}

	@Given("^Pass: Mv(\\d+)$")
	public void pass_Mv(int arg1, String password) throws Exception {
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoPass(password);
	}

	@Given("^Seleccion alta de responsable de pago$")
	public void seleccion_alta_de_responsable_de_pago() throws Exception {
		System.out.println("Se muestra la pantalla Alta de responsable de pago");
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoConfirmar();
		AltaResDePago.ingresoInicio();
		AltaResDePago.ingresoClientes();
		//driver.get("http://sumedesa.medife.com/sume/page/plugin/process/edi/ediBuscar.jsf");
		Thread.sleep(2000);
		//driver.manage().timeouts().pageLoadTimeout(450, TimeUnit.SECONDS);
		driver.get("http://sumedesa.medife.com/sume/page/plugin/process/external/pg_external_content.jsf");
		AltaResDePago.ingresoResponsableDePago();
	}

	@Given("^Tipo de responsable (.*)$")
	public void tipo_de_responsable_Empresa(String Responsable) throws Exception {
//		driver.navigate().refresh();
//		driver.navigate().refresh();
		
		Thread.sleep(3000);
		//driver.manage().timeouts().pageLoadTimeout(450, TimeUnit.SECONDS);
		//driver.manage().timeouts().implicitlyWait(550, TimeUnit.SECONDS);
		//Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
		
		driver.switchTo().frame(frame);
		 
		//Thread.sleep(1000);		
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoTipoResponsableEmpresa(Responsable);				
		driver.switchTo().defaultContent();
	}

	@Given("^Busqueda de entidad$")
	public void busqueda_de_entidad() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.lupa();		
		driver.switchTo().defaultContent();
	}

	@Given("^Ingreso de cuit - Cuil (.*)$")
	public void ingreso_de_cuit_Cuil(String BusquedaCuit) throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad buscarEntidad = new BusquedaDeEntidad(driver);
		buscarEntidad.ingresoBusquedaCuit(BusquedaCuit);		
		driver.switchTo().defaultContent();
	}

	@Given("^Ingreso de descripcion (.*)$")
	public void ingreso_de_descripcion_BAZAR_AVENIDA(String descripcion) throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(frame);
		BusquedaDeEntidad buscarEntidad = new BusquedaDeEntidad(driver);
		buscarEntidad.ingresoDescripcion(descripcion);
		driver.switchTo().defaultContent();
	}

	@Given("^Seleccionar resultado y confimar entidad$")
	public void seleccionar_resultado_y_confimar_entidad() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(frame);
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.lupa2();
		BusquedaDeEntidad buscarEntidad = new BusquedaDeEntidad(driver);
		Thread.sleep(2000);
		buscarEntidad.check();
		//Thread.sleep(2000);
		buscarEntidad.ConfirmarEntidad();
		driver.switchTo().defaultContent();
	}

	@Given("^Ingreso de fecha de vigencia (.*)$")
	public void ingreso_de_fecha_de_vigencia(String fechaVigencia) throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(frame);
	    AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoFechaVigencia(fechaVigencia);
		driver.switchTo().defaultContent();
	}

	@Given("^Ingreso de correo (.*)$")
	public void ingreso_de_correo_Mveron_OpenDevSolutions_com(String mail) throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(frame);
	    AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.ingresoMail(mail);
		driver.switchTo().defaultContent();
	}

	@When("^Seleccion boton confimar$")
	public void seleccion_boton_confimar() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(frame);
		AltaResponsableDePago AltaResDePago = new AltaResponsableDePago(driver);
		AltaResDePago.btnConfirmar();
		driver.switchTo().defaultContent();
	}

	@Then("^Validacion ingreso a la pantalla de datos fiscales$")
	public void validacion_ingreso_a_la_pantalla_de_datos_fiscales() throws Exception {
	    System.out.println("datos fiscales");
	}

	@Then("^Ingreso fecha datos fiscales (.*)$")
	public void ingreso_fecha_datos_fiscales(String fechaInicio) throws Exception {
		WebElement qwe = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(qwe);
	    driver.manage().timeouts().pageLoadTimeout(1450, TimeUnit.SECONDS);
	    //Thread.sleep(5000);
		CargaDeDatosFiscalesTarea fiscales = new CargaDeDatosFiscalesTarea(driver);
		fiscales.ingresoFechaInicioCondicionIVA(fechaInicio);
		//fiscales.ingresoFechaInicioCondicionIVA(fechaInicio);
		
		//Thread.sleep(3000);
		driver.switchTo().defaultContent();
	}

	@Then("^Seleccion Tipo de pago (.*)$")
	public void seleccion_Tipo_de_pago(String arg1) throws Exception {
		WebElement qwe = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(qwe);
		CargaDeDatosFiscalesTarea fiscales = new CargaDeDatosFiscalesTarea(driver);
		fiscales.ingresoFormaDePagoPresencial();
		driver.switchTo().defaultContent();
		//Thread.sleep(8000);
	}

	@Then("^Ingresar nuevo telefono$")
	public void ingresar_nuevo_telefono() throws Exception {
		WebElement frame2 = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(frame2);
		CargaDeDatosFiscalesTarea fiscales = new CargaDeDatosFiscalesTarea(driver);
		fiscales.ingresoNuevoTelefono();
	    //Thread.sleep(3000);
	    fiscales.ingresoTipoDeTelefono();
	    fiscales.ingresoPrefijo();
	    fiscales.ingresoNumeroPopup();
	    fiscales.ingresoConfirmarPopUp();
		driver.switchTo().defaultContent();
	}

	@When("^selecionar confimar datos fisacales$")
	public void selecionar_confimar_datos_fisacales() throws Exception {
		WebElement qwe = driver.findElement(By.xpath("//*[@id='j_idt94']/div/iframe"));
	    driver.switchTo().frame(qwe);
		CargaDeDatosFiscalesTarea fiscales = new CargaDeDatosFiscalesTarea(driver);
		//fiscales.btnConfirmar2();
		//Thread.sleep(15000);
		driver.switchTo().defaultContent();
	}

	@Then("^Validar pantalla bandeja de entrada$")
	public void validar_pantalla_bandeja_de_entrada() throws Exception {
//	    driver.close();
//	    driver.quit();
	}
}
