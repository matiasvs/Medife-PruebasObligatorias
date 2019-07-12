@foo
Feature: Med 126 - Obligatorios 01 - Validar la lista desplegable del combo Tipo de Responsable

  Scenario Outline: Comportamiento
    Given Obligatorio a Ingreso al sistema Sumes
    And Obligatorio a Usuario: <usuario>
    And Obligatorio a Pass: <password>
    And Obligatorio a Seleccion alta de responsable de pago
    And Obligatorio a la pantalla Alta de responsible de pago desplegada
    When Obligatorio a seleciona el campo Tipo de Responsable
    When Obligatorio a A Selecciono Empresa <Responsable>

    Examples: 
      | usuario | password | Responsable |
      | mveron  | Mv190319 | Empresa     |
      | mveron  | Mv190319 | Externo     |
      | mveron  | Mv190319 | Grupo       |
