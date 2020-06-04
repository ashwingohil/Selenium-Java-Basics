package webdriver.chapter2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.Keys;

public class ActionBuildPerform {
    public static void main(String[] args){

        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/Selectable.html");

        WebElement one = driver.findElement(By.name("one"));
        WebElement three = driver.findElement(By.name("three"));
        WebElement five = driver.findElement(By.name("five"));

        Actions builder = new Actions(driver);
        builder.keyDown(Keys.CONTROL).click(one).click(three).click(five).keyUp(Keys.CONTROL);

        Action compositeAction = builder.build();
        compositeAction.perform();


    }
}


