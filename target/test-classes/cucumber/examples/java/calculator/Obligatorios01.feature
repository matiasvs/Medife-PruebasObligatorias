
Feature: Pruebas critidad: Obligatorio
	@test
  Scenario: Test 01 - Validar la lista desplegable del combo
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
	@test
  Scenario: Test 02 - Validar comportamiento de la pantalla
            segun seleccion tipo de responsable = Empresa

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Empresa"
    Then Valiar Empresa
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Apagar el sistema
	@test
  Scenario Outline: Test 03 - Validar Buscador de Entidades segun criterio
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
      | Responsable | Descripcion        | CuitCuil    |
      | Empresa     | NALCO ARGENTINA SA | 30587375296 |
	@test
  Scenario Outline: Test 04 - Segun criterio de busqueda Descripcion
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
      | Responsable | Descripcion | CuitCuil    |
      | Empresa     | NALCO       | 30587375296 |

  Scenario Outline: Test 05 - Validar Funcionamiento de la Pantalla de
                    Resultados del Buscador de Entidades Bot�n Seleccionar 1 registro 

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Empresa"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de cuit <CuitCuil>
    And Ingreso de descripcion <Descripcion>
    When Selecciono boton busqueda de entidad en PopUp
    When Seleccionar valor con checkbox
    When Seleccionar boton confirmar entidad
    And Se cierra el popUp de busqueda de entidad
    And Los valores seleccionados se cargan en Alta de responsable
    Then validando los valores de los campos razon social y cuit
    And Apagar el sistema

    Examples: 
      | tipoResponsable | Descripcion                  | CuitCuil    |
      | Empresa         | BALDINI MARTINEZ Y ASOCIADOS | 30709492817 |
      
    Scenario: Test 06 - N registros
    
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Empresa"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    When Selecciono boton busqueda de entidad en PopUp
    When seleccionar boton ultima pagina
    When seleccionar el ultimo resultado
    And Se cierra el popUp de busqueda de entidad
    And Los valores seleccionados se cargan en Alta de responsable
    Then validando los valores de los campos razon social y cuit test seis
    And Apagar el sistema
    
    
