package com.aus.ncs;

import com.aus.ncs.Form;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumTest {

    public WebDriver driver = getWebDriver();
    String url = "https://d18u5zoaatmpxx.cloudfront.net/#/";
    WebElement by;
    @BeforeEach
    public void setup(){

        //Navigate to url
        driver.get(url);

    }


    @Test
    public void changeForename() {
     //Type "Rodrigo" in forename form
        by = driver.findElement(By.id("forename"));
        by.sendKeys("Rodrigo");
    }

    @Test
    public void submitForename() {
        //Click Submit
        by = driver.findElement(By.id("submit"));
        by.click();

    }
    @Test
    public void validateWebPlayground() {
        //Click Submit
        String locator = driver.findElement(By.xpath("//h1[@class=\"display-1 mb-3\"]")).getText();
        assertEquals(locator, "Web Playground");

    }
    @Test
    public void clickDown() {
        //Click Submit
        WebElement buttonElement = driver.findElement(By.cssSelector("[role=button]"));
        buttonElement.click();
        assertEquals("CLICK ME UP!", buttonElement.getText());
    }
    @Test
    public void clickUp() {
        WebElement buttonElement = driver.findElement(By.cssSelector("[role=button]"));
        buttonElement.click();
        new WebDriverWait(driver, Duration.ofSeconds(4));
        assertEquals("CLICK ME DOWN!", buttonElement.getText());
    }

    @Test
    public void formSubmit(){
        driver.findElement(By.cssSelector("[aria-label=forms]")).click();
        Form form = new Form(driver);
        form.enterName("Rodrigo");
        form.enterEmail("rodrigo@ocara.com");
        form.selectState("nsw");
        form.clickAgree();
        form.submit();

        //assertEquals("Forms",driver.findElement(By.cssSelector("h1.mb-3")).getText());


        //driver.findElement(By.id("state")).click();



        new WebDriverWait(driver, Duration.ofSeconds(15)).until(ExpectedConditions.visibilityOfElementLocated(By.className("popup-message")));
        assertEquals("Thanks for your feedback Rodrigo", driver.findElement(By.className("popup-message")).getText());



    }


    private WebDriver getWebDriver(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);
        return driver;
    }

    @AfterEach
    public void clean(){
        driver.quit();
    }
}
