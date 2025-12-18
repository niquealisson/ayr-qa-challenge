package br.com.ayr.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class LoginPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public LoginPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Seleção de país
    private By selecionarPais = By.xpath("//android.widget.TextView[@resource-id='com.ceiia.ayr:id/selected_country_tv']");
    private By buscarPais = By.xpath("//android.widget.EditText[@resource-id='com.ceiia.ayr:id/search_edt']");
    private By itemBrasil = By.xpath("//android.widget.RelativeLayout[@resource-id='com.ceiia.ayr:id/item_country_rly']");

    // Campos de login
    private By campoTelefone = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_phone_til']/android.widget.FrameLayout/android.widget.EditText");
    private By campoSenha = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_password_til']/android.widget.FrameLayout/android.widget.EditText");

    // Botão de login
    private By botaoEntrar = By.xpath("//android.widget.Button[@resource-id='com.ceiia.ayr:id/login_btn']");

    // Mensagem de erro
    private By mensagemErro = By.xpath("//android.widget.TextView[@resource-id='com.ceiia.ayr:id/tvDialogMessage']");

    // Botão pós-login (confirmação)
    private By botaoConfirmar = By.xpath("//android.widget.Button[@resource-id='android:id/button1']");

    // RecyclerView da tela principal
    private By telaPrincipal = By.xpath("//androidx.recyclerview.widget.RecyclerView[@resource-id='com.ceiia.ayr:id/actions_rv']");

    // Realizar login
    public void realizarLogin(String telefone, String senha) {
        // Selecionar país
        wait.until(ExpectedConditions.elementToBeClickable(selecionarPais)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(buscarPais)).sendKeys("Brazil");
        wait.until(ExpectedConditions.elementToBeClickable(itemBrasil)).click();

        // Preencher telefone
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoTelefone)).sendKeys(telefone);

        // Preencher senha
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha)).sendKeys(senha);

        // Clicar em entrar
        wait.until(ExpectedConditions.elementToBeClickable(botaoEntrar)).click();

        // Clicar no botão de confirmação se aparecer
        try {
            wait.until(ExpectedConditions.elementToBeClickable(botaoConfirmar)).click();
        } catch (Exception e) {
            // Se o botão não aparecer, continua sem quebrar
        }
    }

    // Verifica se o login foi efetuado corretamente
    public boolean isLoginEfetuadoComSucesso() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(telaPrincipal)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Obter mensagem de erro
    public String obterMensagemErro() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErro)).getText();
    }
}
