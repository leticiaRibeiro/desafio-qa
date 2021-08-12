
describe('Funcionalidade de busca - Hypeflame', () => {

    beforeEach(() => {
        cy.visit('/')
    })

    it('Campo de busca vazio', () => {
        cy.get('#header-search').click()
        cy.get('input[type=search]').type('{enter}')

    });

    it('Pesquisa por um título inexistente', () => {
        cy.get('#header-search').click()
        cy.get('input[type=search]').type('Primeiros passos com Cypress{enter}')
        cy.get('h1').should('have.text', 'Nenhum resultado')
    });

    it('Pesquisa por parte do título', () => {
        cy.get('#header-search').click()
        cy.get('input[type=search]').type('vamos falar de{enter}')
        cy.get('article > header > h2 > a')
            .should('have.length', 3)
            .each(($el, index, $lista) => {
                cy.get($el).should('contain.text', 'Vamos falar de')
            })
    });

    it('Pesquisa por dígitos numéricos', () => {
        cy.get('#header-search').click()
        cy.get('input[type=search]').type('55{enter}')
        cy.get('article[id]').should('have.length', 1)
    });

    it('Pesquisa por caracteres especiais', () => {
        cy.get('#header-search').click()
        cy.get('input[type=search]').type('%{enter}')
        cy.get('h1').should('have.text', 'Nenhum resultado')
    });

    it('Pesquisa por palavras e caracteres especiais', () => {
        cy.get('#header-search').click()
        cy.get('input[type=search]').type('né?{enter}')
        cy.get('article[id]').should('have.length', 2)
    });


});