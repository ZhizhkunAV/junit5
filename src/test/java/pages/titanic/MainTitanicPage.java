package pages.titanic;

import pages.git.MainGitPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainTitanicPage {
    public MainTitanicPage openPageT() {
        open("https://titanicsociety.ru/");

        return this;
    }

    public MainTitanicPage clickLife() {
        $("#menu-item-197").hover().$("#menu-item-198").click();

        return this;
    }
}
