import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class WebDriverNavigate {
    public static void main(String[] args) throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "/home/ashwin/Desktop/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.navigate().to("https://www.google.com/");

        WebElement searchBox = driver.findElement(By.name("q"));
        searchBox.sendKeys("Exploit Research");
        WebElement backGround = driver.findElement(By.id("viewport"));
        backGround.click();
        WebElement searchButton = driver.findElement(By.name("btnK"));
        searchButton.submit(); //somehow click does not seem to work

        //searchBox.clear();
        //searchBox.sendKeys("Malware analysis");

        driver.navigate().back();
        Thread.sleep(1000);
        driver.navigate().forward();
        driver.navigate().refresh();

        /*Below I don't know the reason why new object is to be created for webelement for this to work. doesnt work
        with old object searchBox
         */
        WebElement newSearchBox = driver.findElement(By.name("q"));
        newSearchBox.clear();
        newSearchBox.sendKeys("Malware analysis");
    }
}
