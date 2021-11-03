context('API test', () => {
  beforeEach(() => {
    cy.visit('https://demoqa.com/automation-practice-form')
    cy.get('.practice-form-wrapper').should('have.length',1)
  })
    it('Request and response', () => {
      cy.request('https://demoqa.com/automation-practice-form')
        .should((response) => {
          expect(response.status).to.eql(200)
          expect(response).to.have.property('headers')
          expect(response).to.have.property('duration')
          // expect(response).to.have.property('url',)
          
        })
      })
    })

describe('Contains', () => {
  before(() => {
      it('Contains', () => {
      cy.request('https://demoqa.com/automation-practice-form')
      .its('body').should('contains',"viewport")

    })
  })
})


