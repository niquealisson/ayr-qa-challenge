package br.com.ayr.qa.pages;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Collections;

public class OnboardingPage {

    private AndroidDriver driver;
    private WebDriverWait wait;

    public OnboardingPage(AndroidDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    // Botão SKIP
    private By botaoSkip = By.id("com.ceiia.ayr:id/button");

    // Container do onboarding (LinearLayout)
    private By containerOnboarding = By.className("android.widget.LinearLayout");

    public void concluirOnboarding() {

        // 1️⃣ Aguarda o onboarding carregar
        wait.until(ExpectedConditions.presenceOfElementLocated(containerOnboarding));

        // 2️⃣ Faz swipes até o botão SKIP aparecer (máx 6 tentativas)
        for (int i = 0; i < 6; i++) {

            if (isSkipVisivel()) {
                break;
            }

            swipeParaEsquerda();
            sleep(800); // pequeno tempo entre swipes (ESSENCIAL)
        }

        // 3️⃣ Clica no SKIP
        WebElement skip = wait.until(
                ExpectedConditions.elementToBeClickable(botaoSkip)
        );
        skip.click();
    }

    private boolean isSkipVisivel() {
        try {
            return driver.findElement(botaoSkip).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    private void swipeParaEsquerda() {

        int largura = driver.manage().window().getSize().width;
        int altura = driver.manage().window().getSize().height;

        int startX = (int) (largura * 0.8);
        int endX = (int) (largura * 0.2);
        int y = altura / 2;

        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence swipe = new Sequence(finger, 1);

        swipe.addAction(finger.createPointerMove(
                Duration.ZERO,
                PointerInput.Origin.viewport(),
                startX,
                y
        ));

        swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));

        swipe.addAction(finger.createPointerMove(
                Duration.ofMillis(700),
                PointerInput.Origin.viewport(),
                endX,
                y
        ));

        swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));

        driver.perform(Collections.singletonList(swipe));
    }

    private void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException ignored) {
        }
    }
}
