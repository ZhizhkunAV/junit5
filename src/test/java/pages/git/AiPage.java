package pages.git;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class AiPage extends MainGitPage {
    private SelenideElement twoElements = $(".Primer_Brand__Hero-module__Hero-actions___oH1NT");

    public MainGitPage findTwoElements(String value) {
        twoElements.shouldBe(text(value));

        return this;
    }
}
