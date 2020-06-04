import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold2 {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/Sortable.html");

        WebElement three = driver.findElement(By.name("three"));
        Actions builder = new Actions(driver);
        builder.clickAndHold(three).moveByOffset(120,0).release().perform(); //not moving on y axis

        //now the tile aligns after it has been released
    }
}
