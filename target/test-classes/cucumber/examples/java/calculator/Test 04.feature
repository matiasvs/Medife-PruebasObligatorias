Feature: Med 146 - Obligatorios 04 - Segun criterio de búsqueda Descripción
  Sin Resultados Validar que el buscador sea especifico de empresas

  Scenario Outline: Comportamiento
    Given Obligatorio 4 Ingreso al sistema medife
    And Obligatorio 4 Usuario: <usuario>
    And Obligatorio 4 Pass: <password>
    And Obligatorio 4 selecciono Tipo de responsable <tipoResponsable>
    And Obligatorio 4 Ventana Buscador de Entidades desplegada:
    And Obligatorio 4 Ingresar una Descripcion: <descripcion> y un <CuitCuil> correspondiente a un grupo familiar existente
    When Obligatorio 4 Seleccionar el Boton Buscar
    Then Obligatorio 4 La Grilla se muestra vacia. No existen datos que coincidan con los criterios de busqueda ingresados.

    Examples: 
      | tipoResponsable | usuario | password | CuitCuil    | descripcion |
      | Empresa         | mveron  | Mv190319 | 27331154178 | CARDOZO     |
