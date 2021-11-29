describe('E2E test check if it is possible to create multiple new items in ToDo app.', () => {
    beforeEach(() => {
     cy.visit('http://localhost:8080/')
    })

     it('Check if there are already items in ToDo app, if so delete item.',() => {

    cy.get('h4').should('not.exist').then(() => {
        cy.wrap('li > button')
          .get('li > button')
          .click({ force: true, multiple: true })
})
    })
    it('Create multiple new items',() => {
        cy.get('input').click() 
            .type('rose')
            .wait(2000)
        cy.get('form > button')
            .click()
            .wait(2000)
            cy.get('input').click() 
            .type('dog')
            .wait(2000)
        cy.get('form > button')
            .click()
            .wait(2000)
            
        })

        it('Check if word is added to ToDo list', () => {
          cy.get('ul > :nth-child(1)')
          cy.get('ul > :nth-child(2)')
      })
    })
