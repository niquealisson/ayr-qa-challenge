package br.com.ayr.qa.tests;

import br.com.ayr.qa.base.BaseDriver;
import br.com.ayr.qa.pages.CadastroPage;
import br.com.ayr.qa.pages.OnboardingPage;
import br.com.ayr.qa.utils.TestData; // import do cofre de dados
import org.testng.Assert;
import org.testng.annotations.Test;

public class CadastroSucessTest extends BaseDriver {

    @Test
    public void deveCadastrarComSucesso() {

        // Passar pelo onboarding
        OnboardingPage onboarding = new OnboardingPage(driver);
        onboarding.concluirOnboarding();

        // Abrir tela de cadastro
        CadastroPage cadastro = new CadastroPage(driver);
        cadastro.abrirTelaCadastro();

        // Preencher cadastro com dados do cofre
        cadastro.realizarCadastro(
                TestData.get("NOME"),
                TestData.get("SOBRENOME"),
                TestData.get("EMAIL_CORRETO"),
                TestData.get("NUMERO_CORRETO"),
                TestData.get("SENHA_CORRETA")
        );

        // Selecionar o checkbox de aceite (se existir)
        cadastro.clicarCheckbox();
        cadastro.clicarNext();
        cadastro.validarTelaVerificacao();

        // Mensagem de sucesso
        System.out.println("Cadastro realizado com sucesso!");
    }
}
