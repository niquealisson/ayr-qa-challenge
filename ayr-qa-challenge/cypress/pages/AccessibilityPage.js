const BasePage = require('./BasePage');

class AccessibilityPage extends BasePage {
  checkAccessibility() {
    cy.checkAccessibility();
  }
}

module.exports = AccessibilityPage;
