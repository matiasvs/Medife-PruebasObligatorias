Feature: Med 147 - Obligatorios 05 - Validar Funcionamiento de la Pantalla de
  Resultados del Buscador de Entidades Bot�n Seleccionar 1 registro

  Scenario Outline: Comportamiento
    Given Obligatorio 5 Ingreso al sistema medife
    And Obligatorio 5 Usuario: <usuario>
    And Obligatorio 5 Pass: <password>
    And Obligatorio 5 La pantalla Alta de responsable de pago desplegada
    And Obligatorio 5 los siguientes datos ingresados:
    And Obligatorio 5 Tipo de Responsable <tipoResponsable>
    And Obligatorio 5 Selecciono el boton Busqueda de entidad
    And Obligatorio 5 Se ingresa un valor de descripcion <descripcion>
    And Obligatorio 5 Se ingresa un valor de cuit <CuitCuil>
    When Obligatorio 5 Selecciono el Boton Seleccionar y se selecciona el boton Confirmar entidad
    And Obligatorio 5 Se selecciona el valor con checkbox
    Then Obligatorio 5 La aplicacion cierra la ventana Buscador de Entidades y los datos seleccionados se visualizan cargados en la pantalla Alta de Responsable de Pago no permitiendo su edicion

    Examples: 
      | tipoResponsable | usuario | password | descripcion | CuitCuil    |
      | Empresa         | mveron  | Mv190319 | SERVICIOS   | 30707000690 |
