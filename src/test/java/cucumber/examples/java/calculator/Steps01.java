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
import cucumber.examples.java.calculator.pageobject.BusquedaDeEntidad;
//import util.PropertyManager;
import utils.PropertyManager;



public class Steps01 {
	
	WebDriver driver;
	
	String pathChrome = PropertyManager.getInstance().getPathChrome();
	String browser = PropertyManager.getInstance().getBrowser();
	String baseURL = PropertyManager.getInstance().getURL();
	
	@Given("^Ingreso al sitio Sume$")
	public void ingreso_al_sitio_Sume() throws Exception {
		System.setProperty(pathChrome,browser);		
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(baseURL);
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
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.closed();
	}

	@Then("^Se habilita el boton del Buscador que permitira la seleccion de entidades$")
	public void se_habilita_el_boton_del_Buscador_que_permitira_la_seleccion_de_entidades() throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.lupa();
	    //Thread.sleep(3000);
	    driver.switchTo().defaultContent();
	}
	
	
	@Then("^Ingresar un valor correspondiente a una Empresa$")
	public void ingresar_un_valor_correspondiente_a_una_Empresa() throws Exception {
	    System.out.println("Ingreso de Empresa: a buscar");
	}
	
	@Then("^Ingreso de cuit (.*)$")
	public void ingreso_de_cuit(String BusquedaCuit) throws Exception {
		//Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.ingresoCuit(BusquedaCuit.trim());
//		AltaResponsableDePago resp = new AltaResponsableDePago(driver); lupaPopup
//	    resp.ingresoCuitCuil(cuitCuil);
	    driver.switchTo().defaultContent();
	}
	
	@Then("^Ingreso de descripcion (.*)$")
	public void ingreso_de_descripcion(String descripcion) throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.ingresoDescripcion(descripcion.trim());
	    driver.switchTo().defaultContent();
	}
	
	@When("^Selecciono boton busqueda de entidad en PopUp$")
	public void selecciono_boton_busqueda_de_entidad_en_PopUp() throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt94\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.lupaPopup();
	    driver.switchTo().defaultContent();
	}
	
	
	@Then("^La pantalla lista los datos que coinciden con descripcion y cuit-cuil validar campos$")
	public void la_pantalla_lista_los_datos_que_coinciden_con_descripcion_y_cuit_cuil_validar_campos() throws Exception {
	    System.out.println("Validacion de resultado");
	}
	@When("^correspondiente a grupo familiar existente$")
	public void correspondiente_a_grupo_familiar_existente() throws Exception {
	    System.out.println("Valor grupo");
	}

	@Then("^La grilla se muestra vacia\\. No existe datos que coincida con los criterios de busqueda$")
	public void la_grilla_se_muestra_vacia_No_existe_datos_que_coincida_con_los_criterios_de_busqueda() throws Exception {
	    System.out.println("No se muestra valores");
	}
}