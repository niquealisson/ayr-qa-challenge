const BasePage = require('./BasePage');

class LayoutPage extends BasePage {
  headerShouldBeVisible() {
    cy.get('.header, .w-container', { timeout: 20000 })
      .should('be.visible');
  }
}

module.exports = LayoutPage;
