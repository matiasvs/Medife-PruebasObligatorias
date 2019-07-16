@foo
Feature: Pruebas critidad: Obligatorio

#Background:
	#Given Ingreso al sitio Sume
	#And Ingreso de usuario
	#And Ingreso de password 
	#And Pantalla Alta de responsable de pago desplegada
	#When seleciona el campo Tipo de Responsable
	#And A Seleccion responsable
	#And Apagar el sistema
  
Scenario: Test obligatorios 01 - Validar la lista desplegable del combo 
Tipo de Responsable  

	Given Ingreso al sitio Sume
	And Ingreso de usuario
	And Ingreso de password 
	And Pantalla Alta de responsable de pago desplegada
  And A Seleccion Exento "Externo"
  Then validar Exento
  And A Seleccion Grupo Familiar "Grupo familiar"
  Then validar Grupo familar
  And A Seleccion Empresa "Empresa"
  Then Valiar Empresa
  And Apagar el sistema
  
Scenario: Test Obligatorios 02 - Validar comportamiento de la pantalla 
segun seleccion tipo de responsable = Empresa 
  
  Given Ingreso al sitio Sume
	And Ingreso de usuario
	And Ingreso de password 
	And Pantalla Alta de responsable de pago desplegada
  And A Seleccion Empresa "Empresa"
  Then Valiar Empresa
  Then Se habilita el boton del Buscador que permitira la seleccion de entidades
  And Apagar el sistema
  
Scenario: Test Obligatorios 03 - Validar Buscador de Entidades segun criterio
  de busqueda Con Resultado y validacion que unicamente visualice Empresas
  
	Given Ingreso al sitio Sume
	And Ingreso de usuario
	And Ingreso de password 
	And Pantalla Alta de responsable de pago desplegada
	And A Seleccion Empresa "Empresa"
  Then Valiar Empresa
  Then Se habilita el boton del Buscador que permitira la seleccion de entidades
  Then Ingresar un valor correspondiente a una Empresa
  And Ingreso de cuit "20336685525"
  And Ingreso de descripcion "descripcionNueva"
  When Selecciono boton busqueda de entidad
  Then La pantalla lista los datos que coinciden con descripcion y cuit-cuil validar campos
  And Apagar el sistema

Scenario: Test Obligatorios 04 - Segun criterio de búsqueda Descripción
  Sin Resultados Validar que el buscador sea especifico de empresas
  
  #Given Ingreso al sitio Sume
	#And Ingreso de usuario
	#And Ingreso de password 
	##And Pantalla Alta de responsable de pago desplegada
	#When seleciona el campo Tipo de Responsable
  #Then Validar seleccion de empresa
  #When Selecciono boton busqueda de entidad
  #And correspondiente a grupo familiar existente
  #And Ingreso de cuit "20336685525"
  #And Ingreso de descripcion "descripcionNueva" 	
  #When Seleccion boton buscar
  #Then La grilla se muestra vacia. No existe datos que coincida con los criterios de busqueda
  #And Apagar el sistema
	
Scenario: Test Obligatorios 05 - Validar Funcionamiento de la Pantalla de 
Resultados del Buscador de Entidades Boton Seleccionar 1 registro
	
	#Given Ingreso al sitio Sume
	#And Ingreso de usuario
	#And Ingreso de password 
	#And Pantalla Alta de responsable de pago desplegada
	#When seleciona el campo Tipo de Responsable
  #Then Validar seleccion de empresa
	#When Selecciono boton busqueda de entidad
	#When Selecciono el resultado con checkBox
	#When seleccino el boton confirmar entidad
	#Then La ventana se cierra y los datos se cargan en la pantalla Alta de responsable de pago validar valores
	#And Apagar el sistema
	
	
  
#Scenario:   
#  Scenario Outline:    
#	Examples: 
#      | Responsable | Descripcion | CuitCuil | FechaVigencia | mail | FechaCondicionIVA | FormaDePago | 
#      | Empresa     | xxxxxxxxxxx | xxxxxxxx | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |

