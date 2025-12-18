import BasePage from '../pages/BasePage';
const allPaths = require('../paths');

describe('Navigation links', () => {
  const basePage = new BasePage();

  allPaths.forEach((link) => {
    it(`Visit ${link.path} and check elements`, () => {
      basePage.visit(link.path);
      basePage.checkBaseLayout();
      basePage.checkForbiddenWord(link.forbiddenWord);
    });
  });
});
