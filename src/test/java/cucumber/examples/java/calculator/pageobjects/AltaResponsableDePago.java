package cucumber.examples.java.calculator.pageobjects;
//import static org.testng.Assert.assertEquals;

//import org.hamcrest.core.Is;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AltaResponsableDePago {
	
	private WebDriver driver;
	
	private By ByUser = By.id("j_username");
	private By ByPass = By.id("j_password");
	private By ByConfirmarLogin = By.id("j_idt18");
	private By ByInicio = By.xpath("//*[@id=\'menuAccordionPanel\']/h3[1]");
	private By ByClientes = By.id("menuAccordionPanel:initTree:1:j_idt90");
	private By ByResponsableDePago = By.xpath("//*[@id=\'menuAccordionPanel:initTree:1_2:j_idt89\']");
	//private By ByLink = By.xpath("//*[@id=\'chargePaymentManager\']/mat-toolbar");
	private By ByLupa = By.xpath("//*[@id=\'collapseChargePaymentManager\']/form/div[1]/div[3]");
	// By ByLupa2 = By.xpath("//*[@id=\'collapseChargePaymentManager\']/form/div[1]/div[3]");
	private By ByDescrip = By.id("entityCuitId");

	private By ByTipoResponsable = By.id("managerTypeId");
	private By ByTipoResponsableNuevo = By.xpath("//*[@id=\'managerTypeId\']");
	private By ByNombreApellido = By.id("fiscalNameId");
	private By ByEstado = By.id("stateId");	
	//private By estadoby =	By.xpath("driver.findElement(By.xpath(\"(.//*[normalize-space(text()) and normalize-space(.)='ACTIVO'])[1]/following::span[1]\")).click();");
	private By ByMail = By.id("emailId");
	private By ByCuitCuil = By.id("cuitId");
	private By ByFechaBaja = By.id("lowDateId");
	private By ByFechaVigencia = By.id("validDateId");
	
	private By ByCancelar = By.xpath("//*[@id=\"collapseChargePaymentManager\"]/form/div[6]/div/button[1]");
	private By ByGuardar = By.xpath("//*[@id=\"collapseChargePaymentManager\"]/form/div[5]/div[2]/div/button[2]");
	private By ByConfirmar = By.xpath("//*[@id=\"collapseChargePaymentManager\"]/form/div[5]/div[2]/div/button[1]");
	//private By ByBusquedaEntidad2 = By.xpath("//*[@id=\'mat-dialog-2\']/app-entidad/div/div/div[5]/div/button");
	
	//private By byMensajeCampoRequerido = By.xpath("/html/body/app-root/notifier-container/ul/li[1]/notifier-notification/p");
	
	// CONSTRUCTOR //
	public AltaResponsableDePago (WebDriver driver) {
		this.driver = driver;
	}
	//LOGIN
	public void ingresoUser(){
		WebDriverWait wait=new WebDriverWait(driver, 40);
		WebElement guru99seleniumlink1;
		guru99seleniumlink1= wait.until(ExpectedConditions.elementToBeClickable(ByUser));
		guru99seleniumlink1.sendKeys("mveron");
	}
	public void ingresoPass(){
		WebDriverWait wait=new WebDriverWait(driver, 40);
		WebElement guru99seleniumlink2;
		guru99seleniumlink2= wait.until(ExpectedConditions.elementToBeClickable(ByPass));
		guru99seleniumlink2.sendKeys("Mv190319");
	}
	public void ingresoConfirmar(){
		this.driver.findElement(ByConfirmarLogin).click();
	}
	public void ingresoInicio(){
		this.driver.findElement(ByInicio).click();
	}
	public void ingresoClientes(){
		this.driver.findElement(ByClientes).click();
	}
	public void ingresoResponsableDePago(){
		this.driver.findElement(ByResponsableDePago).click();
	}
		
	// METODOS //
	//public void
	public Object sss() {
		this.driver.findElement(ByTipoResponsableNuevo);
		Actions action = new Actions(driver);		 
		action.sendKeys(Keys.DOWN, Keys.ENTER).build().perform();
		return null;
	}
	
	public void ingresoTipoResponsableEmpresa(String tipoResponsable){
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink30;
		guru99seleniumlink30= wait.until(ExpectedConditions.elementToBeClickable(ByTipoResponsable));
		boolean tipoResponsables = guru99seleniumlink30.isEnabled();
		System.out.println("Tipo forma de pago es visible?: " + tipoResponsables);
		guru99seleniumlink30.sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.TAB);	
	}
//	public void ingresoTipoResponsableEmpresa(String tipoResponsable){
//		this.driver.findElement(ByTipoResponsable).sendKeys(Keys.DOWN, Keys.DOWN, Keys.DOWN, Keys.TAB);		
//	}
	
	public WebElement ingresoTipoResponsable(String tipoResponsable){
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByTipoResponsable));
		guru99seleniumlink3.sendKeys(tipoResponsable, Keys.ENTER);
//		Actions action = new Actions(driver);		 
//		action.sendKeys(Keys.ENTER).build().perform();
		return null;
	}
	
	public void closed() {
		driver.close();
		driver.quit();
		System.out.println("---Closed browser---");
	}
	
	// INGRESAR VALOR //
	public void ingresoRazonSocial(String razonSocial) {		
		this.driver.findElement(ByNombreApellido).sendKeys(razonSocial.trim());		
	}
	
	public void ingresoEstadoActivo(String EstadoActivo) {
		this.driver.findElement(ByEstado).sendKeys(EstadoActivo.trim());
	}
	
	public void ingresoEstadoInactivo(String EstadoInactivo) {
		this.driver.findElement(ByEstado).sendKeys(EstadoInactivo.trim());
	}
	
//	public void ingresoMail(String mail) {
//		this.driver.findElement(ByMail).sendKeys(mail.trim());
//	}
	public void ingresoMail(String mail) {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByMail));
		guru99seleniumlink3.sendKeys(mail.trim());
	}
	
	public void ingresoCuitCuil(String cuitCuil) {
		this.driver.findElement(ByCuitCuil).sendKeys(cuitCuil.trim());
	}
	
	public void ingresoFechaBaja(String fechaBaja) {
		this.driver.findElement(ByFechaBaja).sendKeys(fechaBaja.trim());
	}
	
	public void ingresoFechaVigencia(String fechaVigencia) {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByFechaVigencia));
		guru99seleniumlink3.sendKeys(fechaVigencia.trim());
	}
//	public void ingresoFechaVigencia(String fechaVigencia) {
//		this.driver.findElement(ByFechaVigencia).sendKeys(fechaVigencia.trim());
//	}
	
	public void lupa() {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByLupa));
		guru99seleniumlink3.click();
	}
//	public void lupa() {
//		driver.findElement(ByLupa).click();
//		//driver.findElement(ByDescrip).sendKeys(Keys.TAB, Keys.ENTER);
//	}
//	public void lupa() {
//		driver.findElement(ByLupa).click();
//		driver.findElement(ByDescrip).sendKeys(Keys.TAB, Keys.ENTER);
//	}
	public void lupa2() {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByDescrip));
		guru99seleniumlink3.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
	}
	
	// BOTONES //	
//	public void btnConfirmar() throws InterruptedException {
//		this.driver.findElement(ByConfirmar).click();
//		Thread.sleep(2000);
//	}
	public void btnConfirmar() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByConfirmar));
		guru99seleniumlink3.click();
	}
	
	public void btnGuardar() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByGuardar));
		guru99seleniumlink3.click();
	}
//	public void btnGuardar() throws InterruptedException {
//		this.driver.findElement(ByGuardar).click();
//		Thread.sleep(2000);
//	}
	
	public void btnCancelar() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByCancelar));
		guru99seleniumlink3.click();
	}
//	public void btnCancelar() throws InterruptedException {
//		this.driver.findElement(ByCancelar).click();
//		Thread.sleep(2000);
//	}
	
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
