
describe('Registration of new employee', () => {
// Test  check if it's possible to add new employee to existing table.

    it('Check presence of table', () => {
      cy.visit('https://demoqa.com/webtables')
    })

    it('Check presence of table', () => {
      cy.get('.ReactTable.-striped.-highlight').should('have.length', 1)
      cy.get('.rt-td').contains('Cierra')

    })

    it('Click on registration button', () => {

    cy.get('.btn.btn-primary').should('have.length', 1).click()
    cy.contains('Registration Form').should('be.visible')
    cy.wait(2000)
  
    })

    it('Fill in registration form', () => {
    cy.get('#firstName').type('Name')
    cy.get('#lastName').type('Last name')
    cy.get('#userEmail').type('email@jkl.com')
    cy.get('#age').type('34')
    cy.get('#salary').type('13456')
    cy.get('#department').type('insurances')
    cy.get('#submit').click()
    cy.wait(3000)
    })

    it('Check if new employee is registrated', () => {
      cy.get(':nth-child(4) > .rt-tr > :nth-child(1)').contains('Name')
      cy.clearCookies()
      cy.end()
    })
})


