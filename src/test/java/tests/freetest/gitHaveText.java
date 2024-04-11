package tests.freetest;

import org.junit.jupiter.api.*; import org.junit.jupiter.params.ParameterizedTest; import org.junit.jupiter.params.provider.CsvSource; import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text; import static com.codeborne.selenide.Selenide.*;

@DisplayName("тест") public class gitHaveText {

    @Disabled
    @Test
    void testHaTest() {

        open("https://github.com");

        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$(".HeaderMenu-dropdown").
                $$("li").find(text("Enterprise")).click();
        $(".Primer_Brand__Hero-module__Hero-actions___oH1NT")
                .shouldBe(text("Contact sales"));
    }

    @Disabled
    @ValueSource(strings = {
            "Start a free trial",
            "Contact sales"
    })
    @ParameterizedTest(name = "Проверка наличия текста - {0}")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    void testHaveTest(String searchQuery) {

        open("https://github.com");

        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$(".HeaderMenu-dropdown").
                $$("li").find(text("Enterprise")).click();
        $(".Primer_Brand__Hero-module__Hero-actions___oH1NT")
                .shouldBe(text(searchQuery));
    }

    @CsvSource(value = {
            "Start a free trial,https://github.com/organizations/enterprise_plan?ref_cta=Start+a+free+trial&ref_loc=hero&ref_page=%2Fenterprise",
            "Contact sales,https://github.com/enterprise/contact?ref_cta=Contact+Sales&ref_loc=hero&ref_page=%2Fenterprise&scid=&utm_campaign=Enterprise&utm_content=Enterprise&utm_medium=referral&utm_source=github"
    })
    @ParameterizedTest(name = "Проверка наличия текста - {0} и его ссылки {1}")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    void testHTest(String searchQuery, String expectedLink) {

        open("https://github.com");

        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$(".HeaderMenu-dropdown").
                $$("li").find(text("Enterprise")).click();
        $(".Primer_Brand__Hero-module__Hero-actions___oH1NT")
                .shouldBe(text(expectedLink));
    }
}