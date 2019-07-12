@foo
Feature: Med 126 - Obligatorios 01 - Validar la lista desplegable del combo Tipo de Responsable

  Scenario Outline: Comportamiento
    Given Obligatorio a1 Ingreso al sistema Sumes
    And Obligatorio a1 Usuario: <usuario>
    And Obligatorio a1 Pass: <password>
    And Obligatorio a1 Seleccion alta de responsable de pago
    And Obligatorio a1 la pantalla Alta de responsible de pago desplegada
    When Obligatorio a1 seleciona el campo Tipo de Responsable
    When Obligatorio a1 A Selecciono Empresa <Responsable>

    Examples: 
      | usuario | password | Responsable |
      | mveron  | Mv190319 | Empresa     |
      | mveron  | Mv190319 | Externo     |
      | mveron  | Mv190319 | Grupo       |
