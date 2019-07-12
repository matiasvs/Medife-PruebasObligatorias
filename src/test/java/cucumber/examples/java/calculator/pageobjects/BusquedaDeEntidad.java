package cucumber.examples.java.calculator.pageobjects;
//import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
//import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BusquedaDeEntidad {

	private WebDriver driver;
	
	private By ByBusquedaEntidades = By.xpath("//*[@id=\'collapseChargePaymentManager\']/form/div[5]/button");
	private By ByDescripcionID = By.id("descriptionId");
	private By ByBusquedaCuitID = By.id("entityCuitId");
	private By ByBusquedaEntidadesPopUp = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/div/div[3]/div/button[1]");	
	private By ByResponsablePopUp = By.id("entityId");	
	private By ByTitleBusquedaEntidad = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/mat-toolbar");//*[@id="mat-dialog-0"]/app-entidad/div/mat-toolbar
	//private By ByValidarResponsable = By.id("entityId");
	//private By ByBotonConfirmarEntidad = By.xpath("//*[normalize-space(text()) and normalize-space(.)='Registros por p�gina'])[1]/following::span[9]");
	private By ByDescripcionResultado = By.id("descriptionId");
	//private By ByDescripcionResultado = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/div/div[4]/div/table/tbody/tr/td[3]");
	                                              
	private By ByResultadoCuit = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/div/div[4]/div/table/tbody/tr/td[2]");
	
	private By ByEnabledDescripcion = By.id("descriptionId");
	private By ByEnabledCuitCuil = By.id("entityCuitId");
	
	public BusquedaDeEntidad (WebDriver driver) {
		this.driver = driver;
	}
	
	// CAMPOS PANTALLA //
	public void botonBusquedaEntidades() {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByBusquedaEntidades));
		guru99seleniumlink3.click();
	}
//	public void botonBusquedaEntidades() throws InterruptedException {
//		this.driver.findElement(ByBusquedaEntidades).click();
//		Thread.sleep(2000);
//	}
	
	public void ingresoDescripcion(String descipcion) {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlinkA;
		guru99seleniumlinkA= wait.until(ExpectedConditions.elementToBeClickable(ByDescripcionID));
		guru99seleniumlinkA.sendKeys(descipcion.trim());
	}
//	public void ingresoDescripcion(String descipcion) {
//		this.driver.findElement(ByDescripcionID).sendKeys(descipcion.trim());
//	}
	
	public void ingresoBusquedaCuit(String BusquedaCuit) {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlinkB;
		guru99seleniumlinkB= wait.until(ExpectedConditions.elementToBeClickable(ByBusquedaCuitID));
		guru99seleniumlinkB.sendKeys(BusquedaCuit.trim());
	}
//	public void ingresoBusquedaCuit(String BusquedaCuit) {
//		this.driver.findElement(ByBusquedaCuitID).sendKeys(BusquedaCuit.trim());
//	}
	
//	public void check() throws InterruptedException {
//		//driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Descripci�n'])[2]/following::div[1]")).click();
//		driver.findElement(By.xpath("//*[@id=\"mat-dialog-0\"]/app-entidad/div/div/div[4]/div/table/tbody/tr")).click();
//		System.out.println("check");
//		Thread.sleep(3000);
//	}
	public void check() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 430);
		WebElement guru99seleniumlinkC;
		guru99seleniumlinkC= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-0\"]/app-entidad/div/div/div[3]/table/tbody/tr")));
		guru99seleniumlinkC.click();//*[@id="mat-dialog-0"]/app-entidad/div/div/div[3]/table/tbody/tr
	}
	
	public void botonBusqueda() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(ByBusquedaEntidadesPopUp));
		guru99seleniumlink3.click();
	}
//	public void botonBusqueda() throws InterruptedException {
//		this.driver.findElement(ByBusquedaEntidadesPopUp).click();
//		Thread.sleep(1000);
//	}
	
	public void ConfirmarEntidad() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 420);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-0\"]/app-entidad/div/div/div[4]/div[2]/div/button")));
		guru99seleniumlink3.click();
	}
	
	public void ultimaPagina() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//button[@class='mat-paginator-navigation-last mat-icon-button ng-star-inserted']")));
		guru99seleniumlink3.click();
	}
//	public void ultimaPagina() throws InterruptedException {
//		driver.findElement(By.xpath("//button[@class='mat-paginator-navigation-last mat-icon-button ng-star-inserted']")).click();
//		Thread.sleep(5000);
//	}
	
	public void checkboxLast() throws InterruptedException {
		WebDriverWait wait=new WebDriverWait(driver, 20);
		WebElement guru99seleniumlink3;
		guru99seleniumlink3= wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id='mat-dialog-0']/app-entidad/div/div/div[4]/div/table/tbody/tr[last()]/td[1]")));
		guru99seleniumlink3.click();
	}
//	public void checkboxLast() throws InterruptedException {
//		driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-entidad/div/div/div[4]/div/table/tbody/tr[last()]/td[1]")).click();
//		Thread.sleep(500);           //*[@id="mat-dialog-0"]/app-entidad/div/div/div[4]/div/table/tbody/tr
//	}
	
	public void ValidarUltimaDescripcion() throws InterruptedException {
		//String tomarUltimaDescripcion = driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-entidad/div/div/div[4]/div/table/tbody/tr[last()]/td[2]")).getText();
		Thread.sleep(500);
		
	}
	
	public void validarUltimaCuit() throws InterruptedException {
		String tomarUltimaCuit = driver.findElement(By.xpath("//*[@id='mat-dialog-0']/app-entidad/div/div/div[4]/div/table/tbody/tr[last()]/td[3]")).getText();
		Thread.sleep(500);
		System.out.println(tomarUltimaCuit);
		//assertEquals(tomarUltimaCuit, "Empresa", "No se encontre el valor: "); 
	}
	
	// VALIDACIONES // 
	public void validarBtnBusqueda() throws InterruptedException {
		this.driver.findElement(ByBusquedaEntidadesPopUp).click();
		Thread.sleep(4000);
		System.out.println("boton");
	}
	
	public void validarResposableEmpresa() {
		String checkResponsable = this.driver.findElement(ByResponsablePopUp).getText();
		System.out.println(checkResponsable);
		//assertEquals(checkResponsable, "Empresa", "No se encontre el valor: "); 
	}
	
	public void validarTituloPopup() {
		String checkTitlePopUp = this.driver.findElement(ByTitleBusquedaEntidad).getText();
		System.out.println("titulo validado: " + checkTitlePopUp);
		//assertEquals(checkTitlePopUp, "B�squeda de entidad", "No se encontre el valor: ");
	}
	
	public void validarResposableGrupoFamiliar() {
		String checkValorResponsable = this.driver.findElement(ByResponsablePopUp).getText();
		System.out.println("titulo validado: " + checkValorResponsable);
		//assertEquals(checkValorResponsable, "Grupo Familiar", "No se encontre el valor: ");
	}
	
//	public void validarResultadoDescripcionTest3 () {
//		String checkRestDescripcion = this.driver.findElement(ByDescripcionResultado).getText();
//		System.out.println("Resultado encontrado: " + checkRestDescripcion);
//		assertEquals(checkRestDescripcion, "QUITRAL COM S.A.", "No se encontre el valor: ");
//	}
	public void validarResultadoDescripcionTest3 () {
		String checkRestDescripcion = this.driver.findElement(ByDescripcionResultado).getAttribute("value");
		System.out.println("Resultado encontrado: " + checkRestDescripcion);
		//assertEquals(checkRestDescripcion, "QUITRAL COM S.A.", "No se encontre el valor: ");
	}
	
	public void validarResultadoCuit () {
		String checkRestCuit = this.driver.findElement(ByResultadoCuit).getText();
		System.out.println("Resultado encontrado: " + checkRestCuit);
		//assertEquals(checkRestCuit, "OSRAM DE ARGENTINA", "No se encontre el valor: ");
	}
	
	public void descripcionIsEnabled() {
		boolean checkDescripcionEnabled = this.driver.findElement(ByEnabledDescripcion).isEnabled();
		System.out.println("El campo DESCRIPCION es editable: " + checkDescripcionEnabled);
	}
	
	public void cuitCuilIsEnabled() {
		boolean checkCuiCuilEnabled = this.driver.findElement(ByEnabledCuitCuil).isEnabled();
		System.out.println("El campo CUIT CUIL es editable: " + checkCuiCuilEnabled);
	}
}
