package cucumber.examples.java.calculator.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
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
	private By ByTitleBusquedaEntidad = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/h3");
	//private By ByTitleBusquedaEntidad = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/mat-toolbar"); 
	private By ByDescripcionResultado = By.id("descriptionId");
	private By ByLupa = By.id("entityCuitId");
	private By ByResultadoCuit = By.xpath("//*[@id=\'mat-dialog-0\']/app-entidad/div/div/div[4]/div/table/tbody/tr/td[2]");
	
	private By ByEnabledDescripcion = By.id("descriptionId");
	private By ByEnabledCuitCuil = By.id("entityCuitId");
	
	public BusquedaDeEntidad (WebDriver driver) {
		this.driver = driver;
	}
	
	// CAMPOS PANTALLA //
	public void botonBusquedaEntidades() {
		WebDriverWait wait1=new WebDriverWait(driver, 60);
		WebElement BEEntidad;
		BEEntidad= wait1
				.until(ExpectedConditions
						.elementToBeClickable(ByBusquedaEntidades));
		BEEntidad.click();
	}
	
	public void ingresoDescripcion(String descipcion) {
		WebDriverWait wait2=new WebDriverWait(driver, 60);
		WebElement BEdescripcion;
		BEdescripcion= wait2
				.until(ExpectedConditions
						.presenceOfElementLocated(ByDescripcionID));
		BEdescripcion.click();
		BEdescripcion.clear();
		BEdescripcion.sendKeys(descipcion.trim());
	}

	public void ingresoCuit(String BusquedaCuit) {
		WebDriverWait wait3=new WebDriverWait(driver, 60);
		WebElement BEcuitCuil;
		BEcuitCuil= wait3
				.until(ExpectedConditions //presenceOfElementLocated
						.presenceOfElementLocated(ByBusquedaCuitID));//elementToBeClickable
		BEcuitCuil.click();
		BEcuitCuil.clear();
		BEcuitCuil.sendKeys(BusquedaCuit.trim());
	}

	public void check() throws InterruptedException {
		WebDriverWait wait4=new WebDriverWait(driver, 60);
		WebElement BEcheck;
		BEcheck= wait4
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-0\"]/app-entidad/div/div/div[3]/table/tbody/tr")));
		BEcheck.click();
	}
	
	public void botonBusqueda() throws InterruptedException {
		WebDriverWait wait5=new WebDriverWait(driver, 60);
		WebElement BEBusqueda;
		BEBusqueda= wait5
				.until(ExpectedConditions
						.elementToBeClickable(ByBusquedaEntidadesPopUp));
		BEBusqueda.click();
	}

	public void ConfirmarEntidad() throws InterruptedException {
		WebDriverWait wait6=new WebDriverWait(driver, 60);
		WebElement BEConfirmar;
		BEConfirmar= wait6
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//*[@id=\"mat-dialog-0\"]/app-entidad/div/div/div[4]/div[2]/div/button")));
		//*[@id="mat-dialog-0"]/app-entidad/div/div/div[4]/div[2]/div/button
		BEConfirmar.click();
	}
	
	public void ultimaPagina() throws InterruptedException {
		WebDriverWait wait7=new WebDriverWait(driver, 60);
		WebElement BEUltimaPagina;
		BEUltimaPagina= wait7
				.until(ExpectedConditions
						.elementToBeClickable(By.xpath("//button[@class='mat-paginator-navigation-last mat-icon-button ng-star-inserted']")));
		
		
		BEUltimaPagina.click();
	}
	//*[@id='mat-dialog-0']/app-entidad/div/div/div[4]/div/table/tbody/tr[last()]/td[1]  mat-checkbox-1
	
	//*[@id=\'mat-dialog-0\']/app-entidad/div/div/div[3]/table/tbody/tr[last()][5]"
	public void checkboxLast() throws InterruptedException {
		WebDriverWait wait18=new WebDriverWait(driver, 60);
		WebElement BECheckLast;
		BECheckLast= wait18
				.until(ExpectedConditions               //*[@id="mat-dialog-0"]/app-entidad/div/div/div[3]/table/tbody/tr[1]
									             		//*[@id="mat-dialog-0"]/app-entidad/div/div/div[3]/table/tbody/tr[1]/td[1]
						.elementToBeClickable(By.id("mat-checkbox-1")));
		BECheckLast.sendKeys(Keys.TAB);
	}
	
//	public void checkboxLast() throws InterruptedException {
//		WebDriverWait wait18=new WebDriverWait(driver, 60);
//		WebElement BECheckLast;
//		BECheckLast= wait18
//				.until(ExpectedConditions               //*[@id="mat-dialog-0"]/app-entidad/div/div/div[3]/table/tbody/tr[1]
//									             		//*[@id="mat-dialog-0"]/app-entidad/div/div/div[3]/table/tbody/tr[1]/td[1]
//						.elementToBeClickable(By.xpath("//*[@id='mat-dialog-0']/app-entidad/div/div/div[4]/div/table/tbody/tr[last()]/td[1]")));
//		BECheckLast.click();
//	}
	
	public void lupaPopup() {
		WebDriverWait wait9=new WebDriverWait(driver, 90);
		WebElement BELupaBusqueda;
		BELupaBusqueda= wait9
				.until(ExpectedConditions //elementToBeClickable             presenceOfElementLocated
						.presenceOfElementLocated(ByLupa));
		BELupaBusqueda.sendKeys(Keys.TAB, Keys.TAB, Keys.ENTER);
	}

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
		org.junit.Assert.assertEquals("Búsqueda de entidad", checkTitlePopUp); 
		//assertEquals(checkTitlePopUp, "Búsqueda de entidad", "No se encontre el valor: ");
	}
	
	public void validarPosicionamiento() {
		
	}
	
	public void validarGrillaVacia() {
		
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
