package ru.andreeva;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;


public class LambdaStepTest {
    private final static String REPOSITORY = "eroshenkoam/allure-example";
    private final static Integer ISSUE_NUMBER = 68;

    @BeforeAll
    static void beforeAll() {
        Configuration.startMaximized = true;
    }

    @Test
    public void testGithub(){
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Ищем репозиторий " + REPOSITORY, () -> {
        $(".header-search-input").click();
        $(".header-search-input").sendKeys(REPOSITORY);
        $(".header-search-input").submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем раздел Issues", () -> {
            $(partialLinkText("Issues")).click();
        });
        step("Проверяем наличие Issues с номером " + ISSUE_NUMBER, () -> {
            $(byText("#" + ISSUE_NUMBER)).should(Condition.visible);
        });


    }

}
