package JUnit5exampleExists;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;


import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Condition.text;


public class WikiSelenideTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://github.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";
    }

    @Test
    void successTest() {
// Откройте страницу Selenide в Github
        open("/selenide/selenide");
// Перейдите в раздел Wiki проекта
        $("#wiki-tab").click();
// Убедитесь, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-content").shouldHave(text("Soft assertions"));
// Откройте страницу SoftAssertions
        $$(".markdown-body li").findBy(text("Soft assertions")).$("a").click();
// проверьте что внутри есть пример кода для JUnit5
        $("#user-content-3-using-junit5-extend-test-class").closest("div").shouldHave(text("""
                @ExtendWith({SoftAssertsExtension.class})
                class Tests {
                  @Test
                  void test() {
                    Configuration.assertionMode = SOFT;
                    open("page.html");
                                
                    $("#first").should(visible).click();
                    $("#second").should(visible).click();
                  }
                }
                """));

    }
}