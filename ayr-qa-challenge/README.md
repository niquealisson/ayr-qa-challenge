## Installation

1. Clone the repository:
```bash
git clone https://github.com/niquealisson/Desafio_Pratico_Quality_Assurance
cd Desafio_Pratico_Quality_Assurance
````

2. Install dependencies:

```bash
npm install
```

3. Install Cypress and A11y tools:

```bash
npm install cypress --save-dev
npm install cypress-axe --save-dev
npm install wick-a11y --save-dev
```

---

## Running Tests

* Open Cypress Test Runner (interactive mode):

```bash
npm run cypress:open
```

* Run all tests headless:

```bash
npm run cypress:run
```

> The `baseUrl` is configured in `cypress.config.js`, so all tests use only the paths from `paths.js`.

---

## GitHub Actions (CI)

* CI workflow is configured to run on every push to `main`.
* Automatically:

  * Checks out the repository.
  * Installs Node.js 20.
  * Installs dependencies.
  * Runs Cypress tests.
  * Uploads videos/screenshots as artifacts.

---