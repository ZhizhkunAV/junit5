package pages.titanic;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class LifeTitanicPage {
    public LifeTitanicPage checkText(String value) {
        $(".post-4696")
                .shouldBe(text(value));

        return this;
    }
}
