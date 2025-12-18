package br.com.ayr.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class AtividadesPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public AtividadesPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Elementos
    private By primeiraAcao = By.xpath("(//android.widget.ImageView[@resource-id='com.ceiia.ayr:id/action_iv'])[1]");
    private By telaActivity = By.xpath("//android.widget.TextView[@text='Activity']");
    private By botaoStart = By.xpath("//android.widget.Button[@resource-id='com.ceiia.ayr:id/start_activity_btn']");
    private By botaoStop = By.xpath("//android.widget.Button[@resource-id='com.ceiia.ayr:id/stop_btn']");
    private By botaoEnd = By.xpath("//android.widget.Button[@resource-id='com.ceiia.ayr:id/btnEnd']");

    // Clicar na primeira ação
    public void clicarPrimeiraAcao() {
        wait.until(ExpectedConditions.elementToBeClickable(primeiraAcao)).click();
    }

    // Validar se estamos na tela "Activity"
    public boolean isTelaActivityVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(telaActivity)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Clicar em Start
    public void clicarStart() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoStart)).click();
    }

    // Validar se botão Stop apareceu
    public boolean isBotaoStopVisivel() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(botaoStop)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    // Clicar em Stop
    public void clicarStop() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoStop)).click();
    }

    // Clicar em End
    public void clicarEnd() {
        wait.until(ExpectedConditions.elementToBeClickable(botaoEnd)).click();
    }
}
