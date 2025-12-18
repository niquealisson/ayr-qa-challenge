package br.com.ayr.qa.tests;

import br.com.ayr.qa.base.BaseDriver;
import br.com.ayr.qa.pages.LoginPage;
import br.com.ayr.qa.pages.OnboardingPage;
import br.com.ayr.qa.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginFailTest extends BaseDriver {

    @Test
    public void deveExibirMensagemDeErroParaContaInativa() {
        // Passar pelo onboarding
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.concluirOnboarding();

        // Tentar login com conta inativa ou senha incorreta
        LoginPage login = new LoginPage(driver);
        login.realizarLogin(
                TestData.get("NUMERO_INCORRETO"),
                TestData.get("SENHA_INCORRETA")
        );

        // Capturar mensagem de erro
        String mensagem = login.obterMensagemErro();
        System.out.println("Mensagem de erro exibida: " + mensagem);

        // Validar mensagem
        Assert.assertEquals(mensagem, "User and/or password are invalid");
    }
}
