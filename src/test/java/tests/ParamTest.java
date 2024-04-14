package tests;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.git.AiPage;
import pages.git.MainGitPage;
import pages.titanic.LifeTitanicPage;
import pages.titanic.MainTitanicPage;
import org.junit.jupiter.params.ParameterizedTest;


@DisplayName("Параметризированные тесты, урок JUnit5")
public class ParamTest extends TestBase {
    MainGitPage maingitpage = new MainGitPage();
    AiPage aipage = new AiPage();
    MainTitanicPage maintitanicpage = new MainTitanicPage();
    LifeTitanicPage lifepage = new LifeTitanicPage();


    @Test
    @DisplayName("Простая проверка на наличие текста на сайте GitHub")
    void legacyHaveTextTest() {
        maingitpage.openPage()
                .clickEnterprise();
        aipage.findTwoElements("Start a free trial");
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
        maingitpage.openPage()
                .clickEnterprise();
        aipage.findTwoElements(searchQuery);
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

        maintitanicpage.openPageT()
                .clickLife();
        lifepage.checkText(expectedLink);

    }

    @CsvFileSource(resources = "/testdata/datafile.csv")
    @ParameterizedTest(name = "ParameterizedTest с использованием файла - CsvFileSource")
    @Tag("MAJOR")
    @DisplayName("CsvFileSource")

    void testHavetextParameterizedWithFileTest(String searchQuery, String expectedLink) {
        maintitanicpage.openPageT()
                .clickLife();
        lifepage.checkText(expectedLink);
    }
}
