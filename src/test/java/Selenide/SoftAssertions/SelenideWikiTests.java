package Selenide.SoftAssertions;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import com.codeborne.selenide.Configuration;


import static com.codeborne.selenide.Selenide.*;


public class SelenideWikiTests {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.browserSize = "1920x1080";
        Configuration.pageLoadStrategy = "eager";

    }
    @Test
    void successTest() {

        open("/automation-practice-form");



    }
}