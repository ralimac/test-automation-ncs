import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class seleniumTest {

    @Test
    public void submitForename(){

        String url = "https://d18u5zoaatmpxx.cloudfront.net/#/";
        WebElement by;

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        WebDriver driver = new ChromeDriver(options);


        //Navigate to url
        driver.get(url);

        //Validate WebPlayground
//        String s = ".h1.display-1.mb-3";
//        String locator = driver.findElement(By.cssSelector(s)).getText();

        String locator = driver.findElement(By.xpath("//h1[@class=\"display-1 mb-3\"]")).getText();
        assertEquals(locator, "Web Playground");

        // Click weird button
        String st = "//div/a[@role=\"button\"]";
        driver.findElement(By.xpath(st)).click();
        driver.findElement(By.xpath(st)).click();
        //Type "Rodrigo" in forename form
        by = driver.findElement(By.id("forename"));
        by.sendKeys("Rodrigo");



        //Click Submit
        by = driver.findElement(By.id("submit"));
        by.click();

        driver.quit();

    }
}
