package com.igor.page;

import com.igor.model.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.stream.Collectors;

public class SentPage extends BasePage {
    @FindBy(xpath = "//div[@role='main']//tbody/tr")
    private List<WebElement> sentLetters;
    private By receiverInLetter = By.xpath("./td[5]/div[2]/span[@email]");
    private By messageInLetter = By.xpath(".//span[@class='bog']/../..");

    public List<Letter> getSentLetters() {
        return sentLetters
                .stream()
                .map(this::getLetterFromElement)
                .collect(Collectors.toList());
    }

    private Letter getLetterFromElement(WebElement element) {
        String receiver = element.findElement(receiverInLetter).getAttribute("email");
        String[] mess = element.findElement(messageInLetter).getText().split("\n");
        String topic = mess[0].trim();
        //if elements is 3 then message has already appeared in the page
        String message = (mess.length == 3) ? mess[2].trim() : "";
        return new Letter(receiver, topic, message);
    }
}

