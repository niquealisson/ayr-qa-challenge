const allPaths = require('../paths');

describe('Smoke Test API', () => {
  allPaths.forEach((link) => {
    it(`Check API for ${link.path}`, () => {
      cy.request({
        url: link.path,
        failOnStatusCode: false
      }).then((res) => {
        expect(res.status).to.eq(200);
        expect(res.body).to.exist;
        expect(res.duration).to.be.lessThan(2000);
      });
    });
  });
});
