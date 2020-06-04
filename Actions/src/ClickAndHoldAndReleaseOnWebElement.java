import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;

public class ClickAndHoldAndReleaseOnWebElement {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/Sortable.html");

        WebElement three = driver.findElement(By.name("three"));
        WebElement two = driver.findElement(By.name("two"));
        WebElement five = driver.findElement(By.name("five"));
        WebElement eleven = driver.findElement(By.name("eleven"));

        Actions builder = new Actions(driver);
        builder.clickAndHold(three).release(two).perform();

        //All methods explained in these classes are in Actions class

       // builder.moveToElement(five).clickAndHold(five).release(eleven).perform();

    }
}
