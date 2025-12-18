package br.com.ayr.qa.pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

public class CadastroPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public CadastroPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Botão Sign Up
    private By botaoSignUp = By.xpath("//android.widget.TextView[@resource-id='com.ceiia.ayr:id/sign_up_tv']");

    // Campos de cadastro
    private By campoFirstName = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_first_name_til']/android.widget.FrameLayout/android.widget.EditText");
    private By campoLastName = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_last_name_til']/android.widget.FrameLayout/android.widget.EditText");
    private By campoEmail = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_email_til']/android.widget.FrameLayout/android.widget.EditText");

    // Seleção de país
    private By selecionarPais = By.xpath("//android.widget.TextView[@resource-id='com.ceiia.ayr:id/selected_country_tv']");
    private By buscarPais = By.xpath("//android.widget.EditText[@resource-id='com.ceiia.ayr:id/search_edt']");
    private By itemBrasil = By.xpath("//android.widget.RelativeLayout[@resource-id='com.ceiia.ayr:id/item_country_rly']");

    // Telefone e senha
    private By campoTelefone = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_phone_til']/android.widget.FrameLayout/android.widget.EditText");
    private By campoSenha = By.xpath("//android.widget.LinearLayout[@resource-id='com.ceiia.ayr:id/login_password_til']/android.widget.FrameLayout/android.widget.EditText");

    // Botão Next
    public By botaoNext = By.xpath("//android.widget.Button[@resource-id='com.ceiia.ayr:id/next_btn']");

    // Checkbox
    private By checkboxIcon = By.xpath("//android.widget.ScrollView/android.view.ViewGroup/android.widget.LinearLayout[1]/android.widget.ImageView");

    // Mensagem de erro da senha
    private By mensagemErroSenha = By.xpath("//android.widget.TextView[@resource-id='com.ceiia.ayr:id/tvDialogMessage']");

    // Elementos da tela de verificação
    private By labelVerification = By.xpath("//android.widget.TextView[@resource-id='com.ceiia.ayr:id/verification_label_tv']");
    private By labelCode = By.xpath("//android.widget.TextView[@text='Code']");

    // Abrir tela de cadastro
    public void abrirTelaCadastro() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoSignUp)).click();
    }

    // Selecionar país Brasil
    private void selecionarPaisBrasil() {
        wait.until(ExpectedConditions.elementToBeClickable(selecionarPais)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(buscarPais)).sendKeys("Brazil");
        wait.until(ExpectedConditions.elementToBeClickable(itemBrasil)).click();
        // clicar novamente no campo do país se necessário
        wait.until(ExpectedConditions.elementToBeClickable(selecionarPais)).click();
    }

    // Rolar a tela até o botão Next
    private void rolarTelaPraBaixoAteBotao() {
        driver.findElement(AppiumBy.androidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))" +
                        ".scrollIntoView(new UiSelector().resourceId(\"com.ceiia.ayr:id/next_btn\"));"
        ));
        try { Thread.sleep(500); } catch (InterruptedException e) { e.printStackTrace(); }
    }

    // Clicar no botão Next
    public void clicarNext() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoNext));
        driver.findElement(botaoNext).click();
    }

    // Realizar cadastro completo
    public void realizarCadastro(String firstName, String lastName, String email, String telefone, String senha) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoFirstName)).sendKeys(firstName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoLastName)).sendKeys(lastName);
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoEmail)).sendKeys(email);

        wait.until(ExpectedConditions.elementToBeClickable(selecionarPais)).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(buscarPais)).sendKeys("Brazil");
        wait.until(ExpectedConditions.elementToBeClickable(itemBrasil)).click();

        wait.until(ExpectedConditions.visibilityOfElementLocated(campoTelefone)).sendKeys(telefone);
        wait.until(ExpectedConditions.visibilityOfElementLocated(campoSenha)).sendKeys(senha);

        rolarTelaPraBaixoAteBotao(); // Scroll para exibir o botão Next
        clicarNext();                  // Clicar no Next
    }

    // Verificar se o botão Next está visível
    public boolean isBotaoNextVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(botaoNext)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Clicar no checkbox
    public void clicarCheckbox() {
        wait.until(ExpectedConditions.elementToBeClickable(checkboxIcon)).click();
    }

    // Validar tela de verificação
    public void validarTelaVerificacao() {
        WebDriverWait waitTela = new WebDriverWait(driver, Duration.ofSeconds(10));

        boolean verificationVisivel = waitTela.until(
                ExpectedConditions.visibilityOfElementLocated(labelVerification)
        ).isDisplayed();
        if(!verificationVisivel) throw new RuntimeException("Label de verificação não está visível!");

        boolean codeVisivel = waitTela.until(
                ExpectedConditions.visibilityOfElementLocated(labelCode)
        ).isDisplayed();
        if(!codeVisivel) throw new RuntimeException("Campo 'Code' não está visível!");
    }


    // Obter mensagem de erro da senha
    public String obterMensagemErroSenha() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(mensagemErroSenha)).getText();
    }
}
