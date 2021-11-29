describe('E2E test check if it is possible to delete new added item in ToDo app.', () => {
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
  it('Delete created item', () => {
    cy.get('input').click().type('banana')
    .wait(2000)
    cy.get('form > button').click()
    .wait(2000)
    cy.get(':nth-child(1) > button').click() 
    .wait(2000)
  })
    it('Check if item is deleted', () => {
      cy.get('ul > :nth-child(1)').should('not.exist')
      
   })
  })
