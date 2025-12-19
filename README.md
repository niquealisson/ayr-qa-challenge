# QA Technical Challenge – AYR (Are You Ready)

Este repositório contém a entrega do desafio técnico para a posição de Quality Assurance, incluindo testes exploratórios manuais e testes automatizados, bem como considerações técnicas sobre os cenários executados.

---

## Aplicação Testada

- Nome: AYR – Are You Ready  
- Plataforma: Mobile (Android)  
- Tipo de Teste: Testes Exploratórios Manuais e Testes Automatizados  
- Tempo de Exploração Manual: Aproximadamente 30 minutos  

---

## Escopo do Desafio

O objetivo do desafio foi:

- Realizar testes exploratórios manuais
- Identificar problemas de usabilidade, validação e fluxo
- Desenvolver testes automatizados mobile e web
- Documentar limitações técnicas e decisões tomadas durante a execução

---

## Testes Exploratórios Manuais

Foram realizados testes exploratórios manuais com foco nos seguintes fluxos:

- Onboarding da aplicação
- Criação de conta
- Validação de campos obrigatórios
- Feedback ao utilizador em cenários de erro
- Comportamentos inesperados em fluxos críticos

O relatório detalhado dos testes exploratórios manuais encontra-se documentado em arquivo Word incluído neste repositório.

---

## Testes Automatizados Mobile

Foram desenvolvidos testes automatizados mobile utilizando Appium, cobrindo os seguintes cenários:

- Criação de conta na aplicação
- Login com conta existente
- Registo de atividade dentro da aplicação
- Tentativa de criação de conta com senha fraca
- Tentativa de login com conta inexistente

Os testes contemplam cenários positivos e negativos, com foco em validações de entrada, fluxo de autenticação e funcionalidades principais da aplicação.

Durante a execução dos testes, foi identificada uma limitação no processo de criação de conta relacionada ao envio do código de verificação por SMS, que apresentou comportamento inconsistente em alguns cenários. Essa limitação foi devidamente documentada no relatório, juntamente com observações e sugestões de melhoria.

---

## Testes Automatizados Web (Cypress)

Este repositório também contém testes automatizados web desenvolvidos com Cypress.

Devido ao facto de o site testado ser essencialmente informativo, sem formulários ou fluxos de autenticação, os testes automatizados focaram em:

- Navegação entre links
- Validação de redirecionamentos
- Testes básicos de acessibilidade
- Garantia de disponibilidade das páginas principais

---

## Considerações Finais

O desafio permitiu analisar a aplicação AYR sob a perspectiva de qualidade, identificando pontos relevantes de melhoria em usabilidade, validação e fluxos críticos.

Os testes automatizados foram desenvolvidos de forma objetiva, respeitando as limitações funcionais encontradas na aplicação e priorizando cenários relevantes para a experiência do utilizador.

Obrigado pela oportunidade.


##                                    ## EN ###                                          ##


# QA Technical Challenge – AYR (Are You Ready)

This repository contains the delivery of the technical challenge for the Quality Assurance position, including manual exploratory testing and automated tests, as well as technical considerations regarding the executed scenarios.

---

## Application Under Test

- Name: AYR – Are You Ready  
- Platform: Mobile (Android)  
- Test Type: Manual Exploratory Testing and Automated Testing  
- Manual Exploration Time: Approximately 30 minutes  

---

## Challenge Scope

The objective of this challenge was to:

- Perform manual exploratory testing
- Identify usability, validation, and flow issues
- Develop mobile and web automated tests
- Document technical limitations and decisions made during execution

---

## Manual Exploratory Testing

Manual exploratory testing was performed focusing on the following flows:

- Application onboarding
- Account creation
- Mandatory field validation
- User feedback in error scenarios
- Unexpected behavior in critical flows

The detailed manual exploratory testing report is documented in a Word file included in this repository.

---

## Mobile Automated Testing

Mobile automated tests were developed using Appium, covering the following scenarios:

- Account creation within the application
- Login with an existing account
- Activity registration within the application
- Attempt to create an account using a weak password
- Attempt to log in with a non-existent account

The tests include both positive and negative scenarios, focusing on input validation, authentication flow, and core application functionalities.

During test execution, a limitation was identified in the account creation process related to SMS verification code delivery, which showed inconsistent behavior in some scenarios. This limitation was properly documented in the report, along with observations and improvement suggestions.

---

## Web Automated Testing (Cypress)

This repository also contains web automated tests developed using Cypress.

Since the tested website is primarily informational, without forms or authentication flows, the automated tests focused on:

- Link navigation
- Redirect validation
- Basic accessibility testing
- Availability of main pages

---

## Final Considerations

The challenge allowed the application AYR to be evaluated from a quality perspective, identifying relevant improvement opportunities related to usability, validation, and critical user flows.

The automated tests were developed in an objective manner, respecting the functional limitations identified in the application and prioritizing scenarios that are relevant to the user experience.

Thank you for the opportunity.
