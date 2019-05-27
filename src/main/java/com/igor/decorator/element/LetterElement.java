package com.igor.decorator.element;

import com.igor.model.LetterModel;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LetterElement extends Element {
    private By receiverInLetter = By.xpath("./td[5]/div[2]/span[@email]");
    private By topicInLetter = By.xpath(".//span[@class='bog']");

    public LetterElement(WebElement webElement) {
        super(webElement);
    }

    public LetterModel getLetter(){
        String receiver = webElement.findElement(receiverInLetter).getAttribute("email");
        String topic = webElement.findElement(topicInLetter).getText().trim();
        //it doesn't matter with message, because topic is uniq hashcode
        return new LetterModel(receiver, topic, "");
    }
}
