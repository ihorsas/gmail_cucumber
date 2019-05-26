package com.igor.page;

import com.igor.model.Letter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class SentPage extends BasePage{
    @FindBy(xpath = "//div[@role='main']//tbody/tr")
    private List<WebElement> sentLetters;

    public List<Letter> getSentLetter() {
        List<Letter> letters = new ArrayList<>();
        String receiver, topic, message;
        for(WebElement element : sentLetters) {
            WebElement receiverWE = element.findElement(By.xpath("./td[5]/div[2]/span[@email]"));
            WebElement topicWE = element.findElement(By.xpath(".//span[@class='bog']"));
            WebElement messageWE = topicWE.findElement(By.xpath("./../../span"));
            receiver = receiverWE.getAttribute("email");
            topic = topicWE.getText();
            message = messageWE.getText().replace("\n", "").replace("-", "").trim();
            letters.add(new Letter(receiver, topic, message));
        }
        return letters;
    }
}

