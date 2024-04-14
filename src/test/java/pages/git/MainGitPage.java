package pages.git;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;

public class MainGitPage {
    public MainGitPage openPage() {
        open("https://github.com");

        return this;
    }

    public MainGitPage clickEnterprise() {
        $(".Header-old ").$$("li").findBy(text("Solutions")).hover().$(".HeaderMenu-dropdown").
                $$("li").find(text("Enterprise")).click();

        return this;
    }




}
