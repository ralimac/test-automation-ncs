package com.aus.ncs;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

public class Form {
    private WebDriver driver;
    public Form(WebDriver driver) {
        this.driver = driver;
    }

    public void enterName(String name) {
        driver.findElement(By.id("name")).sendKeys(name);

    }

    public void enterEmail(String mail) {
        driver.findElement(By.id("email")).sendKeys(mail);
    }

    public void selectState(String state) {
        driver.findElement(By.cssSelector("div.v-select__selections")).click();

        List<WebElement> list = driver.findElements(By.cssSelector("[role=option]"));
        for(WebElement option: list){
            if(option.getText().equalsIgnoreCase(state)){
                option.click();
            }
        }
    }

    public void clickAgree() {
        driver.findElement(By.cssSelector("[for=agree]")).click();

    }

    public void submit() {
        for (WebElement button: driver.findElements(By.cssSelector("[type=button]"))) {
            if(button.getText().equalsIgnoreCase("submit")){
                button.click();
            }

        };
    }
}
