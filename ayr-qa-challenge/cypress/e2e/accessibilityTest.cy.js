const AccessibilityPage = require('../pages/AccessibilityPage');
const paths = require('../paths');

describe('Accessibility Suite', () => {
  const page = new AccessibilityPage();

  paths.forEach((link) => {
    it(`Accessibility test - ${link.path}`, () => {
      page.visit(link.path);
      page.checkAccessibility();

      if (link.forbiddenWord) {
        page.shouldNotContain(link.forbiddenWord);
      }
    });
  });
});
