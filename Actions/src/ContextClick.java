import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ContextClick {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/ContextClick.html");

        WebElement contextMenu = driver.findElement(By.id("div-context"));
        Actions builder = new Actions(driver);
        builder.contextClick(contextMenu).click(driver.findElement(By.name("Item 3"))).perform();
    }
}
