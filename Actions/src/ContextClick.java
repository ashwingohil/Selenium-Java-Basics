import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.Alert;

public class ContextClick {
    public static void main(String[] args){
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///home/ashwin/IdeaProjects/Selenium/Chapter2/src/ContextClick.html");

        WebElement contextMenu = driver.findElement(By.id("div-context"));
        Actions builder = new Actions(driver);
        builder.contextClick(contextMenu).click(driver.findElement(By.name("Item 3"))).perform();
        //driver.switchTo().alert().accept();

        /*
        The above line is true to function but below is simplified way of how it executes. WebDriver class has a method
        switchTo which returns WebDriver.TargetLocator instance. Also I can instantiate with webdriver object and
        it is the method in this class. Webdriver.TargetLocator is an interface so ChromeDriver the below most implementing
        class object is used. WebDriver.TargetLocator contains method alert which deals with alerts. It switches to
        currently active dialogue and returns Alert object. And Alert contains accept method
         */
        WebDriver.TargetLocator object = driver.switchTo();
        Alert alert_object = object.alert();
        alert_object.accept();

    }
}
