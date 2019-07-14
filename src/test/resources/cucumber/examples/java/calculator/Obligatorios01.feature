Feature: Pruebas critidad: Obligatorio
Background:
	Given Ingreso al sitio Sume
	And Ingreso de usuario
	And Ingreso de password 
	And Pantalla Alta de responsable de pago desplegada
	When seleciona el campo Tipo de Responsable
	#Scenario Outline:
  
Scenario: Test obligatorios 01 - Validar la lista desplegable del combo Tipo de Responsable
	And A Seleccion "Empresa"
  Then Validar seleccion de empresa
  And A Seleccion "Exento"
  Then Validar Seleccion de excento
  And A Seleccion "Grupo familiar"
  Then Validar seleccion de grupo familiar
  
Sceneario:
	And A Seleccion "Empresa"
  Then Validar seleccion de empresa
  And Se habilita el boton del uscardor de entidades
  Then Validar boton busqueda de entidad
  
  Scenario Outline:
    
	Examples: 
      | Responsable | Descripcion | CuitCuil | FechaVigencia | mail | FechaCondicionIVA | FormaDePago | 
      | Empresa     | xxxxxxxxxxx | xxxxxxxx | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |

