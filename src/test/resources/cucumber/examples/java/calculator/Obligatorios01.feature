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

  Scenario: Test 07 - Validar comportamiento de la pantalla segun
    	seleccion tipo de responsable = Grupo Familiar

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Grupo"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Apagar el sistema

  Scenario: Test 08 - Validar Boton Buscador de Entidades
    		Asociados segun selecci�n tipo de responsable = Grupo Familiar

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Grupo"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    Then Obligatorio H La aplicacion despliega la ventana Buscador de Entidades. Mostrando los siguientes campos:
    Then Obligatorio H Solo lectura Tipo de Entidad Grupo Familiar habilitados para el ingreso de datos: descripcion cuit cuil
    And Apagar el sistema

  Scenario Outline: Test 09 - Validar Buscador de Entidades Asociados segun criterio de búsqueda Descripción Con Resultado
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa "Grupo"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de cuit <CuitCuil>
    And Ingreso de descripcion <Descripcion>
    When Selecciono boton busqueda de entidad en PopUp
    Then La pantalla lista los datos que coinciden con la informacion ingresada. Dispuestos de la siguiente manera: Descripcion - Cuit - Cuil
    And Apagar el sistema

    Examples: 
      | tipoResponsable | Descripcion | CuitCuil    |
      | Grupo           | ALACID      | 20291531777 |

  Scenario Outline: Test 10 - Segun criterio de búsqueda Descripción
    	Sin Resultados Validar que el buscador sea especifico de Asociados Grupo Familiar

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de descripcion <Descripcion>
    When Selecciono boton busqueda de entidad en PopUp
    Then La Grilla se muestra vacia. No existen datos que coincidan con los criterios de busqueda ingresados.
    And Apagar el sistema

    Examples: 
      | Responsable | Descripcion                             |
      | Grupo       | TIERRA COOP DE TRAB. VIV. Y CONS. LTDA. |

  Scenario Outline: Test 11 - Validar Funcionamiento de la Pantalla de
    						Resultados del Buscador de Entidades. Bot�n Seleccionar 1 registro

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de cuit <CuitCuil>
    And Ingreso de descripcion <Descripcion>
    And Ingreso fecha de vigencia alta de responsable<FechaDeVigencia>
    When Selecciono boton busqueda de entidad en PopUp
    Then La aplicacion cierra la ventana Buscador de Entidades y los datos seleccionados se visualizan ingresados en la pantalla Alta de Responsable de Pago no permitiendo su edicion
    And Apagar el sistema

    #canbio no se puede ver fecha en busqueda
    Examples: 
      | Responsable | Descripcion | CuitCuil    | FechaDeVigencia |
      | Grupo       | RETEGUI     | 20208377923 | 15/06/2019      |

  Scenario Outline: Test 12 - Validar comportamiento de la pantalla segun selección
    							tipo de responsable = Externo

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de descripcion <Descripcion>
    #cambiaVerPorque
    And A Seleccion Empresa "Externo"
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    Then La aplicacion habilita los campos para ingresar los datos manualmente
    Then Excepto Fecha de bja y estado que no son editables
    Then Inhabilita el boton buscador de entidades
    And Apagar el sistema

    Examples: 
      | Responsable | Descripcion | CuitCuil    | FechaDeVigencia |
      | Externo     | GOMEZ       | 20318861200 | 15/06/2019      |

  Scenario Outline: Test 13 - Validar Botón Guardar en el Ingreso Manual de datos
    							según selección tipo de responsable = Externo

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de cuit Alta de responsable <CuitCuil>
    Then Selecciono el boton guardar en Alta de responsable
    Then Guarda los datos ingresados e inicia el proceso, habilitando la seccion Datos Fiscales.
    And Apagar el sistema

    Examples: 
      | Responsable | CuitCuil    |
      | Externo     | 20336898243 |

  Scenario Outline: Test 14 - Validar datos requeridos. Ingreso Manual de datos
    							segun seleccion tipo de responsable = Externo

    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de descripcion <Descripcion>
    When Selecciono el boton Guardar de Alta de responsable
    Then La aplicacion emite un mensaje: El campo CUIT/CUIL es requerdido. Y no guarda los datos
    And Apagar el sistema

    Examples: 
      | Responsable | Responsable  |
      | Externo     | Samsung S.A. |
      
    Scenario Outline: Test 15 - Validar CUIT/CUIL Ingreso Manual Datos Invalidos
      
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
    And Ingreso de cuit Alta de responsable <CuitCuil>
    When Selecciono boton busqueda de entidad en PopUp
    When Selecciono el boton guardar de Alta de responsable
    Then La aplicacion emite un mensaje: Formato CUIT/CUIL invalido. Y no guarda los datos
    And Apagar el sistema
    
    Examples: 
      | tipoResponsable | descipcion                              | cuitCuil     |
      | Externo         | TIERRA COOP DE TRAB. VIV. Y CONS. LTDA. | 20/3368982+3 |
      
    Scenario Outline: Test 16 - A Validar CUIT/CUIL Ingreso Manual Datos existentes 
      
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>  
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades  
    And Ingreso de cuit Alta de responsable <CuitCuil>
    When Selecciono el boton guardar o confimar de Alta de responsable
    Then La aplicacion emite un mensaje: CUIT - CUIL invalido. Ya existe un asociado activo que posee el cuit - cuil Y no guarda los datos
    
    Examples: 
      | Responsable | CuitCuil     |
      | Externo         | 20/336898243 |
      
    Scenario Outline: Test 17 - Validar Bot�n Confirmar. Y pantalla datos fiscales  
      
    Given Ingreso al sitio Sume
    And Ingreso de usuario
    And Ingreso de password
    And Pantalla Alta de responsable de pago desplegada
    And A Seleccion Empresa <Responsable>  
    Then Se habilita el boton del Buscador que permitira la seleccion de entidades
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
