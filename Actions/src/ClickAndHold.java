import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHold {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/Sortable.html");

        Actions builder = new Actions(driver);
        builder.moveByOffset(200,20).clickAndHold().moveByOffset(120,0).perform();
        /*
        Each tile is 100 width and height 90 when we inspect the element.
        We have not released the tile
         */
    }
}
