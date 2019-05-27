package com.igor.page;

import com.igor.decorator.element.LetterElement;
import com.igor.model.LetterModel;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SentPage extends BasePage {
    @FindBy(xpath = "//div[@role='main']//tbody/tr")
    private List<LetterElement> sentLetters;

    public List<LetterModel> getSentLetters() {
        return sentLetters
                .stream()
                .map(LetterElement::getLetter)
                .collect(Collectors.toList());
    }
}

