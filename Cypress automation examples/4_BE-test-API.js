describe('BE test', () => {
  it('Request', () => {
    cy.request('https://localhost:5001/api/ToDoItems')
      .should((response) => {
        expect(response.status).to.eq(200)
        expect(response).to.have.property('headers')
        expect(response).to.have.property('duration')
  })
  cy.request('Post', 'https://localhost:5001/api/ToDoItems', {
    "id": "86",
    "text": "dog"
  }).then(
  (response) => {
    expect(response.body).to.have.property('text', 'dog')
  }
)
cy.request('Get', 'https://localhost:5001/api/ToDoItems/89', {
    "id": "86",
    "text": "dog"
  }).then(
  (response) => {
    expect(response.body).to.have.property('text', 'dog') 
  }
)
})
})
