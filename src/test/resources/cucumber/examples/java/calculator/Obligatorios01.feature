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

  Scenario Outline: Test Obligatorios 03 - Validar Buscador de Entidades segun criterio
                    de busqueda Con Resultado y validacion que unicamente visualice Empresas
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Empresa"
    Then Valiar Empresa
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    Then Ingresar un valor correspondiente a una Empresa
    And Ingreso de cuit <CuitCuil>
    And Ingreso de descripcion <Descripcion>
    When Selecciono boton busqueda de entidad en PopUp
    Then La pantalla lista los datos que coinciden con descripcion y cuit-cuil validar campos
    And Apagar el sistema
    Examples: 
      | Responsable | Descripcion        | CuitCuil    | FechaVigencia | mail | FechaCondicionIVA | FormaDePago |
      | Empresa     | NALCO ARGENTINA SA | 30587375296 | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |
	
  Scenario Outline: Test Obligatorios 04 - Segun criterio de búsqueda Descripción
                    Sin Resultados Validar que el buscador sea especifico de empresas 
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Empresa"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And correspondiente a grupo familiar existente
    And Ingreso de cuit <CuitCuil>
    And Ingreso de descripcion <Descripcion>
    When Selecciono boton busqueda de entidad en PopUp
    Then La grilla se muestra vacia. No existe datos que coincida con los criterios de busqueda
    And Apagar el sistema
    Examples: 
      | Responsable | Descripcion        | CuitCuil    | FechaVigencia | mail | FechaCondicionIVA | FormaDePago |
      | Empresa     | NALCO | 30587375296 | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |
  
  Scenario Outline: Test Obligatorios 05 - Validar Funcionamiento de la Pantalla de 
                     Resultados del Buscador de Entidades Bot�n Seleccionar 1 registro
    #Given Obligatorio 5 Dado un usuario perfil situado en la pantalla Alta de responsabilidad de pago
    #And Obligatorio 5 Usuario: <maru>
    #And Obligatorio 5 Pass: <p456>    
    #And Obligatorio 5 La pantalla Alta de responsable de pago desplegada
    #And Obligatorio 5 los siguientes datos ingresados:
    #And Obligatorio 5 Tipo de Responsable <tipoResponsable>
    #And Obligatorio 5 Selecciono el boton Busqueda de entidad
    #And Obligatorio 5 Se ingresa un valor de descripcion <descripcion>
    #And Obligatorio 5 Se ingresa un valor de cuit <BusquedaCuit>    
    #When Obligatorio 5 Selecciono el Boton Seleccionar y se selecciona el boton Confirmar entidad
    #And Obligatorio 5 Se selecciona el valor con checkbox
    #Then Obligatorio 5 La aplicacion cierra la ventana Buscador de Entidades y los datos seleccionados se 
    #visualizan cargados en la pantalla Alta de Responsable de Pago no permitiendo su edicion

#Scenario:   
#  Scenario Outline:    
#	Examples: 
#      | Responsable | Descripcion | CuitCuil | FechaVigencia | mail | FechaCondicionIVA | FormaDePago | 
#      | Empresa     | xxxxxxxxxxx | xxxxxxxx | xxxxxxxxxxxxx | xxxx | xxxxxxxxxxxxxxxxx | xxxxxxxxxxx |
