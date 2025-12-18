package br.com.ayr.qa.tests;

import br.com.ayr.qa.base.BaseDriver;
import br.com.ayr.qa.pages.AtividadesPage;
import br.com.ayr.qa.pages.LoginPage;
import br.com.ayr.qa.pages.OnboardingPage;
import br.com.ayr.qa.utils.TestData;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CriarAtividadeTest extends BaseDriver {

    @Test
    public void deveRegistrarUmaAtividade() {

        // Passar pelo onboarding
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.concluirOnboarding();

        // Login com conta existente
        LoginPage login = new LoginPage(driver);
        login.realizarLogin(
                TestData.get("NUMERO_CORRETO"),
                TestData.get("SENHA_CORRETA")
        );

        // Registrar atividade
        AtividadesPage atividade = new AtividadesPage(driver);
        atividade.clicarPrimeiraAcao();

        // Validar tela "Activity"
        Assert.assertTrue(atividade.isTelaActivityVisivel(), "A tela 'Activity' deve estar visível.");

        // Iniciar a atividade
        atividade.clicarStart();

        // Esperar 5 segundos antes de clicar em Stop
        try {
            Thread.sleep(5000); // 5000 ms = 5 segundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Validar botão Stop e parar a atividade
        Assert.assertTrue(atividade.isBotaoStopVisivel(), "O botão Stop deve estar visível após clicar em Start.");
        atividade.clicarStop();


        // Finalizar atividade
        atividade.clicarEnd();

        // Aqui você pode adicionar validações adicionais, por exemplo,
        // se a atividade foi registrada na lista, dependendo da UI do app
    }
}
