package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultModal {
    private final static String TITLE_TEXT = "Thanks for submitting the form";

    private SelenideElement
            header = $(".modal-header"),
            tableResult = $(".table-responsive table"),
            closeButton = $("#closeLargeModal");

    public ResultModal checkResultsVisible() {
        header.shouldHave(text(TITLE_TEXT));
        return this;
    }

    public ResultModal checkResult(String key, String value) {
        tableResult.$(byText(key))
                .parent().shouldHave(text(value));
        return this;
    }

    public ResultModal closeResultModal() {
        closeButton.click();
        return this;
    }
}
