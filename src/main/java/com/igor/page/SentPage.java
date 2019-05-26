package com.igor.page;

import com.igor.model.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import java.util.List;
import java.util.stream.Collectors;

public class SentPage extends BasePage{
    @FindBy(xpath = "//div[@role='main']//tbody/tr")
    private List<WebElement> sentLetters;

    public List<Letter> getSentLetters() {
        return sentLetters
                .stream()
                .map(this::getLetterFromElement)
                .collect(Collectors.toList());
    }

    private Letter getLetterFromElement(WebElement element){
        WebElement receiverWE = element.findElement(By.xpath("./td[5]/div[2]/span[@email]"));
        WebElement messageWE1 = element.findElement(By.xpath(".//span[@class='bog']/../.."));
        String receiver = receiverWE.getAttribute("email");
        String[] mess = messageWE1.getText().split("\n");
        String topic = mess[0].trim();
        String message = mess.length == 3 ? mess[2].trim() : "";
        return new Letter(receiver, topic, message);
    }
}

