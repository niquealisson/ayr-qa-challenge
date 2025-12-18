package br.com.ayr.qa.tests;

import br.com.ayr.qa.base.BaseDriver;
import br.com.ayr.qa.pages.LoginPage;
import br.com.ayr.qa.pages.OnboardingPage;
import br.com.ayr.qa.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseDriver {

    @Test
    public void devePassarOnboardingELoginComSucesso() {
        // Concluir onboarding
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.concluirOnboarding();

        // Realizar login
        LoginPage login = new LoginPage(driver);
        login.realizarLogin(
                TestData.get("NUMERO_CORRETO"),
                TestData.get("SENHA_CORRETA")
        );

        // Validar se entrou na tela principal
        boolean loginOk = login.isLoginEfetuadoComSucesso();
        Assert.assertTrue(loginOk, "O login não foi efetuado corretamente!");

        // Opcional: print da activity atual
        System.out.println("Activity atual: " + driver.currentActivity());
    }
}
