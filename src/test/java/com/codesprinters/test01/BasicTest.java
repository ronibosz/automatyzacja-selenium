package com.codesprinters.test01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class BasicTest {

    @Test
    public void verifyIfGoogleFindsCodeSprinters()throws InterruptedException{

        System.setProperty("webdriver.gecko.driver",
                            "C:\\bin\\geckodriver-v0.16.1-win64\\geckodriver.exe");
        System.setProperty("webdriver.firefox.bin",
                            "C:\\Program Files\\Mozilla Firefox new\\firefox.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
        driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        driver.get("https://www.google.com");

        WebElement googleSearchBox = driver.findElement(By.name("q"));
        googleSearchBox.sendKeys("Code Sprinters");
        googleSearchBox.sendKeys(Keys.ENTER);

        WebElement codeSprinters = driver.findElement(By.xpath("//a[text()='Code Sprinters -']"));
        codeSprinters.click();

        Thread.sleep(5000);

        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);

        Assert.assertEquals(currentUrl, "http://agileszkolenia.pl/");

        Thread.sleep(10000);


        if (driver!=null) {
            driver.quit();
        }
    }
}