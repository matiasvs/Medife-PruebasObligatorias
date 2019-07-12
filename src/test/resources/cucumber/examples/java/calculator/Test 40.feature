Feature: Med 126 - Obligatorios numero 42

  Scenario Outline: Comportamiento
    Given Ingreso al sistema Sume
    And Usuario: <usuario>
    And Pass: <password>
    And Seleccion alta de responsable de pago
    And Tipo de responsable <Responsable>
    And Busqueda de entidad
    And Ingreso de cuit - Cuil <cuit-cuil>
    And Ingreso de descripcion <descripcion>
    And Seleccionar resultado y confimar entidad
    And Ingreso de fecha de vigencia <fechaDeVigencia>
    And Ingreso de correo <correo>
    When Seleccion boton confimar
    Then Validacion ingreso a la pantalla de datos fiscales
    And Ingreso fecha datos fiscales <fechaInicio>
    And Seleccion Tipo de pago "Pago presencial"
    And Ingresar nuevo telefono
    When selecionar confimar datos fisacales
    Then Validar pantalla bandeja de entrada

    Examples: 
      | Responsable | usuario   | password | descripcion                   | cuit-cuil   | correo               | fechaDeVigencia | fechaInicio |
      | Empresa     | mveron    | Mv190319 | PONCE CESAR HERNAN            | 20107321048 | Mveron@OpenDev.com   | 04/07/2019      | 04/07/2019  |
      | Empresa     | mponcetta | Mp190319 | INSTITUTO MARIA MADRE NUESTRA | 30679250945 | Mponceta@OpenDev.com | 06/07/2019      | 03/07/2019  |
      | Empresa     | mciarla   | Mc190319 | BANCO PIANO S.A.              | 30569151763 | Mciarla@OpenDev.com  | 08/07/2019      | 01/07/2019  |
