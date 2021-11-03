
describe('Link is not working', () => {
// Test check if it's possible to fill in form with wrong email adress.

beforeEach()
    it('Visit page with form', () => {
      cy.visit('https://demoqa.com/automation-practice-form')
  
    })

    it('Filling form', () => {
      cy.get('.practice-form-wrapper').should('have.length',1)
      cy.get('#firstName').type('Petr')
      cy.get('#lastName').type('Ocko')
      cy.get('#userEmail').type('wrongemail.com')
      cy.get('#genterWrapper > .col-md-9 > :nth-child(2)').click()
      cy.get('#userNumber').type('123456789')
      //date picker
      cy.get('#dateOfBirthInput').click().type('{selectall}','{backspace}').type('20.02.1998').type('{enter}')
      cy.get('#userForm').click()
      cy.get('.subjects-auto-complete__value-container').click().type('math,biology,psychology').type('{enter}')
      cy.get('#hobbiesWrapper > .col-md-9 > :nth-child(1)').click()
      // upload file
      const filepath = 'test.png'
      cy.get('#uploadPicture').click().attachFile(filepath).wait(2000)
      //
      cy.get('#currentAddress').type('work is fun, 456, Brno')
      cy.get('.css-yk16xz-control > .css-1wy0on6 > .css-tlfecz-indicatorContainer > .css-19bqh2r').click().wait(1000)
      cy.get('#react-select-3-option-0').click()
      cy.get('#city > .css-yk16xz-control > .css-1hwfws3').click().wait(1000)
      cy.get('#react-select-4-option-0').click()
      
      // submit
      cy.get('#submit').click()

      
      //check if the email is filled right
      it('Check if the the error message is shown', () => {
      cy.get('.was-validated').should('have.css','border-color', 'rgb(33, 37, 41)')
      cy.end()
      })
      
    })
  })
  



