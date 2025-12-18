class BasePage {
  visit(path) {
    cy.visit(path, { timeout: 20000 });
    cy.window().its('document.readyState').should('eq', 'complete');
  }

  checkBaseLayout() {
    cy.get('body', { timeout: 20000 }).should('exist');
    cy.get('.header, .w-container', { timeout: 20000 }).should('be.visible');
  }

  checkForbiddenWord(word) {
    if (word) {
      cy.get('body').should('not.contain.text', word);
    }
  }
}

export default BasePage;
