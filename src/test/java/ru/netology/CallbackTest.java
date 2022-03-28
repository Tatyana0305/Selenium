package ru.netology;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CallbackTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll(){
        System.setProperty("webdriver.chrome.driver", "./driver/win/chromedriver.exe");
    }
    @BeforeEach
    void setUp(){
        driver = new ChromeDriver();
    }
    @AfterEach
    void tearDown(){
        driver.quit();
        driver=null;
    }
    @Test
    public void sendForm() {
        driver.get("http://localhost:9999");
        List<WebElement> textFields = driver.findElements(By.className("input__control"));
        textFields.get(0).sendKeys("Иван");
        textFields.get(1).sendKeys("+78002000000");
        driver.findElement(By.className("checkbox__box")).click();
        driver.findElement(By.tagName("button")).click();
        String actualText = driver.findElement(By.className("alert-success")).getText().trim();
        String expected = "Ваша заявка успешно отправлена!";
        assertEquals(expected, actualText);

    }

}
