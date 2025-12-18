package br.com.ayr.qa.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class BaseDriver {

    protected AndroidDriver driver;

    @BeforeMethod
    public void setUp() throws Exception {
        if (driver == null) {
            UiAutomator2Options options = new UiAutomator2Options()
                    .setPlatformName("Android")
                    .setAutomationName("UiAutomator2")
                    .setDeviceName("emulator-5554")
                    .setAppPackage("com.ceiia.ayr")
                    .setAppActivity(".activities.splash.SplashActivity")
                    .setAppWaitActivity("*")
                    .setNoReset(false)
                    .autoGrantPermissions();

            driver = new AndroidDriver(
                    new URL("http://127.0.0.1:4723"),
                    options
            );
        } else {
            Map<String, Object> params = new HashMap<>();
            params.put("appId", "com.ceiia.ayr");
            driver.executeScript("mobile: launchApp", params);
        }
    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            Map<String, Object> params = new HashMap<>();
            params.put("appId", "com.ceiia.ayr");
            driver.executeScript("mobile: terminateApp", params);

            driver.quit();
            driver = null;
        }
    }
}
