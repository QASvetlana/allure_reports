package ru.andreeva;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.util.EventListener;
import java.util.EventListenerProxy;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SelenideListenerTest {
    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testGithub() {
        SelenideLogger.addListener("allure", new AllureSelenide());
        open("https://github.com/");
        $(".header-search-input").click();
        $(".header-search-input").setValue("eroshenkoam/allure-example").submit();
        $(By.linkText("eroshenkoam/allure-example")).click();
        $(By.id("issues-tab")).click();
        $(byText("68")).should(Condition.visible);

    }


}