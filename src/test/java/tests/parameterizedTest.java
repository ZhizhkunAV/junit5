package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

@DisplayName("Параметризированные тесты, урок JUnit5")
public class parameterizedTest {


    @Disabled
    @Test
    @DisplayName("Простая проверка на наличие текста на сайте GitHub")
    void legacyHaveTextTest() {

        open("https://github.com");

        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$(".HeaderMenu-dropdown").
                $$("li").find(text("Enterprise")).click();
        $(".Primer_Brand__Hero-module__Hero-actions___oH1NT")
                .shouldBe(text("Contact sales"));
    }


    @ValueSource(strings = {
            "Start a free trial",
            "Contact sales"
    })
    @ParameterizedTest(name = "Проверка наличия текста - {0} на сайте  GitHub")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    @DisplayName("ParameterizedTest для использования одного значения - ValueSource")
    void testHaveTextParameterizedTest(String searchQuery) {

        open("https://github.com");

        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$(".HeaderMenu-dropdown").
                $$("li").find(text("Enterprise")).click();
        $(".Primer_Brand__Hero-module__Hero-actions___oH1NT")
                .shouldBe(text(searchQuery));
    }


    @CsvSource(value = {
            "Первый офицер «Титаника» — Уильям МакМастер Мердок,22.02.2020"
    })
    @ParameterizedTest(name = "Проверка наличия текста - {0} и его даты публикации {1}")
    @Tags({
            @Tag("WEB"),
            @Tag("BLOCKER")
    })
    @DisplayName("ParameterizedTest для использования двух значений - CsvSource")
    void testHavetextParameterizedTest(String searchQuery, String expectedLink) {

        open("https://titanicsociety.ru/");

        $("#menu-item-197").hover().$("#menu-item-198").click();
        $(".post-4696")
                .shouldBe(text(expectedLink));

    }

    @CsvFileSource(resources = "/testdata/datafile.csv")

    @ParameterizedTest(name = "ParameterizedTest с использованием файла для использования двух значений - CsvFileSource")
    @Tag("MAJOR")
    @DisplayName("CsvFileSource")

    void testHavetextParameterizedWithFileTest(String searchQuery, String expectedLink) {

        open("https://titanicsociety.ru/");

        $("#menu-item-197").hover().$("#menu-item-198").click();
        $(".post-4696")
                .shouldBe(text(expectedLink));

    }
}
