package cucumber.examples.java.calculator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.examples.java.calculator.pageobject.AltaResponsableDePago;
//import util.PropertyManager;
import utils.PropertyManager;



public class Steps01 {
	
	WebDriver driver;
	//AltaResponsableDePago pago;
	
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

	@Given("^Ingreso al sitio Sume$")
	public void ingreso_al_sitio_Sume() throws Exception {
		System.out.println("ss");
		System.setProperty(pathChrome,browser);		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("http://sumedesa.medife.com/sume"); 
		driver.manage().window().maximize();
	}

	@Given("^Ingreso de usuario$")
	public void ingreso_de_usuario() throws Exception {
	    AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoUser();
	    
	}

	@Given("^Ingreso de password$")
	public void ingreso_de_password() throws Exception {
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		resp.ingresoPass();
	}

	@Given("^Pantalla Alta de responsable de pago desplegada$")
	public void pantalla_Alta_de_responsable_de_pago_desplegada() throws Exception {
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoConfirmar();
	    resp.ingresoInicio();
	    resp.ingresoClientes();
	    //driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	    Thread.sleep(4000);
		driver.get("http://sumedesa.medife.com/sume/page/plugin/process/external/pg_external_content.jsf");
		resp.ingresoResponsableDePago();
	}

	@Given("^A Seleccion Exento (.*)$")
	public void a_Seleccion_Exento(String Externo) throws Exception {
		Thread.sleep(3000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoExterno();
		//resp.ingresoTipoResponsableABC(Externo);
	    driver.switchTo().defaultContent();
	}
	
	@Then("^validar Exento$")
	public void validar_Exento() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		Thread.sleep(1000);
	    resp.ValidarResponsableValorExterno();
	    driver.switchTo().defaultContent();
	}
	
	@Given("^A Seleccion Grupo Familiar (.*)$")
	public void a_Seleccion_Grupo_Familiar(String arg1) throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoGrupoFamiliar();
		//resp.ingresoTipoResponsableABC(Externo);
	    driver.switchTo().defaultContent();
	}
	
	@Then("^validar Grupo familar$")
	public void validar_Grupo_familar() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		Thread.sleep(1000);
	    resp.ValidarResponsableValorGrupoFamiliar();
	    driver.switchTo().defaultContent();
	}

	@Given("^A Seleccion Empresa (.*)$")
	public void a_Seleccion_Empresa(String arg1) throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoEmpresa();
		//resp.ingresoTipoResponsableABC(Externo);
	    driver.switchTo().defaultContent();
	}
	
	@Then("^Valiar Empresa$")
	public void valiar_Empresa() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		Thread.sleep(1000);
	    resp.ValidarResponsableValorEmpresa();
	    driver.switchTo().defaultContent();
	}

	@Then("^Apagar el sistema$")
	public void apagar_el_sistema() throws Exception {
//		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
//		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
//		Thread.sleep(1000);
	    resp.closed();
//	    driver.switchTo().defaultContent();
	}

//	@Then("^Validar Seleccion de excento$")
//	public void validar_Seleccion_de_excento() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^A Seleccion Grupo\"([^\"]*)\"$")
//	public void a_Seleccion_Grupo(String arg1) throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Validar seleccion de grupo familiar$")
//	public void validar_seleccion_de_grupo_familiar() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Apagar el sistema$")
//	public void apagar_el_sistema() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
	

//	@When("^seleciona el campo Tipo de Responsable$")
//	public void seleciona_el_campo_Tipo_de_Responsable() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Validar seleccion de empresa$")
//	public void validar_seleccion_de_empresa() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Se habilita el boton del uscardor de entidades$")
//	public void se_habilita_el_boton_del_uscardor_de_entidades() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Validar boton busqueda de entidad$")
//	public void validar_boton_busqueda_de_entidad() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^Selecciono boton busqueda de entidad$")
//	public void selecciono_boton_busqueda_de_entidad() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^Ingresar un valor correspondiente a una \"([^\"]*)\"$")
//	public void ingresar_un_valor_correspondiente_a_una(String arg1) throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^La pantalla lista los datos que coinciden con descripcion y cuit-cuil validar campos$")
//	public void la_pantalla_lista_los_datos_que_coinciden_con_descripcion_y_cuit_cuil_validar_campos() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^correspondiente a grupo familiar existente$")
//	public void correspondiente_a_grupo_familiar_existente() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^Ingreso \"([^\"]*)\"$")
//	public void ingreso(String arg1) throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^Seleccion boton buscar$")
//	public void seleccion_boton_buscar() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^La grilla se muestra vacia\\. No existe datos que coincida con los criterios de busqueda$")
//	public void la_grilla_se_muestra_vacia_No_existe_datos_que_coincida_con_los_criterios_de_busqueda() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^Selecciono el resultado con checkBox$")
//	public void selecciono_el_resultado_con_checkBox() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@When("^seleccino el boton confirmar entidad$")
//	public void seleccino_el_boton_confirmar_entidad() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
//
//	@Then("^La ventana se cierra y los datos se cargan en la pantalla Alta de responsable de pago validar valores$")
//	public void la_ventana_se_cierra_y_los_datos_se_cargan_en_la_pantalla_Alta_de_responsable_de_pago_validar_valores() throws Exception {
//	    // Write code here that turns the phrase above into concrete actions
//	    throw new PendingException();
//	}
	
}