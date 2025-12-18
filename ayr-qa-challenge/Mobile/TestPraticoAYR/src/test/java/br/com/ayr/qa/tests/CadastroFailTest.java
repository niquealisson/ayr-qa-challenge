package br.com.ayr.qa.tests;

import br.com.ayr.qa.base.BaseDriver;
import br.com.ayr.qa.pages.CadastroPage;
import br.com.ayr.qa.pages.OnboardingPage;
import br.com.ayr.qa.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CadastroFailTest extends BaseDriver {

    @Test
    public void deveTentarCadastroComFalha() {

        // Passar pelo onboarding
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.concluirOnboarding();

        // Abrir tela de cadastro
        CadastroPage cadastro = new CadastroPage(driver);
        cadastro.abrirTelaCadastro();

        // Tentar cadastro com dados que devem falhar (senha fraca / usuário existente)
        cadastro.realizarCadastro(
                TestData.get("NOME"),
                TestData.get("SOBRENOME"),
                TestData.get("EMAIL_INCORRETO"),
                TestData.get("NUMERO_INCORRETO2"),
                TestData.get("SENHA_INCORRETA")
        );

        // Clicar no checkbox
        cadastro.clicarCheckbox();
        cadastro.clicarNext();

        // Validar mensagem de erro da senha
        String mensagem = cadastro.obterMensagemErroSenha();
        System.out.println("Mensagem exibida: " + mensagem);
        Assert.assertEquals(mensagem,
                "The password must contain at least one digit [0-9], lowercase Latin character [a-z], " +
                        "one uppercase Latin character [A-Z], one special character like '! @ # & ( )', " +
                        "and a length of at least 8 characters and a maximum of 80 characters"
        );

    }
}
