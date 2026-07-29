package com.example.autotestsDemoProj;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Allure;
import io.qameta.allure.restassured.AllureRestAssured;
import io.qameta.allure.selenide.AllureSelenide;
import io.restassured.RestAssured;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.OutputType;

import java.io.ByteArrayInputStream;

import static io.restassured.RestAssured.given;

class UiTests {

    @BeforeAll
    static void setupAllureReports() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)    // Включить скриншоты при падении (по умолчанию true)
                .savePageSource(false) // Сохранять ли исходный код страницы (HTML)
        );
    }

    @Test
    public void contextLoads() {
        Selenide.open("https://www.google.com/");
        takeCustomScreenshot();
    }

    public void takeCustomScreenshot() {
        byte[] screenshot = Selenide.screenshot(OutputType.BYTES);
        if (screenshot != null) {
            Allure.addAttachment("Custom screenshot", new ByteArrayInputStream(screenshot));
        }
    }
}
