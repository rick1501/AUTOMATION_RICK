package com.yourstore.automation.driver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class CustomChromeDriver {
    public static WebDriver create() {
        ChromeOptions options = new ChromeOptions();

        // 🚀 Ignorar errores de certificados SSL
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--ignore-ssl-errors=yes");
        options.setAcceptInsecureCerts(true);

        return new ChromeDriver(options);
    }
}
