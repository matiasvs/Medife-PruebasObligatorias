Feature: Pruebas critidad: Obligatorio

Background:
	Given Ingreso al sitio Sume
	And Ingreso de usuario
	And Ingreso de password 
	And Pantalla Alta de responsable de pago desplegada
	When seleciona el campo Tipo de Responsable
	And Apagar el sistema
  
Scenario: Test obligatorios 01 - Validar la lista desplegable del combo 
Tipo de Responsable
	And A Seleccion "Empresa"
  Then Validar seleccion de empresa
  And A Seleccion "Exento"
  Then Validar Seleccion de excento
  And A Seleccion "Grupo familiar"
  Then Validar seleccion de grupo familiar
  
Scenario: Test Obligatorios 02 - Validar comportamiento de la pantalla segun 
seleccion tipo de responsable = Empresa
	And A Seleccion "Empresa"
  Then Validar seleccion de empresa
  And Se habilita el boton del uscardor de entidades
  Then Validar boton busqueda de entidad
  
Scenario: Test Obligatorios 03 - Validar Buscador de Entidades segun criterio
  de busqueda Con Resultado y validacion que unicamente visualice Empresas
  And A seleccion "Empresa"
  When Selecciono boton busqueda de entidad
  Then Ingresar un valor correspondiente a una "Empresa"
  When Selecciono boton busqueda de entidad
  Then La pantalla lista los datos que coinciden con descripcion y cuit-cuil
  
Scenario: Test Obligatorios 04 - Segun criterio de búsqueda Descripción
  Sin Resultados Validar que el buscador sea especifico de empresas
  And A seleccion "Empresa"
  When Selecciono boton busqueda de entidad
  And Ingreso "Descripcion" y "Cuit" correspondiente a grupo familiar existente
  When Seleccion boton buscar
  Then La grilla se muestra vacia. No existe datos que coincida con los criterios de busqueda
  
Scenario: Test Obligatorios 05 - Validar Funcionamiento de la Pantalla de 
Resultados del Buscador de Entidades Bot�n Seleccionar 1 registro
	And A seleccion "Empresa"
	When Selecciono boton busqueda de entidad
	And Ingreso "Descripcion" 
	And Ingresoy "Cuit"
	When Selecciono el resultado con checkBox
	When selecino el boton confirmar entidad
	Then La ventana se cierra y los datos se cargan en la pantalla Alta de responsable de pago
	
	
	
  
#Scenario: 
  
#  Scenario Outline:
    
#	Examples: 
#      | Responsable | Descripcion | CuitCuil | FechaVigencia | mail | FechaCondicionIVA | FormaDePago | 
#      | Empresa     | xxxxxxxxxxx | xxxxxxxx | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |

