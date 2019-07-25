package cucumber.examples.java.calculator;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.examples.java.calculator.pageobjects.AltaResponsableDePago;
import cucumber.examples.java.calculator.pageobjects.BusquedaDeEntidad;
//import util.PropertyManager;
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
	    Thread.sleep(4000);
	    resp.ingresoResponsableDePago();
		resp.ingresoAltaDeResponsable();
	}

	@Given("^A Seleccion Exento (.*)$")
	public void a_Seleccion_Exento(String Externo) throws Exception {
		Thread.sleep(3000);
		System.out.println("1");
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		System.out.println("2");
		//*[@id=\"j_idt94\"]/div/iframe
		//*[@id="j_idt93"]/div/iframe
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		System.out.println("3");
	    resp.ingresoExterno();
	    System.out.println("4");
		//resp.ingresoTipoResponsableABC(Externo);
	    driver.switchTo().defaultContent();
	    System.out.println("5");	
	}
	
	@Then("^validar Exento$")
	public void validar_Exento() throws Exception {
		System.out.println("6");
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		System.out.println("7");
		driver.switchTo().frame(frame);
		System.out.println("8");
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		Thread.sleep(1000);
		System.out.println("9");
	    resp.ValidarResponsableValorExterno();
	    System.out.println("99");
	    driver.switchTo().defaultContent();
	    System.out.println("555");
	}
	
	@Given("^A Seleccion Grupo Familiar (.*)$")
	public void a_Seleccion_Grupo_Familiar(String arg1) throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoGrupoFamiliar();
	    driver.switchTo().defaultContent();
	}
	
	@Then("^validar Grupo familar$")
	public void validar_Grupo_familar() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
		Thread.sleep(1000);
	    resp.ValidarResponsableValorGrupoFamiliar();
	    driver.switchTo().defaultContent();
	}

	@Given("^A Seleccion Empresa (.*)$")
	public void a_Seleccion_Empresa(String arg1) throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe")); 
		// id viejo //*[@id=\"j_idt94\"]/div/iframe
		// nuevo id //*[@id="j_idt93"]/div/iframe
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.ingresoEmpresa();
	    driver.switchTo().defaultContent();
	}
	
	@Then("^Valiar Empresa$")
	public void valiar_Empresa() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
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
		//Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.validarLupa();
	    resp.lupa();
	    driver.switchTo().defaultContent();
	}
	
	
	@Then("^Ingresar un valor correspondiente a una Empresa$")
	public void ingresar_un_valor_correspondiente_a_una_Empresa() throws Exception {
	    System.out.println("Ingreso de Empresa: a buscar");
	}
	
	@Then("^Ingreso de cuit (.*)$")
	public void ingreso_de_cuit(String BusquedaCuit) throws Exception {
		//Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.ingresoCuit(BusquedaCuit.trim());
	    driver.switchTo().defaultContent();
	}
	
	@Then("^Ingreso de descripcion (.*)$")
	public void ingreso_de_descripcion(String descripcion) throws Exception {
		//Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.ingresoDescripcion(descripcion.trim());
	    driver.switchTo().defaultContent();
	}
	
	@When("^Selecciono boton busqueda de entidad en PopUp$")
	public void selecciono_boton_busqueda_de_entidad_en_PopUp() throws Exception {
		//Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.lupaPopup();
	    driver.switchTo().defaultContent();
	}
	//		
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
	//check
	@When("^Seleccionar valor con checkbox$")
	public void seleccionar_valor_con_checkbox() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.check();
		System.out.println("05 check");
	    driver.switchTo().defaultContent();
	}
	@When("^Seleccionar boton confirmar entidad$")
	public void seleccionar_boton_confirmar_entidad() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.ConfirmarEntidad();
	    driver.switchTo().defaultContent();
	}
	@When("^Se cierra el popUp de busqueda de entidad$")
	public void se_cierra_el_popUp_de_busqueda_de_entidad() throws Exception {
	    Thread.sleep(1000);
	}
	@When("^Los valores seleccionados se cargan en Alta de responsable$")
	public void los_valores_seleccionados_se_cargan_en_Alta_de_responsable() throws Exception {
	    System.out.println("carga de datos");
	}
	@Then("^validando los valores de los campos razon social y cuit$")
	public void validando_los_valores_de_los_campos_razon_social_y_cuit() throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.validarNombre05();
	    Thread.sleep(1000);
	    resp.validarCuitCuil05();
	    Thread.sleep(1000);
	    driver.switchTo().defaultContent();
	}
	//
	@When("^seleccionar boton ultima pagina$")
	public void seleccionar_boton_ultima_pagina() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.ultimaPagina();
	    driver.switchTo().defaultContent();
	}
	@When("^seleccionar el ultimo resultado$")
	public void seleccionar_el_ultimo_resultado() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.checkboxLast();
	    driver.switchTo().defaultContent();
	}//
	@Then("^validando los valores de los campos razon social y cuit test seis$")
	public void validando_los_valores_de_los_campos_razon_social_y_cuit_test_seis() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.validarTituloPopup();
	    driver.switchTo().defaultContent();
	}
	
	//nuevo  entityId
	@Then("^La aplicacion despliega la ventana Buscador de entidades Mostrando los siguientes campos: #validarPopUp$")
	public void la_aplicacion_despliega_la_ventana_Buscador_de_entidades_Mostrando_los_siguientes_campos_validarPopUp() throws Exception {
	    System.out.println("Pop up busqueda entidad");
	}

	@Then("^Solo lectura Tipo de Entidad Grupo Familiar habilitados para el ingreso de datos: descripcion cuit cuil$")
	public void solo_lectura_Tipo_de_Entidad_Grupo_Familiar_habilitados_para_el_ingreso_de_datos_descripcion_cuit_cuil() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.validarValorTipoResponsableGrupo();
	    driver.switchTo().defaultContent();
	}

	@Then("^La pantalla lista los datos que coinciden con la informacion ingresada\\. Dispuestos de la siguiente manera: Descripcion - Cuit - Cuil$")
	public void la_pantalla_lista_los_datos_que_coinciden_con_la_informacion_ingresada_Dispuestos_de_la_siguiente_manera_Descripcion_Cuit_Cuil() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.validarPosicionamiento();
	    driver.switchTo().defaultContent();
	}

	@Then("^La Grilla se muestra vacia\\. No existen datos que coincidan con los criterios de busqueda ingresados\\.$")
	public void la_Grilla_se_muestra_vacia_No_existen_datos_que_coincidan_con_los_criterios_de_busqueda_ingresados() throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		BusquedaDeEntidad busqueda = new BusquedaDeEntidad(driver);
		busqueda.validarPosicionamiento();
	    driver.switchTo().defaultContent();
	}

	@Then("^Ingreso fecha de vigencia alta de responsable (.*)$")
	public void ingreso_fecha_de_vigencia_alta_de_responsable(String fechaDeVigencia) throws Exception {
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    //resp.ingresoFechaVigencia(fechaDeVigencia);   -  tomar valor de descripcion y comparar con valor en alta de responsable
	    driver.switchTo().defaultContent();
	}

	@Then("^La aplicacion cierra la ventana Buscador de Entidades y los datos seleccionados se visualizan ingresados en la pantalla Alta de Responsable de Pago no permitiendo su edicion$")
	public void la_aplicacion_cierra_la_ventana_Buscador_de_Entidades_y_los_datos_seleccionados_se_visualizan_ingresados_en_la_pantalla_Alta_de_Responsable_de_Pago_no_permitiendo_su_edicion() throws Exception {
		Thread.sleep(1000);
		WebElement frame = driver.findElement(By.xpath("//*[@id=\"j_idt93\"]/div/iframe"));
		driver.switchTo().frame(frame);
		AltaResponsableDePago resp = new AltaResponsableDePago(driver);
	    resp.validAltaRazonSocial11();
	    Thread.sleep(1000);
	    resp.validAltaCuitCuil11();
	    Thread.sleep(1000);
	    driver.switchTo().defaultContent();
	}

	@Then("^La aplicacion habilita los campos para ingresar los datos manualmente$")
	public void la_aplicacion_habilita_los_campos_para_ingresar_los_datos_manualmente() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Excepto Fecha de bja y estado que no son editables$")
	public void excepto_Fecha_de_bja_y_estado_que_no_son_editables() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Inhabilita el boton buscador de entidades$")
	public void inhabilita_el_boton_buscador_de_entidades() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Selecciono el boton Guardar en Alta de responsable$")
	public void selecciono_el_boton_Guardar_en_Alta_de_responsable() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^Guarda los datos ingresados e inicia el proceso, habilitando la seccion Datos Fiscales\\.$")
	public void guarda_los_datos_ingresados_e_inicia_el_proceso_habilitando_la_seccion_Datos_Fiscales() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^La aplicacion emite un mensaje: El campo CUIT/CUIL es requerdido\\. Y no guarda los datos$")
	public void la_aplicacion_emite_un_mensaje_El_campo_CUIT_CUIL_es_requerdido_Y_no_guarda_los_datos() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^La aplicacion emite un mensaje: Formato CUIT/CUIL invalido\\. Y no guarda los datos$")
	public void la_aplicacion_emite_un_mensaje_Formato_CUIT_CUIL_invalido_Y_no_guarda_los_datos() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@When("^Selecciono el boton Guardar o Confimar de Alta de responsable$")
	public void selecciono_el_boton_Guardar_o_Confimar_de_Alta_de_responsable() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}

	@Then("^La aplicacion emite un mensaje: CUIT - CUIL invalido\\. Ya existe un asociado activo que posee el cuit - cuil Y no guarda los datos$")
	public void la_aplicacion_emite_un_mensaje_CUIT_CUIL_invalido_Ya_existe_un_asociado_activo_que_posee_el_cuit_cuil_Y_no_guarda_los_datos() throws Exception {
	    // Write code here that turns the phrase above into concrete actions
	    throw new PendingException();
	}


}