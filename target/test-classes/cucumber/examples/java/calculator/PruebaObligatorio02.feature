Feature: Med 127 - Obligatorios 02 - Validar comportamiento de la pantalla segun seleccion tipo de responsable = Empresa

  Scenario Outline: Comportamiento
  	Given Obligatorio b Ingreso al sistema Sumes
    And Obligatorio b Usuario: <usuario>
    And Obligatorio b Pass: <password>
    And Obligatorio b Desplegado el combo Tipo de responsable
    When Obligatorio b selecciona el campo Tipo de Responsable <Responsable>
    Then Obligatorio b Entonces se habilita el boton del Buscador que permitira la seleccion de entidades
    
	Examples: 
      | usuario | password | Responsable |
      | mveron  | Mv190319 | Empresa     |