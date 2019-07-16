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
  

	
	
	
	
  
#Scenario: 
  
#  Scenario Outline:
    
#	Examples: 
#      | Responsable | Descripcion | CuitCuil | FechaVigencia | mail | FechaCondicionIVA | FormaDePago | 
#      | Empresa     | xxxxxxxxxxx | xxxxxxxx | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |

