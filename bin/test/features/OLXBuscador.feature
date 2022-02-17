Feature: HU-001 Buscador OXL
  Yo como usuario de OXL
  Quiero buscar en el buscador un producto
  Para ver el producto en la pagina

  Scenario Outline: <Escenario>
    Given que me encuentro en la pagina de OLX con la url <Url>
    When busco el proudcto en el buscador
    Then podre ver el producto en pantalla

    Examples: 
      | Escenario                                    | Url                     |
      | Buscar palabra en el buscador de OLX exitoso | https://www.olx.com.co/ |
