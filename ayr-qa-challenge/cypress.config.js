const { defineConfig } = require("cypress");
const addAccessibilityTasks = require('wick-a11y/accessibility-tasks');

module.exports = defineConfig({
  e2e: {
    defaultCommandTimeout: 30000, // 30s
    baseUrl: process.env.BASE_URL || 'https://www.ceiia.com',
    setupNodeEvents(on, config) {
      addAccessibilityTasks(on);
      config.accessibilityFolder = 'cypress/accessibility-reports-folder';
      return config;
    },
    specPattern: "cypress/e2e/**/*.cy.js",
    video: true,
    screenshotOnRunFailure: true,
  },
});
