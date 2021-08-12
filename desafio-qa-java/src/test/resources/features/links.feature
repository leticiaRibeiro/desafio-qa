Feature: Cenários de teste do blog da Hypeflame

Scenario: Campo de busca vazio
    Given Acessar homepage do blog
    When Fazer uma busca vazia de um post
    Then Todos os posts da página inicial devem aparecer

Scenario: Pesquisa por um título inexistente
    Given Acessar homepage do blog
    When Fazer uma pesquisa por um título que não existe
    Then A mensagem de erro "Nenhum resultado" deve aparecer

Scenario: Pesquisa por parte do título
    Given Acessar homepage do blog
    When Fazer uma busca por uma parte de um título
    Then Os posts que contém as partes de um título digitadas devem aparecer

Scenario Outline: Pesquisa por dígitos numéricos
    Given Acessar homepage do blog
    When Fazer uma busca pelo dígito "<digito>"
    Then Os posts que contém esse dígito deve ser listado

    Examples:
        |digito     |
        |55         |
        |50         |

Scenario: Pesquisa por caracteres especiais
    Given Acessar homepage do blog
    When Fazer uma busca somente por caracteres especiais
    Then A mensagem de erro "Nenhum resultado" deve aparecer

Scenario: Pesquisa por palavras e caracteres especiais
    Given Acessar homepage do blog
    When Fazer uma busca por palavra e caractere especial
    Then Os posts que contém a palavra com o caractere especial devem ser listados

Scenario: Pesquisa por tag/categoria
    Given Acessar homepage do blog
    When Fazer uma busca pela categoria ou tag
    Then Os posts relacionados com a categoria pesquisada devem aparecer