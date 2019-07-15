package cucumber.examples.java.calculator.pageobjects;
import static org.testng.Assert.assertEquals;

//import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaResponsableDePago extends Base{
	
	
	private WebDriver driver;
	
	private By ByUser = By.id("j_username");
	private By ByPass = By.id("j_password");
	private By ByConfirmarLogin = By.id("j_idt18");
	private By ByInicio = By.xpath("//*[@id=\'menuAccordionPanel\']/h3[1]");
	private By ByClientes = By.id("menuAccordionPanel:initTree:1:j_idt90");
	private By ByResponsableDePago = By.xpath("//*[@id=\'menuAccordionPanel:initTree:1_2:j_idt89\']");
	
	private By ByLupa = By.xpath("//*[@id=\'collapseChargePaymentManager\']/form/div[1]/div[3]");
	private By ByDescrip = By.id("entityCuitId");

	private By ByTipoResponsable = By.id("managerTypeId");
	private By ByTipoResponsableNuevo = By.xpath("//*[@id=\'managerTypeId\']");
	private By ByNombreApellido = By.id("fiscalNameId");
	private By ByEstado = By.id("stateId");	
	private By ByMail = By.id("emailId");
	private By ByCuitCuil = By.id("cuitId");
	private By ByFechaBaja = By.id("lowDateId");
	private By ByFechaVigencia = By.id("validDateId");
	
	private By ByCancelar = By.xpath("//*[@id=\"collapseChargePaymentManager\"]/form/div[6]/div/button[1]");
	private By ByGuardar = By.xpath("//*[@id=\"collapseChargePaymentManager\"]/form/div[5]/div[2]/div/button[2]");
	private By ByConfirmar = By.xpath("//*[@id=\"collapseChargePaymentManager\"]/form/div[5]/div[2]/div/button[1]");
	
	// CONSTRUCTOR //
	public AltaResponsableDePago(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
//	public AltaResponsableDePago (WebDriver driver) {
//		this.driver = driver;
//	}
	
	//LOGIN
	public void ingresoUser(String usuario){
		WebDriverWait wait1=new WebDriverWait(driver, 300);
		WebElement user;
		user= wait1
				.until(ExpectedConditions
						.elementToBeClickable(ByUser));
		if (isDisplayed(ByUser)) {
			user.clear();
			user.sendKeys(usuario.trim());
			assertEquals(user, usuario, "El valor usuario no es el esperado: " + user);
			user.submit();
		}		
	}
	
	public void ingresoUser2(String usuario){
		WebDriverWait wait22=new WebDriverWait(driver, 300);
		WebElement us;
		us= wait22
				.until(ExpectedConditions
						.elementToBeClickable(ByUser));
		us.clear();
		us.sendKeys(usuario.trim());
	}
	
	public void ingresoPass(String password){
		WebDriverWait wait2=new WebDriverWait(driver, 300);
		WebElement pass;
		pass= wait2
				.until(ExpectedConditions
						.elementToBeClickable(ByPass));
		pass.clear();
		pass.sendKeys(password.trim());
	}
	
	public void ingresoConfirmar(){
		WebDriverWait wait3=new WebDriverWait(driver, 300);
		WebElement confimarMedife;
		confimarMedife= wait3
				.until(ExpectedConditions
						.elementToBeClickable(ByConfirmarLogin));
		confimarMedife.click();
	}
	public void ingresoInicio(){
		WebDriverWait wait4=new WebDriverWait(driver, 300);
		WebElement inicioMedife;
		inicioMedife= wait4
				.until(ExpectedConditions
						.elementToBeClickable(ByInicio));
		inicioMedife.click();
	}
	public void ingresoClientes(){
		WebDriverWait wait5=new WebDriverWait(driver, 300);
		WebElement clienteMedife;
		clienteMedife= wait5
				.until(ExpectedConditions
						.elementToBeClickable(ByClientes));
		clienteMedife.click();
	}
	public void ingresoResponsableDePago(){
		WebDriverWait wait6=new WebDriverWait(driver, 300);
		WebElement responsableDePago;
		responsableDePago= wait6
				.until(ExpectedConditions
						.elementToBeClickable(ByResponsableDePago));
		responsableDePago.click();
	}
		
	// METODOS //	
	public void ingresoTipoResponsableEmpresa(String tipoResponsable){
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink30;
		guru99seleniumlink30= wait.until(ExpectedConditions.elementToBeClickable(ByTipoResponsable));
		boolean tipoResponsables = guru99seleniumlink30.isEnabled();
		System.out.println("Tipo forma de pago es visible?: " + tipoResponsables);
		guru99seleniumlink30.sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.TAB);	
	}
	public WebElement ingresoTipoResponsableABC(String tipoResponsable){
		this.driver.findElement(ByTipoResponsableNuevo).sendKeys(tipoResponsable);
		Actions action = new Actions(driver);		 
		action.sendKeys(Keys.TAB).build().perform();
		return null;
	}
		
	public void closed() {
		driver.close();
		driver.quit();
		System.out.println("---Closed browser---");
	}
	
	// INGRESAR VALOR //
	public void ingresoRazonSocial(String razonSocial) {		
		WebDriverWait wait10=new WebDriverWait(driver, 300);
		WebElement social;
		social= wait10
				.until(ExpectedConditions
						.elementToBeClickable(ByNombreApellido));
		social.click();
		social.clear();
		social.sendKeys(razonSocial.trim());
		social.submit();
	}
	
	public void ingresoEstadoActivo(String EstadoActivo) {
		WebDriverWait wait11=new WebDriverWait(driver, 300);
		WebElement estado;
		estado= wait11
				.until(ExpectedConditions
						.elementToBeClickable(ByEstado));
		estado.click();
		estado.clear();
		estado.sendKeys(EstadoActivo.trim());
		estado.submit();
	}
	
	public void ingresoEstadoInactivo(String EstadoInactivo) {
		this.driver.findElement(ByEstado).sendKeys(EstadoInactivo.trim());
	}
	
	public void ingresoMail(String mail) {
		WebDriverWait wait12=new WebDriverWait(driver, 300);
		WebElement email;
		email= wait12
				.until(ExpectedConditions
						.elementToBeClickable(ByMail));
		email.click();
		email.clear();
		email.sendKeys(mail.trim());
		email.submit();
	}
	
	public void ingresoCuitCuil(String cuitCuil) {
		WebDriverWait wait14=new WebDriverWait(driver, 300);
		WebElement cuit;
		cuit= wait14
				.until(ExpectedConditions
						.elementToBeClickable(ByCuitCuil));
		cuit.click();
		cuit.clear();
		cuit.sendKeys(cuitCuil.trim());
		cuit.submit();
	}
	
	public void ingresoFechaBaja(String fechaBaja) {
		WebDriverWait wait15=new WebDriverWait(driver, 300);
		WebElement fechabaja;
		fechabaja= wait15
				.until(ExpectedConditions
						.elementToBeClickable(ByFechaBaja));
		fechabaja.click();
		fechabaja.clear();
		fechabaja.sendKeys(fechaBaja.trim());
		fechabaja.submit();
	}
	
	public void ingresoFechaVigencia(String fechaVigencia) {
		WebDriverWait wait16=new WebDriverWait(driver, 300);
		WebElement fechavigencia;
		fechavigencia= wait16
				.until(ExpectedConditions
						.elementToBeClickable(ByFechaVigencia));
		fechavigencia.click();
		fechavigencia.clear();
		fechavigencia.sendKeys(fechaVigencia.trim());
		fechavigencia.submit();
	}
	
	public void lupa() {
		WebDriverWait wait17=new WebDriverWait(driver, 300);
		WebElement buscar;
		buscar= wait17
				.until(ExpectedConditions
						.elementToBeClickable(ByLupa));
		buscar.click();
	}

	public void lupa2() {
		WebDriverWait wait18=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait18.until(ExpectedConditions.elementToBeClickable(ByDescrip));
		guru99seleniumlink3.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
	}
	
	// BOTONES //	

	public void btnConfirmar() throws InterruptedException {
		WebDriverWait wait19=new WebDriverWait(driver, 300);
		WebElement confimar;
		confimar= wait19
				.until(ExpectedConditions
						.elementToBeClickable(ByConfirmar));
		confimar.click();
	}
	
	public void btnGuardar() throws InterruptedException {
		WebDriverWait wait20=new WebDriverWait(driver, 300);
		WebElement guardar;
		guardar= wait20
				.until(ExpectedConditions
						.elementToBeClickable(ByGuardar));
		guardar.click();
	}

	public void btnCancelar() throws InterruptedException {
		WebDriverWait wait21=new WebDriverWait(driver, 300);
		WebElement cancelar;
		cancelar= wait21
				.until(ExpectedConditions
						.elementToBeClickable(ByCancelar));
		cancelar.click();
	}

	// VALIDAR CAMPOS //
	public void validTitle() {
		JavascriptExecutor js =(JavascriptExecutor)driver;
		String title = js.executeScript("return document.title;").toString();
		System.out.println(title);        
	}
	
	// Validar test 05
	public void validTipoResonsable05() {		
		String checkTipoResponsable = this.driver.findElement(ByNombreApellido).getAttribute("value");
		System.out.println("Valor Descripcion encontrado: "+checkTipoResponsable);
		//assertEquals(checkTipoResponsable, "GARRI FABIO DANIEL", "No se encontro el valor esperado: ");		
 	}
	
	public void validAltaCuitCuil05() {
		String checkCuitCuil = this.driver.findElement(ByCuitCuil).getAttribute("value");
		System.out.println("Valor CUIT - CUIL encontrado: "+checkCuitCuil);
		//assertEquals(checkCuitCuil, "20200081170", "No se encontro el cuit/cuil esperado: ");
	}
	
	// Validar test 11
	public void validTipoResonsable11() {		
		String checkTipoResponsable = this.driver.findElement(ByNombreApellido).getAttribute("value");
		System.out.println(checkTipoResponsable);
		//assertEquals(checkTipoResponsable, "RETEGUI ", "No se encontro el valor esperado: ");	
 	}
	
	public void validAltaCuitCuil11() {
		String checkCuitCuil = this.driver.findElement(ByCuitCuil).getAttribute("value");
		System.out.println(checkCuitCuil);
		//assertEquals(checkCuitCuil, "20208377923", "No se encontro el cuit/cuil esperado: ");
	}	
	
		
	// VALIDAR MENSAJES //	
	public void checkCampoRequerido() {
		String stringCampoRequerido = this.driver.findElement(By.xpath("//p[contains(text(),'Por favor complete los campos requeridos')]")).getText();
		System.out.println("Se muestra el mensaje: "+stringCampoRequerido);
		//assertEquals(stringCampoRequerido, "Por favor complete los campos requeridos", "No se encontro el mensaje de campo Requerido esperado: ");
	}
	
	public void checkCampoRequeridoXpath() {
		String stringCampoRequerido = this.driver.findElement(By.xpath("/html/body/app-root/notifier-container/ul/li[1]/notifier-notification/p")).getText();
		System.out.println("Se muestra el mensaje: "+stringCampoRequerido);
		//assertEquals(stringCampoRequerido, "Por favor complete los campos requeridos", "No se encontro el mensaje de campo Requerido esperado: ");
	}
	
	public void checkFechaVigencia() {
		String stringFechaVigencia = this.driver.findElement(By.xpath("//p[contains(text(),'La fecha de vigencia no debe ser menor a 6 meses n')]")).getText();
		System.out.println("Se muestra el mensaje: "+stringFechaVigencia);
		//assertEquals(stringFechaVigencia, "La fecha de vigencia no debe ser menor a 6 meses ni posterior a 6 meses de la fecha actual", "No se encontro el mensaje fecha de vigencia esperado: ");
	}
	//var eeee = $x("//p[contains(string(),'Responsable de pago guardado correctamente')]")
	public void checkGuardar() {
		String stringGuardar = this.driver.findElement(By.xpath("//p[contains(string(),'Responsable de pago guardado correctamente')]")).getText();
		System.out.println("Mensaje desde el boton GUARDAR: " + stringGuardar);
		//assertEquals(stringGuardar, "Responsable de pago guardado correctamente", "No se encontro el mensaje de guardar correspondiente: ");
	}
}
